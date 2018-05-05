package com.tbawor.agro.hero.ui;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tbawor.agro.hero.application.command.CreateHeroCommand;

public class CreateHeroDto {

    private final String name;
    private final Integer strength;
    private final Integer endurance;
    private final Integer defense;
    private final Integer agility;
    private final Integer dexterity;
    private final Integer intelligence;
    private final Integer charisma;
    private final Integer wisdom;
    private final Integer willpower;
    private final Integer perception;
    private final Integer luck;

    @JsonCreator
    public CreateHeroDto(
            @JsonProperty("name") String name,
            @JsonProperty("strength") Integer strength,
            @JsonProperty("endurance") Integer endurance,
            @JsonProperty("defense") Integer defense,
            @JsonProperty("agility") Integer agility,
            @JsonProperty("dexterity") Integer dexterity,
            @JsonProperty("intelligence") Integer intelligence,
            @JsonProperty("charisma") Integer charisma,
            @JsonProperty("wisdom") Integer wisdom,
            @JsonProperty("willpower") Integer willpower,
            @JsonProperty("perception") Integer perception,
            @JsonProperty("luck") Integer luck
    ) {
        this.name = name;
        this.strength = strength;
        this.endurance = endurance;
        this.defense = defense;
        this.agility = agility;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.wisdom = wisdom;
        this.willpower = willpower;
        this.perception = perception;
        this.luck = luck;
    }

    public String getName() {
        return name;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getEndurance() {
        return endurance;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getAgility() {
        return agility;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public Integer getWillpower() {
        return willpower;
    }

    public Integer getPerception() {
        return perception;
    }

    public Integer getLuck() {
        return luck;
    }
}
