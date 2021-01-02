package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


public class Book extends PanacheEntity {


    String name;
    BookSystem system;
    String acronym;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookSystem getSystem() {
        return system;
    }

    public void setSystem(BookSystem system) {
        this.system = system;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Override
    public String toString() {
        return "Book{" +
                " name='" + name + '\'' +
                ", system=" + system +
                ", acronym='" + acronym + '\'' +
                '}';
    }
}
