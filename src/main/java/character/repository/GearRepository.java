package character.repository;

import character.model.GearEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "book_gear", path = "book_gear")
public interface GearRepository extends CrudRepository<GearEntity, Integer> {

    List<GearEntity> findAll();
    // Enables the distinct flag for the query
    //List<GearEntity> findDistinctGearEntityByRestricted(boolean restricted);

    // Enabling ignoring case for all suitable properties
    List<GearEntity> findByGearNameAllIgnoreCase(String gearName);

    // Enabling static ORDER BY for a query
    //List<GearEntity> findByRestrictedOrderByPriceAsc(boolean restricted);
    //List<GearEntity> findByRestrictedOrderByPriceDesc(boolean restricted);

}