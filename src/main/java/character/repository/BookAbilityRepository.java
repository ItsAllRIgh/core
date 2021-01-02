package character.repository;

import character.model.BookAbility;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookAbilityRepository extends PanacheEntityResource<BookAbility, Long> {
}
