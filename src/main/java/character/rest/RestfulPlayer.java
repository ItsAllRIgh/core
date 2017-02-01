package character.rest;


import character.model.BookWeaponsEntity;
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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
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
   public List<Player> getAllMyChars (Principal user){
      System.out.println(user);
      if(user != null){
         User internalUser = userRepository.findByUserName(user.getName());
         return internalUser.getPlayers();
      }

      return null;
   }

   @RequestMapping(value="/newChar", method = RequestMethod.POST)
   public Player saveNewChar (@RequestBody String character){
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
   public Player[] saveCharacterList (@RequestBody String players){
      ObjectMapper mapper = new ObjectMapper();
      ArrayList<Player> list = new ArrayList<Player>();
      System.out.println("recieved stuff " + players);
      Player[] group = null;// = new Player[50];
      try {
         group = mapper.readValue(players, Player[].class);
         String json = mapper.writeValueAsString(group);
         System.out.println(json);
         //System.out.println(players);
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }

      // Find the new one/update all entries
      if(null != group || group.length>0){
         Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         String username = null;
         if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
            System.err.println(username);
         } else {
            username = principal.toString();
            System.err.println(username);
         }
         if(username != null){
            User activeUser = userRepository.findByUserName(username);
            if(activeUser != null){
               for(Player p : group){
                  if(p.id != null){
                     p.id = null;
                  }
               }
               list = new ArrayList<Player>(Arrays.asList(group));
               List<Player> currentList = activeUser.getPlayers();
               playerRepository.save(list);
               if(currentList.size()>0){
                  for(Player player: group){
                     //player.userName = activeUser.userName;
                     activeUser.getPlayers().add(player);
                  }
                  System.out.print("Found a player: "+ currentList.get(0));
                  if(currentList.size()>1){
                     System.out.print("trixy hobbitesess");
                  }
                  if(userRepository != null) {
                     userRepository.save(activeUser);
                  }
               }else{
                  currentList.addAll(list);
                  if(userRepository != null){
                     if(list != null)
                     userRepository.save(activeUser);
                  }
               }

            }
         }
      }
      return group;
   }

   @RequestMapping(value = "/weaponsName", method = RequestMethod.GET)
   public List<String> getListOfWeapons (){
      ArrayList<String> names = new ArrayList<>();
      List<BookWeaponsEntity> repo = bookWeaponsRepository.findAll();
      for(BookWeaponsEntity weapon: repo){
         names.add(weapon.getWeaponName());
      }
      return names;
   }
   @RequestMapping(value = "/weapon", method = RequestMethod.GET)
   public BookWeaponsEntity getListOfWeapons (@RequestParam("name") String name){
      BookWeaponsEntity entity = null;
      List<BookWeaponsEntity> repo = bookWeaponsRepository.findByWeaponNameAllIgnoreCase(name);
      System.out.println(repo.size());
      if (!repo.isEmpty()){
         entity = repo.get(0);
      }
      return entity;
   }
}
