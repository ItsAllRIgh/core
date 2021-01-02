package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;

/**
 * Created by yr998d on 1/5/2017.
 */


public class BookWeapons extends PanacheEntity {

    List<BookReference> bookReferences;
    String weaponName;
    String skill;
    Integer damage;
    String critical;
    String wepRange;
    Integer encumbrance;
    Integer hp;
    Integer price;
    Integer rarity;
    String special;
    String bookIndex;
    String weapType;
    Boolean restricted;


    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getWepRange() {
        return wepRange;
    }

    public void setWepRange(String wepRange) {
        this.wepRange = wepRange;
    }

    public Integer getEncumbrance() {
        return encumbrance;
    }

    public void setEncumbrance(Integer encumbrance) {
        this.encumbrance = encumbrance;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getBookIndex() {
        return bookIndex;
    }

    public void setBookIndex(String bookIndex) {
        this.bookIndex = bookIndex;
    }

    public String getWeapType() {
        return weapType;
    }

    public void setWeapType(String weapType) {
        this.weapType = weapType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookWeapons that = (BookWeapons) o;

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
        return wepRange != null ? wepRange.equals(that.wepRange) : that.wepRange == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
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
