package character.repository;

import character.model.BookTalent;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookTalentRepository extends PanacheEntityResource<BookTalent, Long> {
}
