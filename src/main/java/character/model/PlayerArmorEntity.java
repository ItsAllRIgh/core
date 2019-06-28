package character.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Th'MASA of on 1/22/2017.
 */
@Entity
@Table(name = "player_armor")
public class PlayerArmorEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int armorId;

    @ManyToOne
    private BookArmor baseArmor;

    @ManyToOne
    private ModificationsEntity modifications;

    public PlayerArmorEntity() {
    }

    public PlayerArmorEntity(BookArmor bookArmorEntity) {
        this.baseArmor = bookArmorEntity;
    }

    public int getArmorId() {
        return armorId;
    }

    public void setArmorId(int armorId) {
        this.armorId = armorId;
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
