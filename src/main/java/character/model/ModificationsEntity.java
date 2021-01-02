package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by yr998d on 1/5/2017.
 */


public class ModificationsEntity extends PanacheEntity {

    String modName;
    Integer price;
    Integer encum;
    Integer hpRequired;
    Integer rarity;
    String bookIndex;
    String modType;
    Boolean restricted;

    public String getModName() {
        return modName;
    }

    public void setModName(String modName) {
        this.modName = modName;
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


    public Integer getHpRequired() {
        return hpRequired;
    }

    public void setHpRequired(Integer hpRequired) {
        this.hpRequired = hpRequired;
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


    public String getModType() {
        return modType;
    }

    public void setModType(String modType) {
        this.modType = modType;
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

        ModificationsEntity that = (ModificationsEntity) o;

        if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
        if (encum != null ? !encum.equals(that.encum) : that.encum != null) return false;
        if (hpRequired != null ? !hpRequired.equals(that.hpRequired) : that.hpRequired != null) return false;
        if (modName != null ? !modName.equals(that.modName) : that.modName != null) return false;
        if (modType != null ? !modType.equals(that.modType) : that.modType != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (rarity != null ? !rarity.equals(that.rarity) : that.rarity != null) return false;
        return restricted != null ? restricted.equals(that.restricted) : that.restricted == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
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
