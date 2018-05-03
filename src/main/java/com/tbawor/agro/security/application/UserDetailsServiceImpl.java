package com.tbawor.agro.security.application;

import com.tbawor.agro.security.config.ApplicationUserDetails;
import com.tbawor.agro.security.domain.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ApplicationUserRepository repository;

    @Autowired
    public UserDetailsServiceImpl(ApplicationUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository
                .findByLogin(username)
                .map(ApplicationUserDetails::new)
                .getOrElseThrow(() -> new UsernameNotFoundException(
                        String.format("Username: %s not found in database", username)
                ));
    }
}
