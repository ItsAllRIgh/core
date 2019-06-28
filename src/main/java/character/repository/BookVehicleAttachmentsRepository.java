package character.repository;

import character.model.BookVehicleAttachments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource
public interface BookVehicleAttachmentsRepository extends CrudRepository<BookVehicleAttachments, Long> {
    @RequestMapping(name = "/vehicleattach/all")
    List<BookVehicleAttachments> findAll();
}
