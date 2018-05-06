package com.tbawor.agro.hero.application.command;

import com.tbawor.agro.hero.domain.Statistics;

class StatisticsBuilder {

    private final CreateHeroCommand command;

    StatisticsBuilder(CreateHeroCommand command) {
        this.command = command;
    }

    Statistics build() {
        final Statistics statistics = new Statistics();
        statistics.setStrength(command.getStrength());
        statistics.setEndurance(command.getEndurance());
        statistics.setDefense(command.getDefense());
        statistics.setAgility(command.getAgility());
        statistics.setDexterity(command.getDexterity());
        statistics.setIntelligence(command.getIntelligence());
        statistics.setCharisma(command.getCharisma());
        statistics.setWisdom(command.getWisdom());
        statistics.setWillpower(command.getWillpower());
        statistics.setPerception(command.getPerception());
        statistics.setLuck(command.getLuck());
        return statistics;
    }


}

