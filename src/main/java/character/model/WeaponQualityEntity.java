package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by yr998d on 1/5/2017.
 */


public class WeaponQualityEntity extends PanacheEntity {


    String qualityName;
    String active;
    Boolean ranked;
    String effect;
    String bookIndex;



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

    public Boolean getRanked() {
        return ranked;
    }

    public void setRanked(Boolean ranked) {
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

        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
        if (effect != null ? !effect.equals(that.effect) : that.effect != null) return false;
        if (qualityName != null ? !qualityName.equals(that.qualityName) : that.qualityName != null) return false;
        return ranked != null ? ranked.equals(that.ranked) : that.ranked == null;
    }

    @Override
    public int hashCode() {
        int result = 31 * 0 + (qualityName != null ? qualityName.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (ranked != null ? ranked.hashCode() : 0);
        result = 31 * result + (effect != null ? effect.hashCode() : 0);
        result = 31 * result + (bookIndex != null ? bookIndex.hashCode() : 0);
        return result;
    }
}
