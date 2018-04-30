package com.tbawor.agro.security.application.command;

import com.tbawor.agro.security.domain.ApplicationUser;
import com.tbawor.agro.security.domain.ApplicationUserRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserCommandHandler {

    private final ApplicationUserRepository repository;

    public ApplicationUserCommandHandler(ApplicationUserRepository repository) {
        this.repository = repository;
    }

    public Integer createUser(CreateApplicationUserCommand command) {
        final ApplicationUser user = new ApplicationUser();
        user.setLogin(command.getLogin());
        user.setPassword(command.getPassword());
        repository.save(user);
        return user.getId();
    }

}
