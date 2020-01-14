package character.controller;

import character.model.Book;
import character.model.BookReference;
import character.model.BookStarship;
import character.model.StarshipType;
import character.repository.BookReferenceRepository;
import character.repository.BookRepository;
import character.repository.BookStarshipRepository;
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

public class BookStarshipController {
    private final BookRepository bookRepository;
    private final BookStarshipRepository starshipRepository;
    private final BookReferenceRepository referenceRepository;

    @Autowired
    public BookStarshipController(BookRepository bookRepository, BookReferenceRepository referenceRepository, BookStarshipRepository starshipRepository) {
        this.referenceRepository = referenceRepository;
        this.starshipRepository = starshipRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = {"/starship/addArmor"}, method = RequestMethod.GET)
    public String addBookStarshipForm(ModelMap model) {
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("types", StarshipType.values());
        model.addAttribute("references", references);
        model.addAttribute("starship", new BookStarship());
        model.addAttribute("books", books);
        return "starship/new";
    }

    @RequestMapping(value = {"/starship/addArmor"}, params = {"addRef"}, method = RequestMethod.POST)
    public String addBookStarshipFormRef(ModelMap model, @ModelAttribute("starship") BookStarship starship) {
        if (starship.getBookReferences() == null) {
            starship.setBookReferences(new ArrayList<BookReference>());
        }
        starship.getBookReferences().add(new BookReference());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("types", StarshipType.values());
        model.addAttribute("references", references);
        model.addAttribute("starship", starship);
        model.addAttribute("books", books);
        return "starship/new";
    }

    @RequestMapping(value = {"/starship/addArmor"}, params = {"removeRef"}, method = RequestMethod.POST)
    public String removeBookStarshipFormRef(ModelMap model, @ModelAttribute("starship") BookStarship starship, HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRef"));
        starship.getBookReferences().remove(rowId.intValue());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("types", StarshipType.values());
        model.addAttribute("references", references);
        model.addAttribute("starship", starship);
        model.addAttribute("books", books);
        return "starship/new";
    }

    @RequestMapping(value = "/starship/addArmor", method = RequestMethod.POST)
    public String addBookStarship(@ModelAttribute("starship") BookStarship starship, ModelMap modelMap) {
        modelMap.addAttribute("starship", starship);
        if (starship.getBookReferences() == null) {
            starship.setBookReferences(new ArrayList<BookReference>());
        }
        for (int i = 0; i < starship.getBookReferences().size(); i++) {
            BookReference reference = starship.getBookReferences().remove(i);
            if (this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber()) != null) {
                // replace with already persisted reference
                reference = this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber());
            }
            starship.getBookReferences().add(reference);
        }

        this.starshipRepository.save(starship);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        List abilities = this.starshipRepository.findAll();
        modelMap.addAttribute("abilities", abilities);
        return "redirect:abilities";
    }

    @RequestMapping(value = {"/starship", "/starship/abilities"}, method = RequestMethod.GET)
    public String getBookStarshipList(@ModelAttribute Book starship, Model model) {
        List abilities = this.starshipRepository.findAll();
        model.addAttribute("abilities", abilities);
        return "starship/abilities";
    }

    @RequestMapping(value = "starship/{id}", method = RequestMethod.GET)//, headers="Accept=application/json"
    public String getBookStarship(@PathVariable("id") long id, Model model) {
        BookStarship starship = this.starshipRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("starship", starship);
        return "starship/starship";
    }

    @RequestMapping(value = "starship/{id}", method = RequestMethod.DELETE)//, headers="Accept=application/json"
    public String deleteBookStarship(@PathVariable("id") long id, Model model) {
        BookStarship starship = this.starshipRepository.findOne(id);
        if (starship != null) {
            this.starshipRepository.delete(starship);
        }
        List references = this.starshipRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("abilities", starship);
        return "starship/abilities";
    }

    @RequestMapping(value = "starship/update/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable("id") long id, @ModelAttribute("starship") Book starship, ModelMap modelMap) {
        BookStarship dbBookStarship = this.starshipRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("types", StarshipType.values());
        modelMap.addAttribute("references", references);
        modelMap.addAttribute("starship", dbBookStarship);
        return "starship/update";
    }

    @RequestMapping(value = "starship/{id}", method = RequestMethod.PUT)
    public String updateBookStarship(@PathVariable("id") long id, @ModelAttribute("starship") BookStarship starship, ModelMap modelMap) {
        starship.setVehicleId(id);
        this.starshipRepository.save(starship);
        modelMap.addAttribute("types", StarshipType.values());
        modelMap.addAttribute("starship", starship);
        return "starship/starship";
    }
}
