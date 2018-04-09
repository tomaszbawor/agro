package com.tbawor.agro.hero.application;

import com.tbawor.agro.hero.domain.Hero;
import com.tbawor.agro.hero.domain.HeroFactory;
import com.tbawor.agro.hero.domain.HeroRepository;
import com.tbawor.agro.hero.domain.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroApplicationService {

    private final HeroRepository repository;

    @Autowired
    public HeroApplicationService(HeroRepository repository) {
        this.repository = repository;
    }

    public Hero createHero(CreateHeroCommand command) {
        // TODO: Refactor
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

        final HeroFactory heroFactory = new HeroFactory();
        final Hero hero = heroFactory.createNewHero(command.getName(), statistics);
        return repository.save(hero);
    }

}
