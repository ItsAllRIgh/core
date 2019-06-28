package character.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "legends", catalog = "legends")
public class BookWeaponQualities {
    @ManyToMany(cascade = CascadeType.ALL)
    List<BookReference> bookReferences;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long weaponQualityId;
    private String name;
    private String description;
    private boolean isActive;
    private boolean hasActive;
    private boolean isRanked;

    @JsonIgnore
    public long getWeaponQualityId() {
        return weaponQualityId;
    }

    public void setWeaponQualityId(long weaponQualityId) {
        this.weaponQualityId = weaponQualityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isHasActive() {
        return hasActive;
    }

    public void setHasActive(boolean hasActive) {
        this.hasActive = hasActive;
    }

    public boolean isRanked() {
        return isRanked;
    }

    public void setRanked(boolean ranked) {
        isRanked = ranked;
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
        BookWeaponQualities that = (BookWeaponQualities) o;
        return weaponQualityId == that.weaponQualityId &&
                isActive == that.isActive &&
                hasActive == that.hasActive &&
                isRanked == that.isRanked &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(weaponQualityId, name, description, isActive, hasActive, isRanked);
    }
}
