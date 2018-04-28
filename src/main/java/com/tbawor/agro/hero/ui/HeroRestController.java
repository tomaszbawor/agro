package com.tbawor.agro.hero.ui;

import com.tbawor.agro.hero.application.command.HeroCommandHandler;
import com.tbawor.agro.hero.application.query.HeroQueryService;
import com.tbawor.agro.hero.domain.Hero;

import io.vavr.collection.Seq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/hero")
public class HeroRestController {

    private final HeroQueryService queryService;
    private final HeroCommandHandler commandHandler;

    @Autowired
    public HeroRestController(
            HeroQueryService queryService,
            HeroCommandHandler commandHandler
    ) {
        this.queryService = queryService;
        this.commandHandler = commandHandler;
    }

    @PostMapping
    public Integer createHero(@RequestBody CreateHeroDto createHeroDto) {
        return commandHandler.createHero(createHeroDto).getId();
    }

    @GetMapping
    public Seq<Hero> getAllHeroes() {
        return queryService.listAllHeroes();
    }

}
