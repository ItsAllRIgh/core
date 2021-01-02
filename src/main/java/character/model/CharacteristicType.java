package character.model;

public enum CharacteristicType {
    Intellect(0), Brawn(1), Cunning(2), Willpower(4), Presence(5), Agility(6);
    int val;

    CharacteristicType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }


}
