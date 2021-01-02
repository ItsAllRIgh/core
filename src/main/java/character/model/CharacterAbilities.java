package character.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

public class CharacterAbilities extends PanacheEntity {


    String ability;
    String description;
    String book_index;

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
