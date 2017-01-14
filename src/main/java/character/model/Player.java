package character.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Th'MASA of on 1/2/2017.
 */
@Entity
@Table(name = "user_character", schema = "", catalog = "legends")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8634742315900681847L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name = "NAME";
    public String userName = "";
    @ManyToOne(cascade = CascadeType.ALL)
    public Species species;
    public String career = "CAREER";
    @JsonProperty(value = "specializationTrees")
    public String specialization = "SPECIALIZATION";
    public String avatar = "http://url.avatar.com.bitches";
    public int currentXP = 0;
    public int totalXP = 0;
    public int soak = 0;
    public int currentWounds = 0;
    public int totalWounds = 0;
    public int currentStrain = 0;
    public int totalStrain = 0;
    public int defense = 0;
    public int brawn = 3;
    public int agility = 3;
    public int intellect = 3;
    public int cunning = 3;
    public int willpower = 3;
    public int presence = 3;
    public int gender = 0;
    public int age = 18;
    public String height = "";
    public String eyes = "";
    public String hair = "";
    public String other = "";
    public int credits = 0;
    public String equipments = "";
    @OneToMany(cascade = CascadeType.ALL)
    public List<Skill> skills;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Weapon> weapons;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Talent> talents;
    public int encumbrance = 0;
    @Column(name = "FORCE_POWERS")
    public int force = 0;
    public String hashKey = "006";
    public String background = "BACKGROUND";
    public String obligations = "OBLIGATIONS";
    public String motivations = "MOTIVATIONS";
    @Transient
    public String achievements;
    @Transient
    public int selectedAchievement;
    @Transient
    public String world;
    @Transient
    public String webhash;

    public Player(Player them) {
        this.name = them.name;
        this.species = them.species;
        this.career = them.career;
        this.specialization = them.specialization;
        this.avatar = them.avatar;
        this.currentXP = them.currentXP;
        this.totalXP = them.totalXP;
        this.soak = them.soak;
        this.currentWounds = them.currentWounds;
        this.totalWounds = them.totalWounds;
        this.currentStrain = them.currentStrain;
        this.totalStrain = them.totalStrain;
        this.defense = them.defense;
        this.brawn = them.brawn;
        this.agility = them.agility;
        this.intellect = them.intellect;
        this.cunning = them.cunning;
        this.willpower = them.willpower;
        this.presence = them.presence;
        this.gender = them.gender;
        this.age = them.age;
        this.height = them.height;
        this.eyes = them.eyes;
        this.hair = them.hair;
        this.other = them.other;
        this.credits = them.credits;
        this.equipments = them.equipments;
        this.skills = them.skills;
        this.weapons = them.weapons;
        this.talents = them.talents;
        this.encumbrance = them.encumbrance;
        this.force = them.force;
        this.hashKey = them.hashKey;
        this.background = them.background;
        this.obligations = them.obligations;
        this.motivations = them.motivations;
    }

    public Player(String name, String userName, Species species, String career, String specialization, String avatar, int currentXP, int totalXP, int soak, int currentWounds, int totalWounds, int currentStrain, int totalStrain, int defense, int brawn, int agility, int intellect, int cunning, int willpower, int presence, int gender, int age, String height, String eyes, String hair, String other, int credits, String equipments, List<Skill> skills, List<Weapon> weapons, List<Talent> talents, int encumbrance, int force, String hashKey, String background, String obligations, String motivations, String achievements, int selectedAchievement, String world, String webhash) {
        this.name = name;
        this.userName = userName;
        this.species = species;
        this.career = career;
        this.specialization = specialization;
        this.avatar = avatar;
        this.currentXP = currentXP;
        this.totalXP = totalXP;
        this.soak = soak;
        this.currentWounds = currentWounds;
        this.totalWounds = totalWounds;
        this.currentStrain = currentStrain;
        this.totalStrain = totalStrain;
        this.defense = defense;
        this.brawn = brawn;
        this.agility = agility;
        this.intellect = intellect;
        this.cunning = cunning;
        this.willpower = willpower;
        this.presence = presence;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.eyes = eyes;
        this.hair = hair;
        this.other = other;
        this.credits = credits;
        this.equipments = equipments;
        this.skills = skills;
        this.weapons = weapons;
        this.talents = talents;
        this.encumbrance = encumbrance;
        this.force = force;
        this.hashKey = hashKey;
        this.background = background;
        this.obligations = obligations;
        this.motivations = motivations;
        this.achievements = achievements;
        this.selectedAchievement = selectedAchievement;
        this.world = world;
        this.webhash = webhash;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public void setCurrentXP(int currentXP) {
        this.currentXP = currentXP;
    }

    public int getTotalXP() {
        return totalXP;
    }

    public void setTotalXP(int totalXP) {
        this.totalXP = totalXP;
    }

    public int getSoak() {
        return soak;
    }

    public void setSoak(int soak) {
        this.soak = soak;
    }

    public int getCurrentWounds() {
        return currentWounds;
    }

    public void setCurrentWounds(int currentWounds) {
        this.currentWounds = currentWounds;
    }

    public int getTotalWounds() {
        return totalWounds;
    }

    public void setTotalWounds(int totalWounds) {
        this.totalWounds = totalWounds;
    }

    public int getCurrentStrain() {
        return currentStrain;
    }

    public void setCurrentStrain(int currentStrain) {
        this.currentStrain = currentStrain;
    }

    public int getTotalStrain() {
        return totalStrain;
    }

    public void setTotalStrain(int totalStrain) {
        this.totalStrain = totalStrain;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getBrawn() {
        return brawn;
    }

    public void setBrawn(int brawn) {
        this.brawn = brawn;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getCunning() {
        return cunning;
    }

    public void setCunning(int cunning) {
        this.cunning = cunning;
    }

    public int getWillpower() {
        return willpower;
    }

    public void setWillpower(int willpower) {
        this.willpower = willpower;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getEquipments() {
        return equipments;
    }

    public void setEquipments(String equipments) {
        this.equipments = equipments;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Talent> getTalents() {
        return talents;
    }

    public void setTalents(ArrayList<Talent> talents) {
        this.talents = talents;
    }

    public int getEncumbrance() {
        return encumbrance;
    }

    public void setEncumbrance(int encumbrance) {
        this.encumbrance = encumbrance;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getObligations() {
        return obligations;
    }

    public void setObligations(String obligations) {
        this.obligations = obligations;
    }

    public String getMotivations() {
        return motivations;
    }

    public void setMotivations(String motivations) {
        this.motivations = motivations;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public int getSelectedAchievement() {
        return selectedAchievement;
    }

    public void setSelectedAchievement(int selectedAchievement) {
        this.selectedAchievement = selectedAchievement;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", species=" + species +
                ", career='" + career + '\'' +
                ", specialization='" + specialization + '\'' +
                ", avatar='" + avatar + '\'' +
                ", currentXP=" + currentXP +
                ", totalXP=" + totalXP +
                ", soak=" + soak +
                ", currentWounds=" + currentWounds +
                ", totalWounds=" + totalWounds +
                ", currentStrain=" + currentStrain +
                ", totalStrain=" + totalStrain +
                ", defense=" + defense +
                ", brawn=" + brawn +
                ", agility=" + agility +
                ", intellect=" + intellect +
                ", cunning=" + cunning +
                ", willpower=" + willpower +
                ", presence=" + presence +
                ", gender=" + gender +
                ", age=" + age +
                ", height='" + height + '\'' +
                ", eyes='" + eyes + '\'' +
                ", hair='" + hair + '\'' +
                ", other='" + other + '\'' +
                ", credits=" + credits +
                ", equipments='" + equipments + '\'' +
                //", skills=" + skills +
                //", weapons=" + weapons +
                //", talents=" + talents +
                ", encumbrance=" + encumbrance +
                ", force=" + force +
                ", hashKey='" + hashKey + '\'' +
                ", background='" + background + '\'' +
                ", obligations='" + obligations + '\'' +
                ", motivations='" + motivations + '\'' +
                '}';
    }
}

