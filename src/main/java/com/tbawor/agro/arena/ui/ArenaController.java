package com.tbawor.agro.arena.ui;

import com.tbawor.agro.arena.application.command.ArenaCommandHandler;
import com.tbawor.agro.arena.application.query.ArenaMonsterDto;
import com.tbawor.agro.arena.application.query.ArenaQueryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/arena")
public class ArenaController {

    private final ArenaQueryService queryService;
    private final ArenaCommandHandler commandHandler;

    @Autowired
    public ArenaController(
            ArenaQueryService queryService,
            ArenaCommandHandler commandHandler
    ) {
        this.queryService = queryService;
        this.commandHandler = commandHandler;
    }

    @GetMapping
    public List<ArenaMonsterDto> findAll() {
        return queryService.findAll().toJavaList();
    }

}
