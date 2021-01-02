package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by Th'MASA of on 1/2/2017.
 */


public class Weapon extends PanacheEntity {

    String name = "WEAPON";
    String skill = null;
    String special = "WEAPONSPECIAL";

    String range = "";
    int damages = 2;

    int crit = 0;

    int HP = 0;
    String mods = "WEAPONMODS";


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
                " name='" + name + '\'' +
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
