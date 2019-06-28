package character.repository;

import character.model.Book;
import character.model.BookReference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource
public interface BookReferenceRepository extends CrudRepository<BookReference, Long> {
    @RequestMapping(name = "/ref/all")
    List<BookReference> findAll();

    BookReference findDistinctFirstByBookAndPageNumber(Book book, int pageNumber);

}
