package character.service;

/**
 * Created by Th'MASA of on 1/8/2017.
 */
public interface SecurityService {
    public String findLoggedInUsername();
    public void autologin(String username, String password);
}
