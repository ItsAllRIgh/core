package character.repository;

import character.model.BookWeaponQualities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource
public interface BookWeaponQualitiesRepository extends CrudRepository<BookWeaponQualities, Long> {
    @RequestMapping(name = "/qualities/all")
    List<BookWeaponQualities> findAll();
}
