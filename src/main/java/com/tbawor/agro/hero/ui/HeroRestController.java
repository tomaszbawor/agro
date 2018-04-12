package com.tbawor.agro.hero.ui;

import com.tbawor.agro.hero.application.command.HeroCommandHandler;
import com.tbawor.agro.hero.domain.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hero")
public class HeroRestController {

    private final HeroCommandHandler commandHandler;

    @Autowired
    public HeroRestController(HeroCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @PostMapping
    public Integer createHero(@RequestBody CreateHeroDto createHeroDto) {
        //TODO: Should not use Hero from domain, only dtos from application layer
        final Hero hero = commandHandler.createHero(createHeroDto);
        return hero.getId();
    }

}
