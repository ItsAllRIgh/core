package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by yr998d on 1/5/2017.
 */


public class CreaturesEntity extends PanacheEntity {

    String creatureName;
    String creatureArmor;
    String skills;
    String talents;
    String abilities;
    String equipment;
    String bookIndex;


    public String getCreatureName() {
        return creatureName;
    }

    public void setCreatureName(String creatureName) {
        this.creatureName = creatureName;
    }


    public String getCreatureArmor() {
        return creatureArmor;
    }

    public void setCreatureArmor(String creatureArmor) {
        this.creatureArmor = creatureArmor;
    }


    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }


    public String getTalents() {
        return talents;
    }

    public void setTalents(String talents) {
        this.talents = talents;
    }


    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }


    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }


    public String getBookIndex() {
        return bookIndex;
    }

    public void setBookIndex(String bookIndex) {
        this.bookIndex = bookIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreaturesEntity that = (CreaturesEntity) o;

        if (abilities != null ? !abilities.equals(that.abilities) : that.abilities != null) return false;
        if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
        if (creatureArmor != null ? !creatureArmor.equals(that.creatureArmor) : that.creatureArmor != null)
            return false;
        if (creatureName != null ? !creatureName.equals(that.creatureName) : that.creatureName != null) return false;
        if (equipment != null ? !equipment.equals(that.equipment) : that.equipment != null) return false;
        if (skills != null ? !skills.equals(that.skills) : that.skills != null) return false;
        return talents != null ? talents.equals(that.talents) : that.talents == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (creatureName != null ? creatureName.hashCode() : 0);
        result = 31 * result + (creatureArmor != null ? creatureArmor.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        result = 31 * result + (talents != null ? talents.hashCode() : 0);
        result = 31 * result + (abilities != null ? abilities.hashCode() : 0);
        result = 31 * result + (equipment != null ? equipment.hashCode() : 0);
        result = 31 * result + (bookIndex != null ? bookIndex.hashCode() : 0);
        return result;
    }
}
