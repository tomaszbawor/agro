package com.tbawor.agro.security.ui;

import com.tbawor.agro.security.application.command.ApplicationUserCommandHandler;
import com.tbawor.agro.security.application.query.ApplicationUserInfo;
import com.tbawor.agro.security.application.query.ApplicationUserQueryService;
import io.vavr.collection.Seq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final ApplicationUserCommandHandler commandHandler;
    private final ApplicationUserQueryService queryService;

    @Autowired
    public UserRestController(
            ApplicationUserCommandHandler commandHandler,
            ApplicationUserQueryService queryService
    ) {
        this.commandHandler = commandHandler;
        this.queryService = queryService;
    }

    @PostMapping
    public ApplicationUserInfo register(@RequestBody RegisterUserDto registerForm) {
        commandHandler.createUser(registerForm);
        return queryService.findByLogin(registerForm.getLogin());
    }

    @GetMapping
    public Seq<ApplicationUserInfo> findAll() {
        return queryService.getAllApplicationUsers();
    }
}
