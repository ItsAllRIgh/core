package character.model;

import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "character_abilities", schema = "", catalog = "legends")
public class CharacterAbilities {
    @Id
    @Column(name = "character_abilities_id")
    private long characterAbilitiesId;
    private String ability;
    private String description;
    private String book_index;


    public long getCharacterAbilitiesId() {
        return characterAbilitiesId;
    }

    public void setCharacterAbilitiesId(long characterAbilitiesId) {
        this.characterAbilitiesId = characterAbilitiesId;
    }


    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getIndex() {
        return book_index;
    }

    public void setIndex(String index) {
        this.book_index = index;
    }

}
