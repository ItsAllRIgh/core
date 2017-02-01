package character.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Th'MASA of on 1/2/2017.
 */
@Entity
@Table(name = "weapon", schema = "", catalog = "legends")
public class Player_Weapon implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy="increment")
    Long id;
    String name = "WEAPON";
    String skill = null;
    String special = "WEAPONSPECIAL";
    @Column(name = "WEP_RANGE")
    String range = "";
    int damages = 2;
    @JsonProperty(value = "critical")
    int crit = 0;
    @JsonProperty(value = "HP")
    int HP = 0;
    String mods = "WEAPONMODS";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getDamages() {
        return damages;
    }

    public void setDamages(int damages) {
        this.damages = damages;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public String getMods() {
        return mods;
    }

    public void setMods(String mods) {
        this.mods = mods;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skill=" + skill +
                ", special='" + special + '\'' +
                ", range=" + range +
                ", damages=" + damages +
                ", crit=" + crit +
                ", HP=" + HP +
                ", mods='" + mods + '\'' +
                '}';
    }
}
