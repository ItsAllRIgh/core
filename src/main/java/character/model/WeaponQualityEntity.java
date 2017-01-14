package character.model;

import javax.persistence.*;

/**
 * Created by yr998d on 1/5/2017.
 */
@Entity
@Table(name = "weapon_quality", schema = "", catalog = "legends")
public class WeaponQualityEntity {
    @Id
    @Column(name = "weapon_quality_id", nullable = false, insertable = true, updatable = true)
    private int weaponQualityId;
    @Basic
    @Column(name = "quality_name", nullable = true, insertable = true, updatable = true, length = 255)
    private String qualityName;
    @Basic
    @Column(name = "active", nullable = true, insertable = true, updatable = true, length = 12)
    private String active;
    @Basic
    @Column(name = "ranked", nullable = true, insertable = true, updatable = true)
    private Byte ranked;
    @Basic
    @Column(name = "effect", nullable = true, insertable = true, updatable = true, length = 255)
    private String effect;
    @Basic
    @Column(name = "book_index", nullable = true, insertable = true, updatable = true, length = 255)
    private String bookIndex;


    public int getWeaponQualityId() {
        return weaponQualityId;
    }

    public void setWeaponQualityId(int weaponQualityId) {
        this.weaponQualityId = weaponQualityId;
    }


    public String getQualityName() {
        return qualityName;
    }

    public void setQualityName(String qualityName) {
        this.qualityName = qualityName;
    }


    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Byte getRanked() {
        return ranked;
    }

    public void setRanked(Byte ranked) {
        this.ranked = ranked;
    }


    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }


    public String getBookIndex() {
        return bookIndex;
    }

    public void setBookIndex(String bookIndex) {
        this.bookIndex = bookIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeaponQualityEntity that = (WeaponQualityEntity) o;

        if (weaponQualityId != that.weaponQualityId) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
        if (effect != null ? !effect.equals(that.effect) : that.effect != null) return false;
        if (qualityName != null ? !qualityName.equals(that.qualityName) : that.qualityName != null) return false;
        if (ranked != null ? !ranked.equals(that.ranked) : that.ranked != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = weaponQualityId;
        result = 31 * result + (qualityName != null ? qualityName.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (ranked != null ? ranked.hashCode() : 0);
        result = 31 * result + (effect != null ? effect.hashCode() : 0);
        result = 31 * result + (bookIndex != null ? bookIndex.hashCode() : 0);
        return result;
    }
}
