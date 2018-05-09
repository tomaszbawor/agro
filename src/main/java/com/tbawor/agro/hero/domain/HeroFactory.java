package com.tbawor.agro.hero.domain;

import com.tbawor.agro.security.domain.ApplicationUser;

public class HeroFactory {

    public Hero createNewHero(
            String name,
            Statistics statistics,
            ApplicationUser owner
    ) {
        final HealthFactory healthFactory = new HealthFactory();
        final Health heroHealth = healthFactory.createHealthFromStatistics(statistics);
        final Hero hero = new Hero();
        hero.setName(name);
        hero.setStatistics(statistics);
        hero.setOwner(owner);
        hero.setHealth(heroHealth);
        return hero;
    }

}
