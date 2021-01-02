package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;


public class BookStarship extends PanacheEntity {

    List<BookReference> bookReferences;


    StarshipType type;
    String description;
    int silhouette;
    int speed;
    int handling;
    String manufacturer;
    String model;
    int crewCap;
    int encum;
    int passengerCap;
    int price;
    int rarity;
    int weaponCap;
    int hp;


    public StarshipType getType() {
        return type;
    }

    public void setType(StarshipType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSilhouette() {
        return silhouette;
    }

    public void setSilhouette(int silhouette) {
        this.silhouette = silhouette;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHandling() {
        return handling;
    }

    public void setHandling(int handling) {
        this.handling = handling;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCrewCap() {
        return crewCap;
    }

    public void setCrewCap(int crewCap) {
        this.crewCap = crewCap;
    }

    public int getEncum() {
        return encum;
    }

    public void setEncum(int encum) {
        this.encum = encum;
    }

    public int getPassengerCap() {
        return passengerCap;
    }

    public void setPassengerCap(int passengerCap) {
        this.passengerCap = passengerCap;
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

    public int getWeaponCap() {
        return weaponCap;
    }

    public void setWeaponCap(int weaponCap) {
        this.weaponCap = weaponCap;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public List<BookReference> getBookReferences() {
        return bookReferences;
    }

    public void setBookReferences(List<BookReference> bookReferences) {
        this.bookReferences = bookReferences;
    }
}
