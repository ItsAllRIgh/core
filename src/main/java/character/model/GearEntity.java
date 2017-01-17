package character.model;

import javax.persistence.*;

/**
 * Created by yr998d on 1/5/2017.
 */
@Entity
@Table(name = "gear", schema = "", catalog = "legends")
public class GearEntity {
   private int gearId;
   private String gearName;
   private Integer price;
   private Integer encum;
   private Integer rarity;
   private String bookIndex;
   private String gearType;

   @Id
   @Column(name = "gear_id", nullable = false, insertable = true, updatable = true)
   public int getGearId() {
      return gearId;
   }

   public void setGearId(int gearId) {
      this.gearId = gearId;
   }

   @Basic
   @Column(name = "gear_name", nullable = true, insertable = true, updatable = true, length = 255)
   public String getGearName() {
      return gearName;
   }

   public void setGearName(String gearName) {
      this.gearName = gearName;
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
   @Column(name = "gear_type", nullable = true, insertable = true, updatable = true, length = 25)
   public String getGearType() {
      return gearType;
   }

   public void setGearType(String gearType) {
      this.gearType = gearType;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      GearEntity that = (GearEntity) o;

      if (gearId != that.gearId) return false;
      if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
      if (encum != null ? !encum.equals(that.encum) : that.encum != null) return false;
      if (gearName != null ? !gearName.equals(that.gearName) : that.gearName != null) return false;
      if (gearType != null ? !gearType.equals(that.gearType) : that.gearType != null) return false;
      if (price != null ? !price.equals(that.price) : that.price != null) return false;
      if (rarity != null ? !rarity.equals(that.rarity) : that.rarity != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = gearId;
      result = 31 * result + (gearName != null ? gearName.hashCode() : 0);
      result = 31 * result + (price != null ? price.hashCode() : 0);
      result = 31 * result + (encum != null ? encum.hashCode() : 0);
      result = 31 * result + (rarity != null ? rarity.hashCode() : 0);
      result = 31 * result + (bookIndex != null ? bookIndex.hashCode() : 0);
      result = 31 * result + (gearType != null ? gearType.hashCode() : 0);
      return result;
   }
}
