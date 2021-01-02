package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by yr998d on 1/5/2017.
 */


public class GearEntity extends PanacheEntity {

    String gearName;
    Integer price;
    Integer encum;
    Integer rarity;
    String bookIndex;
    String gearType;

    public String getGearName() {
        return gearName;
    }

    public void setGearName(String gearName) {
        this.gearName = gearName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getEncum() {
        return encum;
    }

    public void setEncum(Integer encum) {
        this.encum = encum;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }


    public String getBookIndex() {
        return bookIndex;
    }

    public void setBookIndex(String bookIndex) {
        this.bookIndex = bookIndex;
    }


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

        if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
        if (encum != null ? !encum.equals(that.encum) : that.encum != null) return false;
        if (gearName != null ? !gearName.equals(that.gearName) : that.gearName != null) return false;
        if (gearType != null ? !gearType.equals(that.gearType) : that.gearType != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return rarity != null ? rarity.equals(that.rarity) : that.rarity == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (gearName != null ? gearName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (encum != null ? encum.hashCode() : 0);
        result = 31 * result + (rarity != null ? rarity.hashCode() : 0);
        result = 31 * result + (bookIndex != null ? bookIndex.hashCode() : 0);
        result = 31 * result + (gearType != null ? gearType.hashCode() : 0);
        return result;
    }
}
