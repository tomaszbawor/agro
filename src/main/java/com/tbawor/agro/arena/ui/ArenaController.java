package com.tbawor.agro.arena.ui;

import com.tbawor.agro.arena.application.query.ArenaMonsterDto;
import com.tbawor.agro.arena.application.query.ArenaQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/arena")
public class ArenaController {

    private final ArenaQueryService queryService;

    @Autowired
    public ArenaController(ArenaQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping
    public List<ArenaMonsterDto> findAll() {
        return queryService.findAll().toJavaList();
    }

}
