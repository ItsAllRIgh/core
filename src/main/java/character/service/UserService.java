package character.service;

import character.model.User;

/**
 * Created by Th'MASA of on 1/8/2017.
 */
public interface UserService {
    public void save(User user);

    public User findByUsername(String username);
}
