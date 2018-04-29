package com.tbawor.agro.security.ui;

import com.tbawor.agro.security.domain.ApplicationUserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final ApplicationUserRepository repository;

    public UserRestController(ApplicationUserRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public RegisterUserDto register(@RequestBody RegisterUserDto registerForm) {
        //TODO: implement
        return null;
    }
}
