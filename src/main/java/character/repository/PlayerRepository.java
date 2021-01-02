package character.repository;

import character.model.Player;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface PlayerRepository extends PanacheEntityResource<Player, Long> {
}
