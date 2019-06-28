package character.repository;

import character.model.BookWeapons;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Th'MASA of on 1/6/2017.
 */
@RepositoryRestResource
public interface BookWeaponsRepository extends CrudRepository<BookWeapons, Long> {

    @RequestMapping(name = "/weapons/all")
    List<BookWeapons> findAll();

    // Enables the distinct flag for the query
    List<BookWeapons> findDistinctBookWeaponsEntityByRestricted(boolean restricted);

    // Enabling ignoring case for all suitable properties
    List<BookWeapons> findByWeaponNameAllIgnoreCase(String weaponname);

    // Enabling static ORDER BY for a query
    List<BookWeapons> findByRestrictedOrderByPriceAsc(boolean restricted);

    List<BookWeapons> findByRestrictedAndRarityLessThanOrderByPriceAsc(boolean restricted, int rarity);

    List<BookWeapons> findByRestrictedOrderByPriceDesc(boolean restricted);

}

