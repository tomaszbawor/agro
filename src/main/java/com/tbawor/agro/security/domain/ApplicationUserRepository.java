package com.tbawor.agro.security.domain;

import io.vavr.collection.Seq;
import io.vavr.control.Option;
import org.springframework.data.repository.Repository;

public interface ApplicationUserRepository extends Repository<ApplicationUser, Long> {
    Option<ApplicationUser> findByLogin(String login);

    ApplicationUser save(ApplicationUser user);

    Seq<ApplicationUser> findAll();
}
