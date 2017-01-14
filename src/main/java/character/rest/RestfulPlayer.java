package character.rest;


import character.model.Player;
import character.model.User;
import character.repository.BookArmorRepository;
import character.repository.BookWeaponsRepository;
import character.repository.UserRepository;
import character.repository.PlayerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * Created by Th'MASA of on 1/7/2017.
 */
@RestController
public class RestfulPlayer {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    BookArmorRepository bookArmorRepository;

    @Autowired
    BookWeaponsRepository bookWeaponsRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public ModelAndView linkMap() {
        return new ModelAndView("redirect:https://hbernberg.carto.com/viz/76e286d4-fbab-11e3-b014-0e73339ffa50/embed_map?title=false&description=true&search=fallse&shareable=false&cartodb_logo=false&layer_selector=true&legends=true&scrollwheel=true&fullscreen=true&sublayer_options=1%7C1%7C1%7C1&sql=&zoom=3&center_lat=0&center_lon=0");

    }

    @RequestMapping(value = "/getMyChars", method = RequestMethod.GET)
    public List<Player> getAllMyChars(Principal user) {
        System.out.println(user);
        if (user != null) {
            User internalUser = userRepository.findByUserName(user.getName());
            return internalUser.getPlayers();
        }

        return null;
    }

    @RequestMapping(value = "/newChar", method = RequestMethod.POST)
    public Player saveNewChar(@RequestBody String character) {
        ObjectMapper mapper = new ObjectMapper();
        Player player = new Player();
        try {
            player = mapper.readValue(character, Player.class);
            String json = mapper.writeValueAsString(player);
            System.out.println(json);
            System.out.println(character);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //playerRepository.save(character);

        return player;
    }

    @RequestMapping(value = "/updateCharList", method = RequestMethod.POST)
    public List<Player> saveCharacterList(List<Player> players) {
        System.out.println("recieved stuff");
        return players;
    }

}
