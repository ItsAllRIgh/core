package character.controller;

import character.model.Book;
import character.model.BookAttachments;
import character.model.BookReference;
import character.repository.BookAttachmentsRepository;
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

public class BookAttachmentsController {
    private final BookRepository bookRepository;
    private final BookAttachmentsRepository bookAttachmentsRepository;
    private final BookReferenceRepository referenceRepository;

    @Autowired
    public BookAttachmentsController(BookRepository bookRepository, BookReferenceRepository referenceRepository, BookAttachmentsRepository bookAttachmentsRepository) {
        this.referenceRepository = referenceRepository;
        this.bookAttachmentsRepository = bookAttachmentsRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = {"/attachment/addAttachment"}, method = RequestMethod.GET)
    public String addBookAttachmentsForm(ModelMap model) {
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("attachment", new BookAttachments());
        model.addAttribute("books", books);
        return "attachment/new";
    }

    @RequestMapping(value = {"/attachment/addAttachment"}, params = {"addRef"}, method = RequestMethod.POST)
    public String addBookAttachmentsFormRef(ModelMap model, @ModelAttribute("attachment") BookAttachments attachment) {
        if (attachment.getBookReferences() == null) {
            attachment.setBookReferences(new ArrayList<BookReference>());
        }
        attachment.getBookReferences().add(new BookReference());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("attachment", attachment);
        model.addAttribute("books", books);
        return "attachment/new";
    }

    @RequestMapping(value = {"/attachment/addAttachment"}, params = {"removeRef"}, method = RequestMethod.POST)
    public String removeBookAttachmentsFormRef(ModelMap model, @ModelAttribute("attachment") BookAttachments attachment, HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRef"));
        attachment.getBookReferences().remove(rowId.intValue());
        List references = this.referenceRepository.findAll();
        List books = this.bookRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("attachment", attachment);
        model.addAttribute("books", books);
        return "attachment/new";
    }

    @RequestMapping(value = "/attachment/addAttachment", method = RequestMethod.POST)
    public String addBookAttachments(@ModelAttribute("attachment") BookAttachments attachment, ModelMap modelMap) {
        modelMap.addAttribute("attachment", attachment);
        if (attachment.getBookReferences() == null) {
            attachment.setBookReferences(new ArrayList<BookReference>());
        }
        for (int i = 0; i < attachment.getBookReferences().size(); i++) {
            BookReference reference = attachment.getBookReferences().remove(i);
            if (this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber()) != null) {
                // replace with already persisted reference
                reference = this.referenceRepository.findDistinctFirstByBookAndPageNumber(reference.getBook(), reference.getPageNumber());
            }
            attachment.getBookReferences().add(reference);
        }

        this.bookAttachmentsRepository.save(attachment);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        List attachments = this.bookAttachmentsRepository.findAll();
        modelMap.addAttribute("attachments", attachments);
        return "redirect:attachments";
    }

    @RequestMapping(value = {"/attachment", "/attachment/attachments"}, method = RequestMethod.GET)
    public String getBookAttachmentsList(@ModelAttribute Book attachment, Model model) {
        List attachments = this.bookAttachmentsRepository.findAll();
        model.addAttribute("attachments", attachments);
        return "attachment/attachments";
    }

    @RequestMapping(value = "attachment/{id}", method = RequestMethod.GET)//, headers="Accept=application/json"
    public String getBookAttachments(@PathVariable("id") long id, Model model) {
        BookAttachments attachment = this.bookAttachmentsRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("attachment", attachment);
        return "attachment/attachment";
    }

    @RequestMapping(value = "attachment/{id}", method = RequestMethod.DELETE)//, headers="Accept=application/json"
    public String deleteBookAttachments(@PathVariable("id") long id, Model model) {
        BookAttachments attachment = this.bookAttachmentsRepository.findOne(id);
        if (attachment != null) {
            this.bookAttachmentsRepository.delete(attachment);
        }
        List references = this.bookAttachmentsRepository.findAll();
        model.addAttribute("references", references);
        model.addAttribute("attachments", attachment);
        return "attachment/attachments";
    }

    @RequestMapping(value = "attachment/update/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable("id") long id, @ModelAttribute("attachment") Book attachment, ModelMap modelMap) {
        BookAttachments dbBookAttachments = this.bookAttachmentsRepository.findOne(id);
        List references = this.referenceRepository.findAll();
        modelMap.addAttribute("references", references);
        modelMap.addAttribute("attachment", dbBookAttachments);
        return "attachment/update";
    }

    @RequestMapping(value = "attachment/{id}", method = RequestMethod.PUT)
    public String updateBookAttachments(@PathVariable("id") long id, @ModelAttribute("attachment") BookAttachments attachment, ModelMap modelMap) {
        attachment.setAttachmentId(id);
        this.bookAttachmentsRepository.save(attachment);
        modelMap.addAttribute("attachment", attachment);
        return "attachment/attachment";
    }
}
