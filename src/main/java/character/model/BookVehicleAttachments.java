package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;
import java.util.Objects;


public class BookVehicleAttachments extends PanacheEntity {

    List<BookReference> bookReferences;
    String name;
    String description;
    int price;
    int rarity;
    int HPCost;

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

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getHPCost() {
        return HPCost;
    }

    public void setHPCost(int HPCost) {
        this.HPCost = HPCost;
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
        BookVehicleAttachments that = (BookVehicleAttachments) o;
        return  price == that.price &&
                rarity == that.rarity &&
                HPCost == that.HPCost &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, price, rarity, HPCost);
    }
}
