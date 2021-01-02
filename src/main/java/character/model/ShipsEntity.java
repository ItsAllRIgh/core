package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by yr998d on 1/5/2017.
 */


public class ShipsEntity extends PanacheEntity {

    String shipName;
    Integer sil;
    Integer spd;
    Integer hand;
    String model;
    String man;
    String hdNc;
    Integer crew;
    Integer encum;
    Integer pass;
    Integer cost;
    Integer rarity;
    Integer hp;
    Integer wep;
    Integer fuel;
    String bookIndex;
    Boolean restricted;


    public Integer getFuel() {
        return fuel;
    }

    public void setFuel(Integer fuel) {
        this.fuel = fuel;
    }


    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }


    public Integer getSil() {
        return sil;
    }

    public void setSil(Integer sil) {
        this.sil = sil;
    }


    public Integer getSpd() {
        return spd;
    }

    public void setSpd(Integer spd) {
        this.spd = spd;
    }


    public Integer getHand() {
        return hand;
    }

    public void setHand(Integer hand) {
        this.hand = hand;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }


    public String getHdNc() {
        return hdNc;
    }

    public void setHdNc(String hdNc) {
        this.hdNc = hdNc;
    }


    public Integer getCrew() {
        return crew;
    }

    public void setCrew(Integer crew) {
        this.crew = crew;
    }


    public Integer getEncum() {
        return encum;
    }

    public void setEncum(Integer encum) {
        this.encum = encum;
    }


    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }


    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }


    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }


    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }


    public Integer getWep() {
        return wep;
    }

    public void setWep(Integer wep) {
        this.wep = wep;
    }


    public String getBookIndex() {
        return bookIndex;
    }

    public void setBookIndex(String bookIndex) {
        this.bookIndex = bookIndex;
    }


    public Boolean getRestricted() {
        return restricted;
    }

    public void setRestricted(Boolean restricted) {
        this.restricted = restricted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShipsEntity that = (ShipsEntity) o;

        if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (crew != null ? !crew.equals(that.crew) : that.crew != null) return false;
        if (encum != null ? !encum.equals(that.encum) : that.encum != null) return false;
        if (hand != null ? !hand.equals(that.hand) : that.hand != null) return false;
        if (hdNc != null ? !hdNc.equals(that.hdNc) : that.hdNc != null) return false;
        if (hp != null ? !hp.equals(that.hp) : that.hp != null) return false;
        if (man != null ? !man.equals(that.man) : that.man != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (pass != null ? !pass.equals(that.pass) : that.pass != null) return false;
        if (rarity != null ? !rarity.equals(that.rarity) : that.rarity != null) return false;
        if (restricted != null ? !restricted.equals(that.restricted) : that.restricted != null) return false;
        if (shipName != null ? !shipName.equals(that.shipName) : that.shipName != null) return false;
        if (sil != null ? !sil.equals(that.sil) : that.sil != null) return false;
        if (spd != null ? !spd.equals(that.spd) : that.spd != null) return false;
        return wep != null ? wep.equals(that.wep) : that.wep == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (shipName != null ? shipName.hashCode() : 0);
        result = 31 * result + (sil != null ? sil.hashCode() : 0);
        result = 31 * result + (spd != null ? spd.hashCode() : 0);
        result = 31 * result + (hand != null ? hand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (man != null ? man.hashCode() : 0);
        result = 31 * result + (hdNc != null ? hdNc.hashCode() : 0);
        result = 31 * result + (crew != null ? crew.hashCode() : 0);
        result = 31 * result + (encum != null ? encum.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (rarity != null ? rarity.hashCode() : 0);
        result = 31 * result + (hp != null ? hp.hashCode() : 0);
        result = 31 * result + (wep != null ? wep.hashCode() : 0);
        result = 31 * result + (bookIndex != null ? bookIndex.hashCode() : 0);
        result = 31 * result + (restricted != null ? restricted.hashCode() : 0);
        return result;
    }
}
