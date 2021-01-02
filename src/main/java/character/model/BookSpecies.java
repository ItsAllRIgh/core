package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;

public class BookSpecies extends PanacheEntity {

    List<BookReference> bookReferences;
    String name;
    String description;
    boolean isPlayable;
    String physiology;
    String society;
    LanguageType language;
    int baseBrawn;
    int baseAgility;
    int baseIntellect;
    int baseCunning;
    int baseWill;
    int basePresence;
    int baseExperience;
    int baseWounds;
    int baseStrain;
    BookAbility startingAbility;


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
