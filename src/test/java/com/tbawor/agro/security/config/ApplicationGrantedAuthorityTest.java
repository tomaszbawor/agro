package com.tbawor.agro.security.config;

import com.tbawor.agro.security.domain.Role;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationGrantedAuthorityTest {

    @Test
    public void shouldReturnRoleNameAsAuthority() {
        // given
        final String roleName = "ROLE_FAKE";
        Role role = new Role();
        role.setRoleName(roleName);

        // when
        final ApplicationGrantedAuthority authority = new ApplicationGrantedAuthority(role);

        // then
        assertThat(authority.getAuthority()).isEqualTo(roleName);
    }

}