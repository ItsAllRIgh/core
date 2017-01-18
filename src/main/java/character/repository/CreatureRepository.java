package character.repository;

import character.model.CreaturesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Th'MASA of on 1/17/2017.
 */
public interface CreatureRepository extends CrudRepository<CreaturesEntity, Integer> {
    List<CreaturesEntity> findAll();
}
