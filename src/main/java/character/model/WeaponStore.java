package character.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by yr998d on 1/13/2017.
 */
@Entity
public class WeaponStore {
   @Id
   @GeneratedValue(generator = "increment")
   @GenericGenerator(name="increment", strategy="increment")
   int id;
   @OneToMany
   public List<Player_Weapon> weaponsList;
   @Column
   int inflation;

   public WeaponStore() {
   }

   public WeaponStore(int inflation, List<Player_Weapon> weaponsList) {
      this.inflation = inflation;
      this.weaponsList = weaponsList;
   }

   public void setWeaponsList(List<Player_Weapon> weaponsList) {
      this.weaponsList = weaponsList;
   }

   public List<Player_Weapon> getWeaponsList() {
      return weaponsList;
   }

   public int getInflation() {
      return inflation;
   }

   public void setInflation(int inflation) {
      this.inflation = inflation;
   }
}
