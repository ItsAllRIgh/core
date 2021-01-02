package character.repository;

import character.model.BookAttachments;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface BookAttachmentsRepository extends PanacheEntityResource<BookAttachments, Long> {
}
