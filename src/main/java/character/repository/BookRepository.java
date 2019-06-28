package character.repository;

import character.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {
    @RequestMapping(name = "/books/all")
    List<Book> findAll();
}

