package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;
import java.util.Objects;


public class BookAttachments extends PanacheEntity {


    String name;
    String description;
    int price;
    int HPCost;
    int encum;
    int rarity;

    List<BookReference> bookReferences;


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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHPCost() {
        return HPCost;
    }

    public void setHPCost(int HPCost) {
        this.HPCost = HPCost;
    }

    public int getEncum() {
        return encum;
    }

    public void setEncum(int encum) {
        this.encum = encum;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
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
        BookAttachments that = (BookAttachments) o;
        return  price == that.price &&
                HPCost == that.HPCost &&
                encum == that.encum &&
                rarity == that.rarity &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, price, HPCost, encum, rarity);
    }
}
