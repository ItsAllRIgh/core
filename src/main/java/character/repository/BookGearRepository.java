package character.repository;

import character.model.BookGear;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookGearRepository extends PanacheEntityResource<BookGear, Long> {
}
