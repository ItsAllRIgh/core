package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;

/**
 * Created by yr998d on 1/5/2017.
 */


public class BookArmor extends PanacheEntity {

    List<BookReference> bookReferences;


    String armorName;
    Integer defense;
    Integer soak;
    Integer price;
    Integer encum;
    Integer hp;
    Integer rarity;
    String bookIndex;
    Boolean restricted;

    String description;


    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSoak() {
        return soak;
    }

    public void setSoak(Integer soak) {
        this.soak = soak;
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

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
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

    public Boolean getRestricted() {
        return restricted;
    }

    public void setRestricted(Boolean restricted) {
        this.restricted = restricted;
    }

    public List<BookReference> getBookReferences() {
        return bookReferences;
    }

    public void setBookReferences(List<BookReference> bookReferences) {
        this.bookReferences = bookReferences;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookArmor that = (BookArmor) o;

        if (armorName != null ? !armorName.equals(that.armorName) : that.armorName != null) return false;
        if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
        if (defense != null ? !defense.equals(that.defense) : that.defense != null) return false;
        if (soak != null ? !soak.equals(that.soak) : that.soak != null) return false;
        if (encum != null ? !encum.equals(that.encum) : that.encum != null) return false;
        if (hp != null ? !hp.equals(that.hp) : that.hp != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (rarity != null ? !rarity.equals(that.rarity) : that.rarity != null) return false;
        return restricted != null ? restricted.equals(that.restricted) : that.restricted == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
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
