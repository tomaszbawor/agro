package com.tbawor.agro.security.application.command;

import com.tbawor.agro.security.domain.ApplicationUserRepository;

public class ApplicationUserCommandHandler {

    private final ApplicationUserRepository repository;

    public ApplicationUserCommandHandler(ApplicationUserRepository repository) {
        this.repository = repository;
    }



}
