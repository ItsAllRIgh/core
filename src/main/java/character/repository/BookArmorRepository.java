package character.repository;

import character.model.BookArmorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Th'MASA of on 1/6/2017.
 */
@RepositoryRestResource(collectionResourceRel = "book_armor", path = "book_armor")
public interface BookArmorRepository extends CrudRepository<BookArmorEntity, Integer> {

    List<BookArmorEntity> findAll();
    // Enables the distinct flag for the query
    List<BookArmorEntity> findDistinctBookArmorEntityByRestricted(boolean restricted);

    // Enabling ignoring case for all suitable properties
    List<BookArmorEntity> findByArmorNameAllIgnoreCase(String armorname);

    // Enabling static ORDER BY for a query
    List<BookArmorEntity> findByRestrictedOrderByPriceAsc(boolean restricted);
    List<BookArmorEntity> findByRestrictedOrderByPriceDesc(boolean restricted);

}
