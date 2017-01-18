package character.rest;

import character.model.*;
import character.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Th'MASA of on 1/2/2017.
 */


@RestController
public class RestfulGM {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    BookArmorRepository bookArmorRepository;

   @Autowired
   GearRepository gearRepository;

    @Autowired
    BookWeaponsRepository bookWeaponsRepository;

    @Autowired
    CreatureRepository creatureRepository;

    /*public restfulGM(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }*/

    @RequestMapping("/gm/player")
    public List<Player> players() {
        if (playerRepository != null) {
            System.out.println("Nice Repo");
            return playerRepository.findAll();

        }else {
            System.err.println("BAD Repo");
            return null;
        }
    }

    @RequestMapping("/players/{id}")
    public Player greeting(@PathVariable(name = "id", required = true) Long id, Model model) {
        Player player = null;
        if(id!=null && id >0 && playerRepository!=null){
            player = playerRepository.findOne(id);
            model.addAttribute("player", player);
        }
        return player;
    }

    @RequestMapping("/gm/armors")
    @ModelAttribute("armors")
    public List<BookArmorEntity> armors() {
        if (bookArmorRepository != null) {
            System.out.println("Nice Repo");
            return bookArmorRepository.findAll();

        }else {
            System.err.println("BAD Repo");
            return null;
        }
    }
    @ModelAttribute("armor")
    @RequestMapping("/armor/{id}")
    public BookArmorEntity armorById(@PathVariable(name = "id", required = true) int id, Model model) {
        BookArmorEntity book_armor = null;
        if(id >0 && bookArmorRepository!=null){
            book_armor = bookArmorRepository.findOne(id);
            model.addAttribute("armor", book_armor);
        }
        return book_armor;
    }


    @RequestMapping("/gm/weapons")
    @ModelAttribute("weapons")
    public List<BookWeaponsEntity> weapons() {
        if (gearRepository != null) {
            System.out.println("Nice Repo");
            return bookWeaponsRepository.findAll();

        }else {
            System.err.println("BAD Repo");
            return null;
        }
    }

   @RequestMapping("/gm/gear")
   @ModelAttribute("gears")
   public List<GearEntity> gear() {
       if (gearRepository != null) {
           System.out.println("Nice Repo");
           return gearRepository.findAll();

       }else {
           System.err.println("BAD Repo");
           return null;
       }
   }

    @RequestMapping("/gm/creatures")
    @ModelAttribute("creatures")
    public List<CreaturesEntity> creatures() {
        if (creatureRepository != null) {
            System.out.println("Nice Repo");
            return creatureRepository.findAll();
        } else {
            System.err.println("BAD Repo");
            return null;
        }
    }

    @RequestMapping("/weapon/{id}")
    @ModelAttribute("weapon")
    public BookWeaponsEntity weaponById(@PathVariable(name = "id", required = true) int id, Model model) {
        BookWeaponsEntity book_armor = null;
        if(id >0 && bookWeaponsRepository!=null){
            book_armor = bookWeaponsRepository.findOne(id);
            model.addAttribute("weapon", book_armor);
        }
        return book_armor;
    }


}
