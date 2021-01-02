package character.repository;

import character.model.BookArmor;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookArmorRepository extends PanacheEntityResource<BookArmor, Long> {
}
