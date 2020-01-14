package character.controller;

import character.model.Book;
import character.model.BookGear;
import character.model.BookReference;
import character.repository.BookGearRepository;
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

public class BookGearController {
    private final BookRepository bookRepository;
    private final BookGearRepository bookGearRepository;
    private final BookReferenceRepository referenceRepository;

    @Autowired
    public BookGearController(BookRepository bookRepository, BookReferenceRepository referenceRepository, BookGearRepository bookGearRepository) {
        this.referenceRepository = referenceRepository;
        this.bookGearRepository = bookGearRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = {"/gear/addGear"}, method = RequestMethod.GET)
    public String addBookGearForm(ModelMap model) {
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("gear", new BookGear());
        model.addAttribute("books", books);
        return "gear/new";
    }

    @RequestMapping(value = {"/gear/addGear"}, params = {"addRef"}, method = RequestMethod.POST)
    public String addBookGearFormRef(ModelMap model, @ModelAttribute("gear") BookGear gear) {
        if (gear.getBookReferences() == null) {
            gear.setBookReferences(new ArrayList<BookReference>());
        }
        gear.getBookReferences().add(new BookReference());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("gear", gear);
        model.addAttribute("books", books);
        return "gear/new";
    }

    @RequestMapping(value = {"/gear/addGear"}, params = {"removeRef"}, method = RequestMethod.POST)
    public String removeBookGearFormRef(ModelMap model, @ModelAttribute("gear") BookGear gear, HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRef"));
        gear.getBookReferences().remove(rowId.intValue());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("gear", gear);
        model.addAttribute("books", books);
        return "gear/new";
    }

    @RequestMapping(value = "/gear/addGear", method = RequestMethod.POST)
    public String addBookGear(@ModelAttribute("gear") BookGear gear, ModelMap modelMap) {
        modelMap.addAttribute("gear", gear);
        if (gear.getBookReferences() == null) {
            gear.setBookReferences(new ArrayList<BookReference>());
        }
        for (int i = 0; i < gear.getBookReferences().size(); i++) {
            BookReference reference = gear.getBookReferences().remove(i);
            if (this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber()) != null) {
                // replace with already persisted reference
                reference = this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber());
            }
            gear.getBookReferences().add(reference);
        }

        this.bookGearRepository.save(gear);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        List gears = this.bookGearRepository.findAll();
        modelMap.addAttribute("gears", gears);
        return "redirect:gears";
    }

    @RequestMapping(value = {"/gear", "/gear/gears"}, method = RequestMethod.GET)
    public String getBookGearList(@ModelAttribute Book gear, Model model) {
        List gears = this.bookGearRepository.findAll();
        model.addAttribute("gears", gears);
        return "gear/gears";
    }

    @RequestMapping(value = "gear/{id}", method = RequestMethod.GET)//, headers="Accept=application/json"
    public String getBookGear(@PathVariable("id") long id, Model model) {
        BookGear gear = this.bookGearRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("gear", gear);
        return "gear/gear";
    }

    @RequestMapping(value = "gear/{id}", method = RequestMethod.DELETE)//, headers="Accept=application/json"
    public String deleteBookGear(@PathVariable("id") long id, Model model) {
        BookGear gear = this.bookGearRepository.findOne(id);
        if (gear != null) {
            this.bookGearRepository.delete(gear);
        }
        List references = this.bookGearRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("gears", gear);
        return "gear/gears";
    }

    @RequestMapping(value = "gear/update/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable("id") long id, @ModelAttribute("gear") Book gear, ModelMap modelMap) {
        BookGear dbBookGear = this.bookGearRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        modelMap.addAttribute("gear", dbBookGear);
        return "gear/update";
    }

    @RequestMapping(value = "gear/{id}", method = RequestMethod.PUT)
    public String updateBookGear(@PathVariable("id") long id, @ModelAttribute("gear") BookGear gear, ModelMap modelMap) {
        gear.setGearId(id);
        this.bookGearRepository.save(gear);
        modelMap.addAttribute("gear", gear);
        return "gear/gear";
    }
}
