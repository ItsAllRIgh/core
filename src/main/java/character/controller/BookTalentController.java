package character.controller;

import character.model.Book;
import character.model.BookReference;
import character.model.BookTalent;
import character.repository.BookReferenceRepository;
import character.repository.BookRepository;
import character.repository.BookTalentRepository;
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

public class BookTalentController {
    private final BookRepository bookRepository;
    private final BookTalentRepository bookTalentRepository;
    private final BookReferenceRepository referenceRepository;

    @Autowired
    public BookTalentController(BookRepository bookRepository, BookReferenceRepository referenceRepository, BookTalentRepository bookTalentRepository) {
        this.referenceRepository = referenceRepository;
        this.bookTalentRepository = bookTalentRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = {"/species/addAttachment"}, method = RequestMethod.GET)
    public String addBookTalentForm(ModelMap model) {
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("species", new BookTalent());
        model.addAttribute("books", books);
        return "species/new";
    }

    @RequestMapping(value = {"/species/addAttachment"}, params = {"addRef"}, method = RequestMethod.POST)
    public String addBookTalentFormRef(ModelMap model, @ModelAttribute("species") BookTalent species) {
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
    public String removeBookTalentFormRef(ModelMap model, @ModelAttribute("species") BookTalent species, HttpServletRequest req) {
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
    public String addBookTalent(@ModelAttribute("species") BookTalent species, ModelMap modelMap) {
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

        this.bookTalentRepository.save(species);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        List speciesList = this.bookTalentRepository.findAll();
        modelMap.addAttribute("speciesList", speciesList);
        return "redirect:speciesList";
    }

    @RequestMapping(value = {"/species", "/species/speciesList"}, method = RequestMethod.GET)
    public String getBookTalentList(@ModelAttribute Book species, Model model) {
        List speciesList = this.bookTalentRepository.findAll();
        model.addAttribute("speciesList", speciesList);
        return "species/speciesList";
    }

    @RequestMapping(value = "species/{id}", method = RequestMethod.GET)//, headers="Accept=application/json"
    public String getBookTalent(@PathVariable("id") long id, Model model) {
        BookTalent species = this.bookTalentRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("species", species);
        return "species/species";
    }

    @RequestMapping(value = "species/{id}", method = RequestMethod.DELETE)//, headers="Accept=application/json"
    public String deleteBookTalent(@PathVariable("id") long id, Model model) {
        BookTalent species = this.bookTalentRepository.findOne(id);
        if (species != null) {
            this.bookTalentRepository.delete(species);
        }
        List references = this.bookTalentRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("speciesList", species);
        return "species/speciesList";
    }

    @RequestMapping(value = "species/update/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable("id") long id, @ModelAttribute("species") Book species, ModelMap modelMap) {
        BookTalent dbBookTalent = this.bookTalentRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        modelMap.addAttribute("species", dbBookTalent);
        return "species/update";
    }

    @RequestMapping(value = "species/{id}", method = RequestMethod.PUT)
    public String updateBookTalent(@PathVariable("id") long id, @ModelAttribute("species") BookTalent species, ModelMap modelMap) {
        species.setTalentId(id);
        this.bookTalentRepository.save(species);
        modelMap.addAttribute("species", species);
        return "species/species";
    }
}
