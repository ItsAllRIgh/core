package character.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "legends", catalog = "legends")
public class BookSurfaceVehicle {
    @ManyToMany(cascade = CascadeType.ALL)
    List<BookReference> bookReferences;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vehicleId;
    @Enumerated
    private VehicleType type;
    private String description;
    private int silhouette;
    private int speed;
    private int handling;
    private String manufacturer;
    private String model;
    private int crewCap;
    private int encum;
    private int passengerCap;
    private int price;
    private int rarity;
    private int weaponCap;
    private int hp;

    @JsonIgnore
    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookSurfaceVehicle that = (BookSurfaceVehicle) o;
        return vehicleId == that.vehicleId &&
                silhouette == that.silhouette &&
                speed == that.speed &&
                handling == that.handling &&
                crewCap == that.crewCap &&
                encum == that.encum &&
                passengerCap == that.passengerCap &&
                price == that.price &&
                rarity == that.rarity &&
                weaponCap == that.weaponCap &&
                hp == that.hp &&
                type == that.type &&
                Objects.equals(description, that.description) &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {

        return Objects.hash(vehicleId, type, description, silhouette, speed, handling, manufacturer, model, crewCap, encum, passengerCap, price, rarity, weaponCap, hp);
    }
}
