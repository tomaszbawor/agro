package com.tbawor.agro.security.domain;

import org.springframework.data.repository.Repository;

public interface ApplicationUserRepository extends Repository<ApplicationUser, Long> {
    ApplicationUser findByLogin(String login);
}
