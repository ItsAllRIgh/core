package character.repository;

import character.model.BookTalent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource
public interface BookTalentRepository extends CrudRepository<BookTalent, Long> {
    @RequestMapping(name = "/talents/all")
    List<BookTalent> findAll();
}
