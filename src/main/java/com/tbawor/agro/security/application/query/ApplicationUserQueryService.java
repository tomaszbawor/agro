package com.tbawor.agro.security.application.query;

import com.tbawor.agro.security.domain.ApplicationUserRepository;
import io.vavr.collection.Seq;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserQueryService {

    private final ApplicationUserRepository repository;

    public ApplicationUserQueryService(ApplicationUserRepository repository) {
        this.repository = repository;
    }

    public ApplicationUserInfo findByLogin(String login) {
        return repository.findByLogin(login)
                .map(user ->
                        new ApplicationUserInfo(user.getId(), user.getLogin())
                ).getOrElse(
                        new ApplicationUserInfo.NullApplicationUserInfo()
                );
    }

    public Seq<ApplicationUserInfo> getAllApplicationUsers() {
        return repository
                .findAll()
                .map(
                        user -> new ApplicationUserInfo(user.getId(), user.getLogin())
                );
    }
}
