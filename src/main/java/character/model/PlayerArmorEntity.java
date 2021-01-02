package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by Th'MASA of on 1/22/2017.
 */


public class PlayerArmorEntity extends PanacheEntity {


    BookArmor baseArmor;


    ModificationsEntity modifications;

    public PlayerArmorEntity() {
    }

    public PlayerArmorEntity(BookArmor bookArmorEntity) {
        this.baseArmor = bookArmorEntity;
    }

    public BookArmor getBaseArmor() {
        return baseArmor;
    }

    public void setBaseArmor(BookArmor baseArmor) {
        this.baseArmor = baseArmor;
    }

    public ModificationsEntity getModifications() {
        return modifications;
    }

    public void setModifications(ModificationsEntity modifications) {
        this.modifications = modifications;
    }
}
