package character.controller;

import character.model.Book;
import character.model.BookAbility;
import character.model.BookReference;
import character.repository.BookAbilityRepository;
import character.repository.BookReferenceRepository;
import character.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BookAbilityController {

    private final BookRepository bookRepository;
    private final BookAbilityRepository abilityRepository;
    private final BookReferenceRepository referenceRepository;

    @Autowired
    public BookAbilityController(BookRepository bookRepository, BookReferenceRepository referenceRepository, BookAbilityRepository abilityRepository) {
        this.referenceRepository = referenceRepository;
        this.abilityRepository = abilityRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = {"/ability/addAbility"}, method = RequestMethod.GET)
    public String addBookAbilityForm(ModelMap model) {
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("ability", new BookAbility());
        model.addAttribute("books", books);
        return "ability/new";
    }

    @RequestMapping(value = {"/ability/addAbility"}, params = {"addRef"}, method = RequestMethod.POST)
    public String addBookAbilityFormRef(ModelMap model, @ModelAttribute("ability") BookAbility ability) {
        if (ability.getBookReferences() == null) {
            ability.setBookReferences(new ArrayList<BookReference>());
        }
        ability.getBookReferences().add(new BookReference());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("ability", ability);
        model.addAttribute("books", books);
        return "ability/new";
    }

    @RequestMapping(value = {"/ability/addAbility"}, params = {"removeRef"}, method = RequestMethod.POST)
    public String removeBookAbilityFormRef(ModelMap model, @ModelAttribute("ability") BookAbility ability, HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRef"));
        ability.getBookReferences().remove(rowId.intValue());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("ability", ability);
        model.addAttribute("books", books);
        return "ability/new";
    }

    @RequestMapping(value = "/ability/addAbility", method = RequestMethod.POST)
    public String addBookAbility(@ModelAttribute("ability") BookAbility ability, ModelMap modelMap) {
        modelMap.addAttribute("ability", ability);
        if (ability.getBookReferences() == null) {
            ability.setBookReferences(new ArrayList<BookReference>());
        }
        for (int i = 0; i < ability.getBookReferences().size(); i++) {
            BookReference reference = ability.getBookReferences().remove(i);
            if (this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber()) != null) {
                // replace with already persisted reference
                reference = this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber());
            }
            ability.getBookReferences().add(reference);
        }

        this.abilityRepository.save(ability);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        List abilities = this.abilityRepository.findAll();
        modelMap.addAttribute("abilities", abilities);
        return "redirect:abilities";
    }

    @RequestMapping(value = {"/ability", "/ability/abilities"}, method = RequestMethod.GET)
    public String getBookAbilityList(@ModelAttribute Book ability, Model model) {
        List abilities = this.abilityRepository.findAll();
        model.addAttribute("abilities", abilities);
        return "ability/abilities";
    }

    @RequestMapping(value = "ability/{id}", method = RequestMethod.GET)//, headers="Accept=application/json"
    public String getBookAbility(@PathVariable("id") long id, Model model) {
        BookAbility ability = this.abilityRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("ability", ability);
        return "ability/ability";
    }

    @RequestMapping(value = "ability/{id}", method = RequestMethod.DELETE)//, headers="Accept=application/json"
    public String deleteBookAbility(@PathVariable("id") long id, Model model) {
        BookAbility ability = this.abilityRepository.findOne(id);
        if (ability != null) {
            this.abilityRepository.delete(ability);
        }
        List references = this.abilityRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("abilities", ability);
        return "ability/abilities";
    }

    @RequestMapping(value = "ability/update/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable("id") long id, @ModelAttribute("ability") Book ability, ModelMap modelMap) {
        BookAbility dbBookAbility = this.abilityRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        modelMap.addAttribute("ability", dbBookAbility);
        return "ability/update";
    }

    @RequestMapping(value = "ability/{id}", method = RequestMethod.PUT)
    public String updateBookAbility(@PathVariable("id") long id, @ModelAttribute("ability") BookAbility ability, ModelMap modelMap) {
        ability.setAbilityId(id);
        this.abilityRepository.save(ability);
        modelMap.addAttribute("ability", ability);
        return "ability/ability";
    }

    private BookAbility findAbilityById(Long id) {
        BookAbility ability = this.abilityRepository.findOne(id);
        return ability;
    }

    private BookReference findAbilityById(long id) {
        BookReference reference = this.referenceRepository.findOne(id);

        return reference;
    }

}
