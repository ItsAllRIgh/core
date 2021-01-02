package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by Th'MASA of on 1/2/2017.
 */


public class Skill extends PanacheEntity {

    String name;
    boolean career;
    int rank;

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public Skill(String name, boolean career, int rank) {
        this.name = name;
        this.career = career;
        this.rank = rank;
    }

    public boolean isCareer() {
        return career;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getCareer() {
        return career;
    }

    public void setCareer(boolean career) {
        this.career = career;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", career=" + career +
                ", rank=" + rank +
                '}';
    }
}
