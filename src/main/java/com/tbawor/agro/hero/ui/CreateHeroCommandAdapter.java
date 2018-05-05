package com.tbawor.agro.hero.ui;

import com.tbawor.agro.hero.application.command.CreateHeroCommand;

import java.security.Principal;

public class CreateHeroCommandAdapter implements CreateHeroCommand {

    private final CreateHeroDto createHeroDto;
    private final Principal principal;

    public CreateHeroCommandAdapter(CreateHeroDto createHeroDto, Principal principal) {
        this.createHeroDto = createHeroDto;
        this.principal = principal;
    }

    @Override
    public String getName() {
        return createHeroDto.getName();
    }

    @Override
    public Integer getStrength() {
        return createHeroDto.getStrength();
    }

    @Override
    public Integer getEndurance() {
        return createHeroDto.getEndurance();
    }

    @Override
    public Integer getDefense() {
        return createHeroDto.getDefense();
    }

    @Override
    public Integer getAgility() {
        return createHeroDto.getAgility();
    }

    @Override
    public Integer getDexterity() {
        return createHeroDto.getDexterity();
    }

    @Override
    public Integer getIntelligence() {
        return createHeroDto.getIntelligence();
    }

    @Override
    public Integer getCharisma() {
        return createHeroDto.getCharisma();
    }

    @Override
    public Integer getWisdom() {
        return createHeroDto.getWisdom();
    }

    @Override
    public Integer getWillpower() {
        return createHeroDto.getWillpower();
    }

    @Override
    public Integer getPerception() {
        return createHeroDto.getPerception();
    }

    @Override
    public Integer getLuck() {
        return createHeroDto.getLuck();
    }

    @Override
    public String getOwnerLogin() {
        return principal.getName();
    }
}
