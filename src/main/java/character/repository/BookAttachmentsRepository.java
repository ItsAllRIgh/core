package character.repository;

import character.model.BookAttachments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource
public interface BookAttachmentsRepository extends CrudRepository<BookAttachments, Long> {
    @RequestMapping(name = "/attachments/all")
    List<BookAttachments> findAll();
}
