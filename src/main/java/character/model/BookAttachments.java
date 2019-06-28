package character.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "legends", catalog = "legends")
public class BookAttachments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long attachmentId;
    private String name;
    private String description;
    private int price;
    private int HPCost;
    private int encum;
    private int rarity;
    @ManyToMany(cascade = CascadeType.ALL)
    List<BookReference> bookReferences;

    @JsonIgnore
    public long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(long attachmentId) {
        this.attachmentId = attachmentId;
    }

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
        return attachmentId == that.attachmentId &&
                price == that.price &&
                HPCost == that.HPCost &&
                encum == that.encum &&
                rarity == that.rarity &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(attachmentId, name, description, price, HPCost, encum, rarity);
    }
}
