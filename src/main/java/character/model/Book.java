package character.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(schema = "legends", catalog = "legends")
@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    private String name;
    @Enumerated
    private BookSystem system;
    private String acronym;

    @JsonIgnore
    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

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
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", system=" + system +
                ", acronym='" + acronym + '\'' +
                '}';
    }
}
