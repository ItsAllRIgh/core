package character.rest;

import character.model.Player;
import character.repository.PlayerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    @Autowired
    private PlayerRepository playerRepository;

    public PlayerController() {
    }


    @MessageMapping("/character")
    @SendTo("/topic/character")
    public String characterSubmit(String message) throws Exception {
        System.out.println(message);
        ObjectMapper mapper = new ObjectMapper();
        List<Player> list = mapper.readValue(message,
                TypeFactory.defaultInstance().constructCollectionType(List.class,
                        Player.class));
        for(Player p: list){
            if(p!=null)
                playerRepository.save(p);
        }
        Thread.sleep(1000); // simulated delay
        return message;
    }

    @MessageMapping("/topic/update")
    @SendTo("/topic/character")
    public Player characterUpdate(Player message) throws Exception {
        System.out.print(message.name);
        return message;
    }
}