package character.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "legends", catalog = "legends")
public class BookTalent {
    @ManyToMany(cascade = CascadeType.ALL)
    List<BookReference> bookReferences;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long talentId;
    private String name;
    private boolean isActive;
    private boolean hasActive;
    private boolean isRanked;

    @JsonIgnore
    public long getTalentId() {
        return talentId;
    }

    public void setTalentId(long talentId) {
        this.talentId = talentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
