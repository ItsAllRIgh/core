package character.repository;

import character.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Th'MASA of on 1/7/2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    User findByUserName(String username);
}
