package character.model;

public enum SkillType {
    General(0), Knowledge(1);

    int val;

    SkillType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
