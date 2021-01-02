package character.repository;

import character.model.BookVehicleAttachments;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookVehicleAttachmentsRepository extends PanacheEntityResource<BookVehicleAttachments, Long> {
}
