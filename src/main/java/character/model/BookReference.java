package character.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(schema = "legends", catalog = "legends")
public class BookReference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long referenceId;
    private int pageNumber;
    @ManyToOne
    private Book book;

    @JsonIgnore
    public long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(long referenceId) {
        this.referenceId = referenceId;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookReference{" +
                "referenceId=" + referenceId +
                ", pageNumber=" + pageNumber +
                ", book=" + book +
                '}';
    }
}
