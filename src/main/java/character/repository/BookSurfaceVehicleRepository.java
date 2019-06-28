package character.repository;

import character.model.BookSurfaceVehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource
public interface BookSurfaceVehicleRepository extends CrudRepository<BookSurfaceVehicle, Long> {
    @RequestMapping(name = "/vehicle/all")
    List<BookSurfaceVehicle> findAll();
}

