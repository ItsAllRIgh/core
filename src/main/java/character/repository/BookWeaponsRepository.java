package character.repository;

import character.model.BookWeapons;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookWeaponsRepository extends PanacheEntityResource<BookWeapons, Long> {
}
