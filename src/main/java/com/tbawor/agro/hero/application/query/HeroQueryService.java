package com.tbawor.agro.hero.application.query;

import com.tbawor.agro.hero.domain.Hero;
import com.tbawor.agro.hero.domain.HeroRepository;

import io.vavr.collection.Seq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroQueryService {

    private final HeroRepository repository;

    @Autowired
    public HeroQueryService(HeroRepository repository) {
        this.repository = repository;
    }

    public Seq<Hero> listAllHeroes() {
        return repository.findAll();
    }
}
