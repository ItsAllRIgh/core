package character.model;

import javax.persistence.*;

/**
 * Created by yr998d on 1/5/2017.
 */
@Entity
@Table(name = "ships", schema = "", catalog = "legends")
public class ShipsEntity {
   private int shipsId;
   private String shipName;
   private Integer sil;
   private Integer spd;
   private Integer hand;
   private String model;
   private String man;
   private String hdNc;
   private Integer crew;
   private Integer encum;
   private Integer pass;
   private Integer cost;
   private Integer rarity;
   private Integer hp;
   private Integer wep;
   private Integer fuel;
   private String bookIndex;
   private Byte restricted;

   @Id
   @Column(name = "ships_id", nullable = false, insertable = true, updatable = true)
   public int getShipsId() {
      return shipsId;
   }

   public void setShipsId(int shipsId) {
      this.shipsId = shipsId;
   }

   @Basic
   @Column(name = "fuel", nullable = true, insertable = true, updatable = true)
   public Integer getFuel() {
      return fuel;
   }

   public void setFuel(Integer fuel) {
      this.fuel = fuel;
   }

   @Basic
   @Column(name = "ship_name", nullable = true, insertable = true, updatable = true, length = 255)
   public String getShipName() {
      return shipName;
   }

   public void setShipName(String shipName) {
      this.shipName = shipName;
   }

   @Basic
   @Column(name = "sil", nullable = true, insertable = true, updatable = true)
   public Integer getSil() {
      return sil;
   }

   public void setSil(Integer sil) {
      this.sil = sil;
   }

   @Basic
   @Column(name = "spd", nullable = true, insertable = true, updatable = true)
   public Integer getSpd() {
      return spd;
   }

   public void setSpd(Integer spd) {
      this.spd = spd;
   }

   @Basic
   @Column(name = "hand", nullable = true, insertable = true, updatable = true)
   public Integer getHand() {
      return hand;
   }

   public void setHand(Integer hand) {
      this.hand = hand;
   }

   @Basic
   @Column(name = "model", nullable = true, insertable = true, updatable = true, length = 45)
   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   @Basic
   @Column(name = "man", nullable = true, insertable = true, updatable = true, length = 255)
   public String getMan() {
      return man;
   }

   public void setMan(String man) {
      this.man = man;
   }

   @Basic
   @Column(name = "HD_NC", nullable = true, insertable = true, updatable = true, length = 25)
   public String getHdNc() {
      return hdNc;
   }

   public void setHdNc(String hdNc) {
      this.hdNc = hdNc;
   }

   @Basic
   @Column(name = "crew", nullable = true, insertable = true, updatable = true)
   public Integer getCrew() {
      return crew;
   }

   public void setCrew(Integer crew) {
      this.crew = crew;
   }

   @Basic
   @Column(name = "encum", nullable = true, insertable = true, updatable = true)
   public Integer getEncum() {
      return encum;
   }

   public void setEncum(Integer encum) {
      this.encum = encum;
   }

   @Basic
   @Column(name = "pass", nullable = true, insertable = true, updatable = true)
   public Integer getPass() {
      return pass;
   }

   public void setPass(Integer pass) {
      this.pass = pass;
   }

   @Basic
   @Column(name = "cost", nullable = true, insertable = true, updatable = true)
   public Integer getCost() {
      return cost;
   }

   public void setCost(Integer cost) {
      this.cost = cost;
   }

   @Basic
   @Column(name = "rarity", nullable = true, insertable = true, updatable = true)
   public Integer getRarity() {
      return rarity;
   }

   public void setRarity(Integer rarity) {
      this.rarity = rarity;
   }

   @Basic
   @Column(name = "HP", nullable = true, insertable = true, updatable = true)
   public Integer getHp() {
      return hp;
   }

   public void setHp(Integer hp) {
      this.hp = hp;
   }

   @Basic
   @Column(name = "wep", nullable = true, insertable = true, updatable = true)
   public Integer getWep() {
      return wep;
   }

   public void setWep(Integer wep) {
      this.wep = wep;
   }

   @Basic
   @Column(name = "book_index", nullable = true, insertable = true, updatable = true, length = 255)
   public String getBookIndex() {
      return bookIndex;
   }

   public void setBookIndex(String bookIndex) {
      this.bookIndex = bookIndex;
   }

   @Basic
   @Column(name = "restricted", nullable = true, insertable = true, updatable = true)
   public Byte getRestricted() {
      return restricted;
   }

   public void setRestricted(Byte restricted) {
      this.restricted = restricted;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ShipsEntity that = (ShipsEntity) o;

      if (shipsId != that.shipsId) return false;
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
      if (wep != null ? !wep.equals(that.wep) : that.wep != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = shipsId;
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
