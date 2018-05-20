package com.tbawor.agro.arena.domain;

import io.vavr.collection.Seq;
import io.vavr.control.Option;
import org.springframework.data.repository.Repository;

public interface ArenaMonsterRepository extends Repository<ArenaMonster, Integer> {
    Seq<ArenaMonster> findAll();

    Option<ArenaMonster> findById(Integer monsterId);
}
