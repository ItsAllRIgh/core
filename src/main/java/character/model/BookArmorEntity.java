package character.model;

import javax.persistence.*;

/**
 * Created by yr998d on 1/5/2017.
 */
@Entity
@Table(name = "book_armor", schema = "", catalog = "legends")
public class BookArmorEntity {
   private int armorId;
   private String armorName;
   private Integer defense;
   private Integer soak;
   private Integer price;
   private Integer encum;
   private Integer hp;
   private Integer rarity;
   private String bookIndex;
   private Byte restricted;

   @Id
   @Column(name = "armor_id", nullable = false, insertable = true, updatable = true)
   public int getArmorId() {
      return armorId;
   }

   public void setArmorId(int armorId) {
      this.armorId = armorId;
   }

   @Basic
   @Column(name = "armor_name", nullable = true, insertable = true, updatable = true, length = 255)
   public String getArmorName() {
      return armorName;
   }

   public void setArmorName(String armorName) {
      this.armorName = armorName;
   }

   @Basic
   @Column(name = "defense", nullable = true, insertable = true, updatable = true)
   public Integer getDefense() {
      return defense;
   }

   public void setDefense(Integer defense) {
      this.defense = defense;
   }

   @Basic
   @Column(name = "soak", nullable = true, insertable = true, updatable = true)
   public Integer getSoak() {
      return soak;
   }

   public void setSoak(Integer soak) {
      this.soak = soak;
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
   @Column(name = "encum", nullable = true, insertable = true, updatable = true)
   public Integer getEncum() {
      return encum;
   }

   public void setEncum(Integer encum) {
      this.encum = encum;
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
   @Column(name = "rarity", nullable = true, insertable = true, updatable = true)
   public Integer getRarity() {
      return rarity;
   }

   public void setRarity(Integer rarity) {
      this.rarity = rarity;
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

      BookArmorEntity that = (BookArmorEntity) o;

      if (armorId != that.armorId) return false;
      if (armorName != null ? !armorName.equals(that.armorName) : that.armorName != null) return false;
      if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
      if (defense != null ? !defense.equals(that.defense) : that.defense != null) return false;
      if (soak != null ? !soak.equals(that.soak) : that.soak != null) return false;
      if (encum != null ? !encum.equals(that.encum) : that.encum != null) return false;
      if (hp != null ? !hp.equals(that.hp) : that.hp != null) return false;
      if (price != null ? !price.equals(that.price) : that.price != null) return false;
      if (rarity != null ? !rarity.equals(that.rarity) : that.rarity != null) return false;
      if (restricted != null ? !restricted.equals(that.restricted) : that.restricted != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = armorId;
      result = 31 * result + (armorName != null ? armorName.hashCode() : 0);
      result = 31 * result + (defense != null ? defense.hashCode() : 0);
      result = 31 * result + (soak != null ? soak.hashCode() : 0);
      result = 31 * result + (price != null ? price.hashCode() : 0);
      result = 31 * result + (encum != null ? encum.hashCode() : 0);
      result = 31 * result + (hp != null ? hp.hashCode() : 0);
      result = 31 * result + (rarity != null ? rarity.hashCode() : 0);
      result = 31 * result + (bookIndex != null ? bookIndex.hashCode() : 0);
      result = 31 * result + (restricted != null ? restricted.hashCode() : 0);
      return result;
   }
}
