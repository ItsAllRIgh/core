package character.repository;

import character.model.BookSkills;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource
public interface BookSkillsRepository extends CrudRepository<BookSkills, Long> {
    @RequestMapping(name = "/skills/all")
    List<BookSkills> findAll();
}
