package character.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Th'MASA of on 1/22/2017.
 */
@Entity
@Table(name = "player_armor")
public class Armor {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy="increment")
    private int armorId;

    @ManyToOne
    private BookArmorEntity baseArmor;

    @ManyToOne
    private ModificationsEntity modifications;

    public Armor(){}
    public Armor (BookArmorEntity bookArmorEntity){
        this.baseArmor = bookArmorEntity;
    }

    public int getArmorId() {
        return armorId;
    }

    public void setArmorId(int armorId) {
        this.armorId = armorId;
    }

    public BookArmorEntity getBaseArmor() {
        return baseArmor;
    }

    public void setBaseArmor(BookArmorEntity baseArmor) {
        this.baseArmor = baseArmor;
    }

    public ModificationsEntity getModifications() {
        return modifications;
    }

    public void setModifications(ModificationsEntity modifications) {
        this.modifications = modifications;
    }
}
