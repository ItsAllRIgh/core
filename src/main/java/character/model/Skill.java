package character.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Th'MASA of on 1/2/2017.
 */
@Entity
@Table(name = "skill", schema = "", catalog = "legends")
public class Skill implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5772429839841222500L;
	@Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy="increment")
    Long id;
    String name = "SKILLNAME";
    boolean career = false;
    int rank = 0;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
