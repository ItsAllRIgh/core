package character.model;

import javax.persistence.*;

/**
 * Created by Th'MASA of on 1/22/2017.
 */
@Entity
@Table(name = "player_gear")
public class Gear {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @ManyToOne
    private GearEntity bookBase;


    public Gear() {
    }

    public Gear(GearEntity base) {
        this.bookBase = base;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GearEntity getBookBase() {
        return bookBase;
    }

    public void setBookBase(GearEntity bookBase) {
        this.bookBase = bookBase;
    }

}
