package character.controller;

import character.model.Book;
import character.model.BookArmor;
import character.model.BookReference;
import character.repository.BookArmorRepository;
import character.repository.BookReferenceRepository;
import character.repository.BookRepository;
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

public class BookArmorController {
    private final BookRepository bookRepository;
    private final BookArmorRepository armorRepository;
    private final BookReferenceRepository referenceRepository;

    @Autowired
    public BookArmorController(BookRepository bookRepository, BookReferenceRepository referenceRepository, BookArmorRepository armorRepository) {
        this.referenceRepository = referenceRepository;
        this.armorRepository = armorRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = {"/armor/addArmor"}, method = RequestMethod.GET)
    public String addBookArmorForm(ModelMap model) {
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("armor", new BookArmor());
        model.addAttribute("books", books);
        return "armor/new";
    }

    @RequestMapping(value = {"/armor/addArmor"}, params = {"addRef"}, method = RequestMethod.POST)
    public String addBookArmorFormRef(ModelMap model, @ModelAttribute("armor") BookArmor armor) {
        if (armor.getBookReferences() == null) {
            armor.setBookReferences(new ArrayList<BookReference>());
        }
        armor.getBookReferences().add(new BookReference());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("armor", armor);
        model.addAttribute("books", books);
        return "armor/new";
    }

    @RequestMapping(value = {"/armor/addArmor"}, params = {"removeRef"}, method = RequestMethod.POST)
    public String removeBookArmorFormRef(ModelMap model, @ModelAttribute("armor") BookArmor armor, HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRef"));
        armor.getBookReferences().remove(rowId.intValue());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("armor", armor);
        model.addAttribute("books", books);
        return "armor/new";
    }

    @RequestMapping(value = "/armor/addArmor", method = RequestMethod.POST)
    public String addBookArmor(@ModelAttribute("armor") BookArmor armor, ModelMap modelMap) {
        modelMap.addAttribute("armor", armor);
        if (armor.getBookReferences() == null) {
            armor.setBookReferences(new ArrayList<BookReference>());
        }
        for (int i = 0; i < armor.getBookReferences().size(); i++) {
            BookReference reference = armor.getBookReferences().remove(i);
            if (this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber()) != null) {
                // replace with already persisted reference
                reference = this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber());
            }
            armor.getBookReferences().add(reference);
        }

        this.armorRepository.save(armor);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        List abilities = this.armorRepository.findAll();
        modelMap.addAttribute("abilities", abilities);
        return "redirect:abilities";
    }

    @RequestMapping(value = {"/armor", "/armor/abilities"}, method = RequestMethod.GET)
    public String getBookArmorList(@ModelAttribute Book armor, Model model) {
        List abilities = this.armorRepository.findAll();
        model.addAttribute("abilities", abilities);
        return "armor/abilities";
    }

    @RequestMapping(value = "armor/{id}", method = RequestMethod.GET)//, headers="Accept=application/json"
    public String getBookArmor(@PathVariable("id") long id, Model model) {
        BookArmor armor = this.armorRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("armor", armor);
        return "armor/armor";
    }

    @RequestMapping(value = "armor/{id}", method = RequestMethod.DELETE)//, headers="Accept=application/json"
    public String deleteBookArmor(@PathVariable("id") long id, Model model) {
        BookArmor armor = this.armorRepository.findOne(id);
        if (armor != null) {
            this.armorRepository.delete(armor);
        }
        List references = this.armorRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("abilities", armor);
        return "armor/abilities";
    }

    @RequestMapping(value = "armor/update/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable("id") long id, @ModelAttribute("armor") Book armor, ModelMap modelMap) {
        BookArmor dbBookArmor = this.armorRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        modelMap.addAttribute("armor", dbBookArmor);
        return "armor/update";
    }

    @RequestMapping(value = "armor/{id}", method = RequestMethod.PUT)
    public String updateBookArmor(@PathVariable("id") long id, @ModelAttribute("armor") BookArmor armor, ModelMap modelMap) {
        armor.setArmorId(id);
        this.armorRepository.save(armor);
        modelMap.addAttribute("armor", armor);
        return "armor/armor";
    }

}
