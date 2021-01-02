package character.repository;

import character.model.Gear;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface GearRepository extends PanacheEntityResource<Gear, Long> {
}
