package com.tbawor.agro.arena.application.command;

import com.tbawor.agro.arena.domain.ArenaMonster;
import com.tbawor.agro.arena.domain.ArenaMonsterRepository;
import com.tbawor.agro.hero.domain.Hero;
import com.tbawor.agro.hero.domain.HeroRepository;
import io.vavr.Tuple2;
import io.vavr.control.Option;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ArenaCommandHandler {

    private final ArenaMonsterRepository monsterRepository;
    private final HeroRepository heroRepository;

    @Autowired
    public ArenaCommandHandler(
            ArenaMonsterRepository monsterRepository,
            HeroRepository heroRepository
    ) {
        this.monsterRepository = monsterRepository;
        this.heroRepository = heroRepository;
    }

    void fightMonster(FightMonsterCommand command) {
        log.info("Initializing fight with command: {}", command);
        final Option<Hero> maybeHero = heroRepository.findByOwnerLogin(command.getHeroOwnerLogin());
        final Option<ArenaMonster> maybeMonster = monsterRepository.findById(command.getMonsterId());

        final Hero hero = maybeHero.getOrElseThrow(() -> new RuntimeException("No hero found"));
        final ArenaMonster monster = maybeMonster.getOrElseThrow(() -> new RuntimeException("No monster with current id found"));

        processFight(hero, monster);

    }

    private void processFight(Hero hero, ArenaMonster monster) {
        log.info("Fight between hero: {}, and monster: {}", hero, monster);
        //TODO: Implement fighting mechanics
    }

}
