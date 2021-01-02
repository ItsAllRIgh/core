package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;


public class BookAbility extends PanacheEntity {

    List<BookReference> bookReferences;


    String name;
    String description;



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

    public List<BookReference> getBookReferences() {
        return bookReferences;
    }

    public void setBookReferences(List<BookReference> bookReferences) {
        this.bookReferences = bookReferences;
    }
}
