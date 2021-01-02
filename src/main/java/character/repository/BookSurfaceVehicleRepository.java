package character.repository;

import character.model.BookSurfaceVehicle;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookSurfaceVehicleRepository extends PanacheEntityResource<BookSurfaceVehicle, Long> {
}
