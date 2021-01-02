package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by Th'MASA of on 1/2/2017.
 */


public class Career extends PanacheEntity {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Career{" +
                "name='" + name + '\'' +
                '}';
    }
}
