package com.tbawor.agro.arena.application.query;

import com.tbawor.agro.arena.domain.ArenaMonsterRepository;
import io.vavr.collection.Seq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArenaQueryService {

    private final ArenaMonsterRepository repository;

    @Autowired
    public ArenaQueryService(ArenaMonsterRepository repository) {
        this.repository = repository;
    }

    public Seq<ArenaMonsterDto> findAll() {
        return repository
                .findAll()
                .map(ArenaMonsterDto::new);
    }
}
