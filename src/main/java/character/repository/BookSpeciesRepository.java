package character.repository;

import character.model.BookSpecies;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookSpeciesRepository extends PanacheEntityResource<BookSpecies, Long> {
}
