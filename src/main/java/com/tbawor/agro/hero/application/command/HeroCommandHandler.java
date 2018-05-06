package com.tbawor.agro.hero.application.command;

import com.tbawor.agro.hero.domain.Hero;
import com.tbawor.agro.hero.domain.HeroFactory;
import com.tbawor.agro.hero.domain.HeroRepository;
import com.tbawor.agro.hero.domain.Statistics;
import com.tbawor.agro.security.domain.ApplicationUser;
import com.tbawor.agro.security.domain.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroCommandHandler {

    private final HeroRepository heroRepository;
    private final ApplicationUserRepository userRepository;

    @Autowired
    public HeroCommandHandler(
            HeroRepository heroRepository,
            ApplicationUserRepository userRepository
    ) {
        this.heroRepository = heroRepository;
        this.userRepository = userRepository;
    }

    public Hero createHero(CreateHeroCommand command) {
        final ApplicationUser owner =
                userRepository.findByLogin(command.getOwnerLogin()).get();
        final StatisticsBuilder statisticsBuilder = new StatisticsBuilder(command);
        final Statistics statistics = statisticsBuilder.build();
        final HeroFactory heroFactory = new HeroFactory();
        final Hero hero = heroFactory.createNewHero(
                command.getName(),
                statistics,
                owner);
        return heroRepository.save(hero);
    }

}
