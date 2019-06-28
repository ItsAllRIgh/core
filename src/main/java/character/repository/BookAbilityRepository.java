package character.repository;

import character.model.BookAbility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource
public interface BookAbilityRepository extends CrudRepository<BookAbility, Long> {
    @RequestMapping(name = "/abilities/all")
    List<BookAbility> findAll();
}



