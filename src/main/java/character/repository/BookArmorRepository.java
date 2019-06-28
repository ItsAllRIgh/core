package character.repository;

import character.model.BookArmor;
import character.model.BookReference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Th'MASA of on 1/6/2017.
 */
@RepositoryRestResource
public interface BookArmorRepository extends CrudRepository<BookArmor, Long> {
    @RequestMapping(name = "/armor/all")
    List<BookArmor> findAll();

    // Enables the distinct flag for the query
    List<BookArmor> findDistinctBookArmorEntityByRestricted(boolean restricted);

    // Enabling ignoring case for all suitable properties
    List<BookArmor> findByArmorNameAllIgnoreCase(String armorname);

    // Enabling static ORDER BY for a query
    List<BookArmor> findByRestrictedOrderByPriceAsc(boolean restricted);

    List<BookArmor> findByRestrictedOrderByPriceDesc(boolean restricted);

    List<BookArmor> findTopByDescriptionIsLikeAndBookReferencesLike(String description, BookReference bookReference);

}
