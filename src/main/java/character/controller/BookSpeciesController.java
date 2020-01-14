package character.controller;

import character.model.Book;
import character.model.BookReference;
import character.model.BookSpecies;
import character.repository.BookReferenceRepository;
import character.repository.BookRepository;
import character.repository.BookSpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class BookSpeciesController {
    private final BookRepository bookRepository;
    private final BookSpeciesRepository bookSpeciesRepository;
    private final BookReferenceRepository referenceRepository;

    @Autowired
    public BookSpeciesController(BookRepository bookRepository, BookReferenceRepository referenceRepository, BookSpeciesRepository bookSpeciesRepository) {
        this.referenceRepository = referenceRepository;
        this.bookSpeciesRepository = bookSpeciesRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = {"/species/addAttachment"}, method = RequestMethod.GET)
    public String addBookSpeciesForm(ModelMap model) {
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("species", new BookSpecies());
        model.addAttribute("books", books);
        return "species/new";
    }

    @RequestMapping(value = {"/species/addAttachment"}, params = {"addRef"}, method = RequestMethod.POST)
    public String addBookSpeciesFormRef(ModelMap model, @ModelAttribute("species") BookSpecies species) {
        if (species.getBookReferences() == null) {
            species.setBookReferences(new ArrayList<BookReference>());
        }
        species.getBookReferences().add(new BookReference());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("species", species);
        model.addAttribute("books", books);
        return "species/new";
    }

    @RequestMapping(value = {"/species/addAttachment"}, params = {"removeRef"}, method = RequestMethod.POST)
    public String removeBookSpeciesFormRef(ModelMap model, @ModelAttribute("species") BookSpecies species, HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRef"));
        species.getBookReferences().remove(rowId.intValue());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("species", species);
        model.addAttribute("books", books);
        return "species/new";
    }

    @RequestMapping(value = "/species/addAttachment", method = RequestMethod.POST)
    public String addBookSpecies(@ModelAttribute("species") BookSpecies species, ModelMap modelMap) {
        modelMap.addAttribute("species", species);
        if (species.getBookReferences() == null) {
            species.setBookReferences(new ArrayList<BookReference>());
        }
        for (int i = 0; i < species.getBookReferences().size(); i++) {
            BookReference reference = species.getBookReferences().remove(i);
            if (this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber()) != null) {
                // replace with already persisted reference
                reference = this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber());
            }
            species.getBookReferences().add(reference);
        }

        this.bookSpeciesRepository.save(species);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        List speciesList = this.bookSpeciesRepository.findAll();
        modelMap.addAttribute("speciesList", speciesList);
        return "redirect:speciesList";
    }

    @RequestMapping(value = {"/species", "/species/speciesList"}, method = RequestMethod.GET)
    public String getBookSpeciesList(@ModelAttribute Book species, Model model) {
        List speciesList = this.bookSpeciesRepository.findAll();
        model.addAttribute("speciesList", speciesList);
        return "species/speciesList";
    }

    @RequestMapping(value = "species/{id}", method = RequestMethod.GET)//, headers="Accept=application/json"
    public String getBookSpecies(@PathVariable("id") long id, Model model) {
        BookSpecies species = this.bookSpeciesRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("species", species);
        return "species/species";
    }

    @RequestMapping(value = "species/{id}", method = RequestMethod.DELETE)//, headers="Accept=application/json"
    public String deleteBookSpecies(@PathVariable("id") long id, Model model) {
        BookSpecies species = this.bookSpeciesRepository.findOne(id);
        if (species != null) {
            this.bookSpeciesRepository.delete(species);
        }
        List references = this.bookSpeciesRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("speciesList", species);
        return "species/speciesList";
    }

    @RequestMapping(value = "species/update/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable("id") long id, @ModelAttribute("species") Book species, ModelMap modelMap) {
        BookSpecies dbBookSpecies = this.bookSpeciesRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        modelMap.addAttribute("species", dbBookSpecies);
        return "species/update";
    }

    @RequestMapping(value = "species/{id}", method = RequestMethod.PUT)
    public String updateBookSpecies(@PathVariable("id") long id, @ModelAttribute("species") BookSpecies species, ModelMap modelMap) {
        species.setSpeciesId(id);
        this.bookSpeciesRepository.save(species);
        modelMap.addAttribute("species", species);
        return "species/species";
    }
}
