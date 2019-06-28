package character.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "legends", catalog = "legends")
public class BookSpecies {
    @ManyToMany(cascade = CascadeType.ALL)
    List<BookReference> bookReferences;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long speciesId;
    private String name;
    private String description;
    private boolean isPlayable;
    private String physiology;
    private String society;
    @Enumerated
    private LanguageType language;
    private int baseBrawn;
    private int baseAgility;
    private int baseIntellect;
    private int baseCunning;
    private int baseWill;
    private int basePresence;
    private int baseExperience;
    private int baseWounds;
    private int baseStrain;
    @ManyToOne
    private BookAbility startingAbility;

    @JsonIgnore
    public long getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(long speciesId) {
        this.speciesId = speciesId;
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

    public boolean isPlayable() {
        return isPlayable;
    }

    public void setPlayable(boolean playable) {
        isPlayable = playable;
    }

    public String getPhysiology() {
        return physiology;
    }

    public void setPhysiology(String physiology) {
        this.physiology = physiology;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public LanguageType getLanguage() {
        return language;
    }

    public void setLanguage(LanguageType language) {
        this.language = language;
    }

    public int getBaseWounds() {
        return baseWounds;
    }

    public void setBaseWounds(int baseWounds) {
        this.baseWounds = baseWounds;
    }

    public int getBaseStrain() {
        return baseStrain;
    }

    public void setBaseStrain(int baseStrain) {
        this.baseStrain = baseStrain;
    }

    public BookAbility getStartingAbility() {
        return startingAbility;
    }

    public void setStartingAbility(BookAbility startingAbility) {
        this.startingAbility = startingAbility;
    }

    public int getBaseBrawn() {
        return baseBrawn;
    }

    public void setBaseBrawn(int baseBrawn) {
        this.baseBrawn = baseBrawn;
    }

    public int getBaseAgility() {
        return baseAgility;
    }

    public void setBaseAgility(int baseAgility) {
        this.baseAgility = baseAgility;
    }

    public int getBaseIntellect() {
        return baseIntellect;
    }

    public void setBaseIntellect(int baseIntellect) {
        this.baseIntellect = baseIntellect;
    }

    public int getBaseCunning() {
        return baseCunning;
    }

    public void setBaseCunning(int baseCunning) {
        this.baseCunning = baseCunning;
    }

    public int getBaseWill() {
        return baseWill;
    }

    public void setBaseWill(int baseWill) {
        this.baseWill = baseWill;
    }

    public int getBasePresence() {
        return basePresence;
    }

    public void setBasePresence(int basePresence) {
        this.basePresence = basePresence;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public List<BookReference> getBookReferences() {
        return bookReferences;
    }

    public void setBookReferences(List<BookReference> bookReferences) {
        this.bookReferences = bookReferences;
    }
}
