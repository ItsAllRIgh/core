package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

public class BookReference extends PanacheEntity {

    int pageNumber;
    Book book;


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
                " pageNumber=" + pageNumber +
                ", book=" + book +
                '}';
    }
}
