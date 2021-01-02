package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by yr998d on 1/5/2017.
 */


public class NpcAbilitiesEntity extends PanacheEntity {

    String abilityName;
    String description;
    String bookIndex;

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        NpcAbilitiesEntity that = (NpcAbilitiesEntity) o;

        if (abilityName != null ? !abilityName.equals(that.abilityName) : that.abilityName != null) return false;
        if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (abilityName != null ? abilityName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (bookIndex != null ? bookIndex.hashCode() : 0);
        return result;
    }
}
