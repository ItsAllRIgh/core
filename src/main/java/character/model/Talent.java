package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by Th'MASA of on 1/2/2017.
 */

public class Talent extends PanacheEntity {

    String name;
    String summary;

    public Talent() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Talent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
