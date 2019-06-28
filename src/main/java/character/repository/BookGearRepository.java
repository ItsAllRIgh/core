package character.repository;

import character.model.BookGear;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface BookGearRepository extends CrudRepository<BookGear, Long> {
    @RequestMapping(name = "/gear/all")
    List<BookGear> findAll();
}
