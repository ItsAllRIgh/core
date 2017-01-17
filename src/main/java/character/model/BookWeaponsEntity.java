package character.model;

import javax.persistence.*;

/**
 * Created by yr998d on 1/5/2017.
 */
@Entity
@Table(name = "book_weapons", schema = "", catalog = "legends")
public class BookWeaponsEntity {
   @Id
   @Column(name = "weapons_id", nullable = false, insertable = true, updatable = true)
   private int weaponsId;
   private String weaponName;
   private String skill;
   private Integer damage;
   private String critical;
   private String wepRange;
   private Integer encumbrance;
   private Integer hp;
   private Integer price;
   private Integer rarity;
   private String special;
   private String bookIndex;
   private String weapType;
   private Byte restricted;


   public int getWeaponsId() {
      return weaponsId;
   }

   public void setWeaponsId(int weaponsId) {
      this.weaponsId = weaponsId;
   }

   @Basic
   @Column(name = "weapon_name", nullable = true, insertable = true, updatable = true, length = 255)
   public String getWeaponName() {
      return weaponName;
   }

   public void setWeaponName(String weaponName) {
      this.weaponName = weaponName;
   }

   @Basic
   @Column(name = "skill", nullable = true, insertable = true, updatable = true, length = 25)
   public String getSkill() {
      return skill;
   }

   public void setSkill(String skill) {
      this.skill = skill;
   }

   @Basic
   @Column(name = "damage", nullable = true, insertable = true, updatable = true)
   public Integer getDamage() {
      return damage;
   }

   public void setDamage(Integer damage) {
      this.damage = damage;
   }

   @Basic
   @Column(name = "critical", nullable = true, insertable = true, updatable = true, length = 5)
   public String getCritical() {
      return critical;
   }

   public void setCritical(String critical) {
      this.critical = critical;
   }

   @Basic
   @Column(name = "wep_range", nullable = true, insertable = true, updatable = true, length = 12)
   public String getWepRange() {
      return wepRange;
   }

   public void setWepRange(String wepRange) {
      this.wepRange = wepRange;
   }

   @Basic
   @Column(name = "encumbrance", nullable = true, insertable = true, updatable = true)
   public Integer getEncumbrance() {
      return encumbrance;
   }

   public void setEncumbrance(Integer encumbrance) {
      this.encumbrance = encumbrance;
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
   @Column(name = "price", nullable = true, insertable = true, updatable = true)
   public Integer getPrice() {
      return price;
   }

   public void setPrice(Integer price) {
      this.price = price;
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
   @Column(name = "special", nullable = true, insertable = true, updatable = true, length = 255)
   public String getSpecial() {
      return special;
   }

   public void setSpecial(String special) {
      this.special = special;
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
   @Column(name = "weap_type", nullable = true, insertable = true, updatable = true, length = 25)
   public String getWeapType() {
      return weapType;
   }

   public void setWeapType(String weapType) {
      this.weapType = weapType;
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

      BookWeaponsEntity that = (BookWeaponsEntity) o;

      if (weaponsId != that.weaponsId) return false;
      if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
      if (critical != null ? !critical.equals(that.critical) : that.critical != null) return false;
      if (damage != null ? !damage.equals(that.damage) : that.damage != null) return false;
      if (encumbrance != null ? !encumbrance.equals(that.encumbrance) : that.encumbrance != null) return false;
      if (hp != null ? !hp.equals(that.hp) : that.hp != null) return false;
      if (price != null ? !price.equals(that.price) : that.price != null) return false;
      if (rarity != null ? !rarity.equals(that.rarity) : that.rarity != null) return false;
      if (restricted != null ? !restricted.equals(that.restricted) : that.restricted != null) return false;
      if (skill != null ? !skill.equals(that.skill) : that.skill != null) return false;
      if (special != null ? !special.equals(that.special) : that.special != null) return false;
      if (weapType != null ? !weapType.equals(that.weapType) : that.weapType != null) return false;
      if (weaponName != null ? !weaponName.equals(that.weaponName) : that.weaponName != null) return false;
      if (wepRange != null ? !wepRange.equals(that.wepRange) : that.wepRange != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = weaponsId;
      result = 31 * result + (weaponName != null ? weaponName.hashCode() : 0);
      result = 31 * result + (skill != null ? skill.hashCode() : 0);
      result = 31 * result + (damage != null ? damage.hashCode() : 0);
      result = 31 * result + (critical != null ? critical.hashCode() : 0);
      result = 31 * result + (wepRange != null ? wepRange.hashCode() : 0);
      result = 31 * result + (encumbrance != null ? encumbrance.hashCode() : 0);
      result = 31 * result + (hp != null ? hp.hashCode() : 0);
      result = 31 * result + (price != null ? price.hashCode() : 0);
      result = 31 * result + (rarity != null ? rarity.hashCode() : 0);
      result = 31 * result + (special != null ? special.hashCode() : 0);
      result = 31 * result + (bookIndex != null ? bookIndex.hashCode() : 0);
      result = 31 * result + (weapType != null ? weapType.hashCode() : 0);
      result = 31 * result + (restricted != null ? restricted.hashCode() : 0);
      return result;
   }
}
