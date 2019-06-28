package character.repository;

import character.model.BookArmor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface PlayerArmorRepository {

    @RepositoryRestResource(collectionResourceRel = "player_armor", path = "player_armor")
    public interface BookArmorRepository extends CrudRepository<BookArmor, Integer> {

        List<BookArmor> findAll();

        // Enables the distinct flag for the query
        List<BookArmor> findDistinctPlayerArmorEntityByRestricted(boolean restricted);

        // Enabling ignoring case for all suitable properties
        List<BookArmor> findByArmorNameAllIgnoreCase(String armorname);

        // Enabling static ORDER BY for a query
        List<BookArmor> findByRestrictedOrderByPriceAsc(boolean restricted);

        List<BookArmor> findByRestrictedOrderByPriceDesc(boolean restricted);

    }
}
