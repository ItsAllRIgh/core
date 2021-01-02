package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Created by Th'MASA of on 1/22/2017.
 */


public class Gear extends PanacheEntity {
    GearEntity bookBase;

    public GearEntity getBookBase() {
        return bookBase;
    }

    public void setBookBase(GearEntity bookBase) {
        this.bookBase = bookBase;
    }

}
