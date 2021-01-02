package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;
import java.util.Objects;


public class BookWeaponQualities extends PanacheEntity {

    List<BookReference> bookReferences;
    String name;
    String description;
    boolean isActive;
    boolean hasActive;
    boolean isRanked;

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
        return isActive == that.isActive &&
                hasActive == that.hasActive &&
                isRanked == that.isRanked &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, isActive, hasActive, isRanked);
    }
}
