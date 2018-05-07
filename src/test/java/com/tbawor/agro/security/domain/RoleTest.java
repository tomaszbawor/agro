package com.tbawor.agro.security.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleTest {

    @Test
    public void shouldBeEqualWhenIdAndNameAreTheSame() {
        // given
        final Integer roleId = 12;
        final String roleName = "ROLE_NAME";

        // when
        final Role role1 = new Role();
        final Role role2 = new Role();
        role1.setId(roleId);
        role2.setId(roleId);
        role1.setRoleName(roleName);
        role2.setRoleName(roleName);

        // then
        assertThat(role1).isEqualTo(role2);
    }

}