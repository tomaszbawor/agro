package com.tbawor.agro.hero.domain;

import io.vavr.collection.Seq;
import io.vavr.control.Option;
import org.springframework.data.repository.Repository;

public interface HeroRepository extends Repository<Hero, Integer> {
    Hero save(Hero hero);
    Seq<Hero> findAll();
    Option<Hero> findByOwnerLogin(String ownerName);
}
