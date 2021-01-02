package character.repository;

import character.model.BookWeaponQualities;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookWeaponQualitiesRepository extends PanacheEntityResource<BookWeaponQualities, Long> {
}
