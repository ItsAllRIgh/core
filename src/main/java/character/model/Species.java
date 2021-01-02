package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by Th'MASA of on 1/2/2017.
 */


public class Species extends PanacheEntity {
    String name;
    int Brawn;
    int Agility;
    int Int;
    int Cun;
    int Will;
    int Presence;
    int EXP;
    int Wound;
    int Strain;

    public Species() {
    }

    public Species(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrawn() {
        return Brawn;
    }

    public void setBrawn(int brawn) {
        Brawn = brawn;
    }

    public int getAgility() {
        return Agility;
    }

    public void setAgility(int agility) {
        Agility = agility;
    }

    public int getInt() {
        return Int;
    }

    public void setInt(int anInt) {
        Int = anInt;
    }

    public int getCun() {
        return Cun;
    }

    public void setCun(int cun) {
        Cun = cun;
    }

    public int getWill() {
        return Will;
    }

    public void setWill(int will) {
        Will = will;
    }

    public int getPresence() {
        return Presence;
    }

    public void setPresence(int presence) {
        Presence = presence;
    }

    public int getEXP() {
        return EXP;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
    }

    public int getWound() {
        return Wound;
    }

    public void setWound(int wound) {
        Wound = wound;
    }

    public int getStrain() {
        return Strain;
    }

    public void setStrain(int strain) {
        Strain = strain;
    }

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Brawn=" + Brawn +
                ", Agility=" + Agility +
                ", Int=" + Int +
                ", Cun=" + Cun +
                ", Will=" + Will +
                ", Presence=" + Presence +
                ", EXP=" + EXP +
                ", Wound=" + Wound +
                ", Strain=" + Strain +
                '}';
    }
}
