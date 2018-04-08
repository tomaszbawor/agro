package com.tbawor.agro.hero.ui;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tbawor.agro.hero.application.CreateHeroCommand;

public class CreateHeroDto implements CreateHeroCommand {

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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getStrength() {
        return strength;
    }

    @Override
    public Integer getEndurance() {
        return endurance;
    }

    @Override
    public Integer getDefense() {
        return defense;
    }

    @Override
    public Integer getAgility() {
        return agility;
    }

    @Override
    public Integer getDexterity() {
        return dexterity;
    }

    @Override
    public Integer getIntelligence() {
        return intelligence;
    }

    @Override
    public Integer getCharisma() {
        return charisma;
    }

    @Override
    public Integer getWisdom() {
        return wisdom;
    }

    @Override
    public Integer getWillpower() {
        return willpower;
    }

    @Override
    public Integer getPerception() {
        return perception;
    }

    @Override
    public Integer getLuck() {
        return luck;
    }
}
