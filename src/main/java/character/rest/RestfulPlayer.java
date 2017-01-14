package character.rest;


import character.repository.BookArmorRepository;
import character.repository.BookWeaponsRepository;
import character.repository.PlayerRepository;
import character.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

}
