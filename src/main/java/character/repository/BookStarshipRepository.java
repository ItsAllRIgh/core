package character.repository;

import character.model.BookStarship;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookStarshipRepository extends PanacheEntityResource<BookStarship, Long> {
}
