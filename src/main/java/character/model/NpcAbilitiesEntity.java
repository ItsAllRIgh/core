package character.model;

import javax.persistence.*;

/**
 * Created by yr998d on 1/5/2017.
 */
@Entity
@Table(name = "npc_abilities", schema = "", catalog = "legends")
public class NpcAbilitiesEntity {
    private int npcAbilitiesId;
    private String abilityName;
    private String description;
    private String bookIndex;

    @Id
    @Column(name = "npc_abilities_id", nullable = false, insertable = true, updatable = true)
    public int getNpcAbilitiesId() {
        return npcAbilitiesId;
    }

    public void setNpcAbilitiesId(int npcAbilitiesId) {
        this.npcAbilitiesId = npcAbilitiesId;
    }

    @Basic
    @Column(name = "ability_name", nullable = true, insertable = true, updatable = true, length = 45)
    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 4000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "book_index", nullable = true, insertable = true, updatable = true, length = 255)
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

        if (npcAbilitiesId != that.npcAbilitiesId) return false;
        if (abilityName != null ? !abilityName.equals(that.abilityName) : that.abilityName != null) return false;
        if (bookIndex != null ? !bookIndex.equals(that.bookIndex) : that.bookIndex != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = npcAbilitiesId;
        result = 31 * result + (abilityName != null ? abilityName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (bookIndex != null ? bookIndex.hashCode() : 0);
        return result;
    }
}
