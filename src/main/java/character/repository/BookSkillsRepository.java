package character.repository;

import character.model.BookSkills;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookSkillsRepository extends PanacheEntityResource<BookSkills, Long> {
}
