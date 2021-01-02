package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;

/**
 * Created by yr998d on 1/13/2017.
 */

public class WeaponStore extends PanacheEntity {

    public List<Player_Weapon> weaponsList;
    int inflation;

    public WeaponStore() {
    }

    public WeaponStore(int inflation, List<Player_Weapon> weaponsList) {
        this.inflation = inflation;
        this.weaponsList = weaponsList;
    }

    public List<Player_Weapon> getWeaponsList() {
        return weaponsList;
    }

    public void setWeaponsList(List<Player_Weapon> weaponsList) {
        this.weaponsList = weaponsList;
    }

    public int getInflation() {
        return inflation;
    }

    public void setInflation(int inflation) {
        this.inflation = inflation;
    }
}
