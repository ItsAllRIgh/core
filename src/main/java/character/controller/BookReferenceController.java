package character.controller;

import character.model.Book;
import character.model.BookReference;
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

import java.util.List;

@Controller
public class BookReferenceController {

    private final BookReferenceRepository referenceRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookReferenceController(BookReferenceRepository referenceRepository, BookRepository bookRepository) {
        this.referenceRepository = referenceRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = {"/bookRef/addRef"}, method = RequestMethod.GET)
    public String addBookRefForm(Model model) {
        List books = this.bookRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("bookRefs", this.bookRepository.findAll());
        model.addAttribute("bookRef", new BookReference());
        return "bookRef/new";
    }

    @RequestMapping(value = "/bookRef/addBookRef", method = RequestMethod.POST)
    public String addBookRef(@ModelAttribute("bookRef") BookReference bookRef, ModelMap modelMap) {
        modelMap.addAttribute("bookRef", bookRef);
        List books = this.bookRepository.findAll();
        modelMap.addAttribute("books", books);

        this.referenceRepository.save(bookRef);
        List bookRefs = this.referenceRepository.findAll();
        modelMap.addAttribute("bookRefs", bookRefs);
        return "redirect:bookRefs";
    }

    @RequestMapping(value = {"/bookRef", "/bookRef/bookRefs"}, method = RequestMethod.GET)
    public String getBookRefList(@ModelAttribute Book book, Model model) {
        List bookRefs = this.referenceRepository.findAll();
        model.addAttribute("bookRefs", bookRefs);
        return "bookRef/bookRefs";
    }

    @RequestMapping(value = "bookRef/{id}", method = RequestMethod.GET)//, headers="Accept=application/json"
    public String getBookRef(@PathVariable("id") long id, Model model) {
        BookReference bookRef = this.referenceRepository.findOne(id);
        List books = this.bookRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("book", bookRef);
        return "bookRef/bookRef";
    }

    @RequestMapping(value = "bookRef/{id}", method = RequestMethod.DELETE)//, headers="Accept=application/json"
    public String deleteBookRef(@PathVariable("id") long id, Model model) {
        BookReference bookRef = this.referenceRepository.findOne(id);
        if (bookRef != null) {
            this.referenceRepository.delete(bookRef);
        }
        List bookRefs = this.referenceRepository.findAll();
        model.addAttribute("bookRefs", bookRefs);
        model.addAttribute("bookRefs", bookRef);
        return "bookRef/bookRefs";
    }

    @RequestMapping(value = "bookRef/update/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable("id") long id, @ModelAttribute("bookRef") Book book, ModelMap modelMap) {
        BookReference dbBookRef = this.referenceRepository.findOne(id);
        List books = this.bookRepository.findAll();
        modelMap.addAttribute("books", books);
        modelMap.addAttribute("bookRef", dbBookRef);
        return "bookRef/update";
    }

    @RequestMapping(value = "bookRef/{id}", method = RequestMethod.PUT)
    public String updateBookRef(@PathVariable("id") long id, @ModelAttribute("bookRef") BookReference bookRef, ModelMap modelMap) {
        bookRef.setReferenceId(id);
        this.referenceRepository.save(bookRef);
        modelMap.addAttribute("book", bookRef);
        return "bookRef/bookRef";
    }

    private Book findBookById(Long id) {
        Book book = this.bookRepository.findOne(id);
        return book;
    }

    private BookReference findAbilityById(long id) {
        BookReference reference = this.referenceRepository.findOne(id);

        return reference;
    }
}
