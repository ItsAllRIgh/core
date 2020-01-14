package character.controller;

import character.model.Book;
import character.model.BookReference;
import character.model.BookSkills;
import character.repository.BookReferenceRepository;
import character.repository.BookRepository;
import character.repository.BookSkillsRepository;
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

public class BookSkillsController {
    private final BookRepository bookRepository;
    private final BookSkillsRepository bookAttachmentsRepository;
    private final BookReferenceRepository referenceRepository;

    @Autowired
    public BookSkillsController(BookRepository bookRepository, BookReferenceRepository referenceRepository, BookSkillsRepository bookAttachmentsRepository) {
        this.referenceRepository = referenceRepository;
        this.bookAttachmentsRepository = bookAttachmentsRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = {"/skill/addAttachment"}, method = RequestMethod.GET)
    public String addBookSkillsForm(ModelMap model) {
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("skill", new BookSkills());
        model.addAttribute("books", books);
        return "skill/new";
    }

    @RequestMapping(value = {"/skill/addAttachment"}, params = {"addRef"}, method = RequestMethod.POST)
    public String addBookSkillsFormRef(ModelMap model, @ModelAttribute("skill") BookSkills skill) {
        if (skill.getBookReferences() == null) {
            skill.setBookReferences(new ArrayList<BookReference>());
        }
        skill.getBookReferences().add(new BookReference());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("skill", skill);
        model.addAttribute("books", books);
        return "skill/new";
    }

    @RequestMapping(value = {"/skill/addAttachment"}, params = {"removeRef"}, method = RequestMethod.POST)
    public String removeBookSkillsFormRef(ModelMap model, @ModelAttribute("skill") BookSkills skill, HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRef"));
        skill.getBookReferences().remove(rowId.intValue());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("skill", skill);
        model.addAttribute("books", books);
        return "skill/new";
    }

    @RequestMapping(value = "/skill/addAttachment", method = RequestMethod.POST)
    public String addBookSkills(@ModelAttribute("skill") BookSkills skill, ModelMap modelMap) {
        modelMap.addAttribute("skill", skill);
        if (skill.getBookReferences() == null) {
            skill.setBookReferences(new ArrayList<BookReference>());
        }
        for (int i = 0; i < skill.getBookReferences().size(); i++) {
            BookReference reference = skill.getBookReferences().remove(i);
            if (this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber()) != null) {
                // replace with already persisted reference
                reference = this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber());
            }
            skill.getBookReferences().add(reference);
        }

        this.bookAttachmentsRepository.save(skill);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        List skills = this.bookAttachmentsRepository.findAll();
        modelMap.addAttribute("skills", skills);
        return "redirect:skills";
    }

    @RequestMapping(value = {"/skill", "/skill/skills"}, method = RequestMethod.GET)
    public String getBookSkillsList(@ModelAttribute Book skill, Model model) {
        List skills = this.bookAttachmentsRepository.findAll();
        model.addAttribute("skills", skills);
        return "skill/skills";
    }

    @RequestMapping(value = "skill/{id}", method = RequestMethod.GET)//, headers="Accept=application/json"
    public String getBookSkills(@PathVariable("id") long id, Model model) {
        BookSkills skill = this.bookAttachmentsRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("skill", skill);
        return "skill/skill";
    }

    @RequestMapping(value = "skill/{id}", method = RequestMethod.DELETE)//, headers="Accept=application/json"
    public String deleteBookSkills(@PathVariable("id") long id, Model model) {
        BookSkills skill = this.bookAttachmentsRepository.findOne(id);
        if (skill != null) {
            this.bookAttachmentsRepository.delete(skill);
        }
        List references = this.bookAttachmentsRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("skills", skill);
        return "skill/skills";
    }

    @RequestMapping(value = "skill/update/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable("id") long id, @ModelAttribute("skill") Book skill, ModelMap modelMap) {
        BookSkills dbBookSkills = this.bookAttachmentsRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        modelMap.addAttribute("skill", dbBookSkills);
        return "skill/update";
    }

    @RequestMapping(value = "skill/{id}", method = RequestMethod.PUT)
    public String updateBookSkills(@PathVariable("id") long id, @ModelAttribute("skill") BookSkills skill, ModelMap modelMap) {
        skill.setSkillId(id);
        this.bookAttachmentsRepository.save(skill);
        modelMap.addAttribute("skill", skill);
        return "skill/skill";
    }
}
