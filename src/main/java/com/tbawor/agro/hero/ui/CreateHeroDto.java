package com.tbawor.agro.hero.ui;

import lombok.Value;

@Value
class CreateHeroDto {

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

}
