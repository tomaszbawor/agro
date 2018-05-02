package com.tbawor.agro.security.config;

import com.tbawor.agro.security.domain.Role;
import org.springframework.security.core.GrantedAuthority;

public class ApplicationGrantedAuthority implements GrantedAuthority {

    private final Role role;

    public ApplicationGrantedAuthority(Role role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.getRoleName();
    }
}
