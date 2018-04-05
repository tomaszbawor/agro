package com.tbawor.agro.hero;

public class HeroFactory {

    public Hero createNewHero(String name, Statistics statistics) {
        final Hero hero = new Hero();
        hero.setName(name);
        hero.setStatistics(statistics);
        return hero;
    }

}
