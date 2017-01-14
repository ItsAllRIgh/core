package character.repository;

import character.model.BookWeaponsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Th'MASA of on 1/6/2017.
 */
@RepositoryRestResource(collectionResourceRel = "book_weapons", path = "book_weapons")
public interface BookWeaponsRepository extends CrudRepository<BookWeaponsEntity, Integer> {

    List<BookWeaponsEntity> findAll();
    // Enables the distinct flag for the query
    List<BookWeaponsEntity> findDistinctBookWeaponsEntityByRestricted(boolean restricted);

    // Enabling ignoring case for all suitable properties
    List<BookWeaponsEntity> findByWeaponNameAllIgnoreCase(String weaponname);

    // Enabling static ORDER BY for a query
    List<BookWeaponsEntity> findByRestrictedOrderByPriceAsc(boolean restricted);

    List<BookWeaponsEntity> findByRestrictedAndRarityLessThanOrderByPriceAsc(boolean restricted, int rarity);
    List<BookWeaponsEntity> findByRestrictedOrderByPriceDesc(boolean restricted);

}

