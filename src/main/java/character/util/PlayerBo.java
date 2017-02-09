package character.util;

import character.model.Player;
import character.model.User;
import character.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Th'MASA of on 2/5/2017.
 */

public class PlayerBo {
    @Autowired
    PlayerRepository playerRepository;
    User internalUser;

    public PlayerBo(User user) {
        if (user != null) {
            internalUser = user;
        } else {
            internalUser = new User();
        }
    }

    public boolean synchLists(List<Player> remotePlayers) {
        boolean completed = false;
        if (playerRepository != null) {
            for (Player player : remotePlayers) {
                if (player.id > 0) {
                    Player playerInside = playerRepository.findById(player.id);
                } else if (!player.userName.isEmpty() && player.userName != " ") {
                    //this forgoes the problem of multiples for now
                    List<Player> playerList = playerRepository.findByNameOrderByIdAsc(player.userName);
                    if (playerList != null) {
                        for (Player p : remotePlayers) {
                            String name = p.userName;
                            if (p.id > 0) {
                                Player amIYou = playerRepository.findById(p.id);
                                if (!amIYou.equals(p)) {

                                }
                            }
                        }
                    }
                }
            }
        }
        return completed;
    }
}
