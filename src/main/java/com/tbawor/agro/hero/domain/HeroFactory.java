package com.tbawor.agro.hero.domain;

import com.tbawor.agro.security.domain.ApplicationUser;

public class HeroFactory {

    public Hero createNewHero(
            String name,
            Statistics statistics,
            ApplicationUser owner
    ) {
        final Hero hero = new Hero();
        hero.setName(name);
        hero.setStatistics(statistics);
        hero.setOwner(owner);
        return hero;
    }

}
