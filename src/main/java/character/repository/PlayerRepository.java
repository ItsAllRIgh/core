package character.repository;

/**
 * This will act as the store of Characters, server-side, flat-file or active DB.
 * <p>
 * Look@ Datastore
 * Created by Th'MASA of on 1/2/2017.
 */

import character.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "user_character", path = "user_character")
public interface PlayerRepository extends CrudRepository<Player, Long> {

    @RequestMapping(name = "/character/{name}")
    List<Player> findByName(@PathVariable(required = true) String name);

    List<Player> findByNameOrderByIdAsc(String name);

    Player findById(Long id);

    @RequestMapping("/allChars")
    List<Player> findAll();
}