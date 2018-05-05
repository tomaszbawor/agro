package com.tbawor.agro.security.application.command;

import com.tbawor.agro.security.domain.ApplicationUser;
import com.tbawor.agro.security.domain.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserCommandHandler {

    private final ApplicationUserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationUserCommandHandler(
            ApplicationUserRepository repository,
            BCryptPasswordEncoder passwordEncoder
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Integer createUser(CreateApplicationUserCommand command) {
        final ApplicationUser user = new ApplicationUser();
        user.setLogin(command.getLogin());
        user.setPassword(passwordEncoder.encode(command.getPassword()));
        repository.save(user);
        return user.getId();
    }

}
