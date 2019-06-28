package character.model;

public enum BookSystem {
    EotE("Edge of the Empire"), AoR("Age of Rebellion"), SWRPG("Star Wars Roleplaying"), FaD("Force and Destiny"), CUSTOM("Custom");

    private final String text;

    /**
     * @param text
     */
    BookSystem(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
