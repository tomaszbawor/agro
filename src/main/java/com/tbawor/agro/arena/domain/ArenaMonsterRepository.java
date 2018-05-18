package com.tbawor.agro.arena.domain;

import io.vavr.collection.Seq;
import org.springframework.data.repository.Repository;

public interface ArenaMonsterRepository extends Repository<ArenaMonster, Integer> {
    Seq<ArenaMonster> findAll();
}
