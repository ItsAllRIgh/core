package character.controller;

import character.model.Book;
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
public class BookController {

    private final BookRepository repository;

    @Autowired
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = {"/book/addBook"}, method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/new";
    }

    @RequestMapping(value = "/book/addBook", method = RequestMethod.POST)
    public String doAddBook(@ModelAttribute("book") Book book, ModelMap modelMap) {
        modelMap.addAttribute("book", book);
        this.repository.save(book);
        List books = this.repository.findAll();
        modelMap.addAttribute("books", books);
        return "redirect:book/books";
    }

    @RequestMapping(value = {"/book", "/book/books"}, method = RequestMethod.GET)
    public String getBookList(@ModelAttribute Book book, Model model) {
        List books = this.repository.findAll();
        model.addAttribute("books", books);
        return "/book/books";
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.GET)//, headers="Accept=application/json"
    public String getBook(@PathVariable("id") long id, Model model) {
        Book book = this.repository.findOne(id);
        model.addAttribute("book", book);
        return "book/book";
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.DELETE)//, headers="Accept=application/json"
    public String deleteBook(@PathVariable("id") long id, Model model) {
        Book book = this.repository.findOne(id);
        if (book != null) {
            this.repository.delete(book);
        }
        List books = this.repository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("book", book);
        return "redirect:book/books";
    }

    @RequestMapping(value = "book/update/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable("id") long id, @ModelAttribute("book") Book book, ModelMap modelMap) {
        Book dbBook = this.repository.findOne(id);

        modelMap.addAttribute("book", dbBook);
        return "book/update";
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable("id") long id, @ModelAttribute("book") Book book, ModelMap modelMap) {
        book.setBookId(id);
        this.repository.save(book);
        modelMap.addAttribute("book", book);
        return "redirect:book/books";
    }
}
