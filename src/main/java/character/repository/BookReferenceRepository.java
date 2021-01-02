package character.repository;

import character.model.BookReference;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookReferenceRepository extends PanacheEntityResource<BookReference, Long> {
}
