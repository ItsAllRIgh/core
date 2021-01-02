package character.repository;

import character.model.Book;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookRepository extends PanacheEntityResource<Book, Long> {
}
