package character.model;

import javax.persistence.*;

/**
 * Created by yr998d on 1/5/2017.
 */
@Entity
@Table(name = "modifications", schema = "", catalog = "legends")
public class ModificationsEntity {
   private int modificationsId;
   private String modName;
   private Integer price;
   private Integer encum;
   private Integer hpRequired;
   private Integer rarity;
   private String bookIndex;
   private String modType;
   private Byte restricted;

   @Id
   @Column(name = "modifications_id", nullable = false, insertable = true, updatable = true)
   public int getModificationsId() {
      return modificationsId;
   }

   public void setModificationsId(int modificationsId) {
      this.modificationsId = modificationsId;
   }

   @Basic
   @Column(name = "mod_name", nullable = true, insertable = true, updatable = true, length = 255)
   public String getModName() {
      return modName;
   }

   public void setModName(String modName) {
      this.modName = modName;
   }

   @Basic
   @Column(name = "Price", nullable = true, insertable = true, updatable = true)
   public Integer getPrice() {
      return price;
   }

   public void setPrice(Integer price) {
      this.price = price;
   }

   @Basic
   @Column(name = "Encum", nullable = true, insertable = true, updatable = true)
   public Integer getEncum() {
      return encum;
   }

   public void setEncum(Integer encum) {
      this.encum = encum;
   }

   @Basic
   @Column(name = "HP_Required", nullable = true, insertable = true, updatable = true)
   public Integer getHpRequired() {
      return hpRequired;
   }

   public void setHpRequired(Integer hpRequired) {
      this.hpRequired = hpRequired;
   }

   @Basic
   @Column(name = "Rarity", nullable = true, insertable = true, updatable = true)
   public Integer getRarity() {
      return rarity;
   }

   public void setRarity(Integer rarity) {
      this.rarity = rarity;
   }

   @Basic
   @Column(name = "book_index", nullable = true, insertable = true, updatable = true, length = 45)
   public String getBookIndex() {
      return bookIndex;
   }

   public void setBookIndex(String bookIndex) {
      this.bookIndex = bookIndex;
   }

   @Basic
   @Column(name = "mod_type", nullable = true, insertable = true, updatable = true, length = 12)
   public String getModType() {
      return modType;
   }

   public void setModType(String modType) {
      this.modType = modType;
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

      ModificationsEntity that = (ModificationsEntity) o;

      if (modificationsId != that.modificationsId) return false;
      if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
      if (encum != null ? !encum.equals(that.encum) : that.encum != null) return false;
      if (hpRequired != null ? !hpRequired.equals(that.hpRequired) : that.hpRequired != null) return false;
      if (modName != null ? !modName.equals(that.modName) : that.modName != null) return false;
      if (modType != null ? !modType.equals(that.modType) : that.modType != null) return false;
      if (price != null ? !price.equals(that.price) : that.price != null) return false;
      if (rarity != null ? !rarity.equals(that.rarity) : that.rarity != null) return false;
      if (restricted != null ? !restricted.equals(that.restricted) : that.restricted != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = modificationsId;
      result = 31 * result + (modName != null ? modName.hashCode() : 0);
      result = 31 * result + (price != null ? price.hashCode() : 0);
      result = 31 * result + (encum != null ? encum.hashCode() : 0);
      result = 31 * result + (hpRequired != null ? hpRequired.hashCode() : 0);
      result = 31 * result + (rarity != null ? rarity.hashCode() : 0);
      result = 31 * result + (bookIndex != null ? bookIndex.hashCode() : 0);
      result = 31 * result + (modType != null ? modType.hashCode() : 0);
      result = 31 * result + (restricted != null ? restricted.hashCode() : 0);
      return result;
   }
}
