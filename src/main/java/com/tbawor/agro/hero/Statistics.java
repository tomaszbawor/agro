package com.tbawor.agro.hero;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer strength;

    @Column(nullable = false)
    private Integer endurance;

    @Column(nullable = false)
    private Integer defense;

    @Column(nullable = false)
    private Integer agility;

    @Column(nullable = false)
    private Integer dexterity;

    @Column(nullable = false)
    private Integer intelligence;

    @Column(nullable = false)
    private Integer charisma;

    @Column(nullable = false)
    private Integer wisdom;

    @Column(nullable = false)
    private Integer willpower;

    @Column(nullable = false)
    private Integer perception;

    @Column(nullable = false)
    private Integer luck;

    public Statistics() {
        // Default constructor for hibernate
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getEndurance() {
        return endurance;
    }

    public void setEndurance(Integer endurance) {
        this.endurance = endurance;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getWillpower() {
        return willpower;
    }

    public void setWillpower(Integer willpower) {
        this.willpower = willpower;
    }

    public Integer getPerception() {
        return perception;
    }

    public void setPerception(Integer perception) {
        this.perception = perception;
    }

    public Integer getLuck() {
        return luck;
    }

    public void setLuck(Integer luck) {
        this.luck = luck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Statistics that = (Statistics) o;
        return Objects.equals(id, that.id)
                && Objects.equals(strength, that.strength)
                && Objects.equals(endurance, that.endurance)
                && Objects.equals(defense, that.defense)
                && Objects.equals(agility, that.agility)
                && Objects.equals(dexterity, that.dexterity)
                && Objects.equals(intelligence, that.intelligence)
                && Objects.equals(charisma, that.charisma)
                && Objects.equals(wisdom, that.wisdom)
                && Objects.equals(willpower, that.willpower)
                && Objects.equals(perception, that.perception)
                && Objects.equals(luck, that.luck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, strength, endurance, defense, agility, dexterity, intelligence, charisma, wisdom, willpower, perception, luck);
    }

    static class Stub extends Statistics {
        Stub() {
            super();
            setStrength(5);
            setEndurance(5);
            setDefense(5);
            setAgility(5);
            setDexterity(5);
            setIntelligence(5);
            setCharisma(4);
            setWisdom(4);
            setWillpower(4);
            setPerception(4);
            setLuck(4);
        }
    }
}
