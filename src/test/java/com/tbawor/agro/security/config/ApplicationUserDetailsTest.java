package com.tbawor.agro.security.config;

import com.tbawor.agro.security.domain.ApplicationUser;
import com.tbawor.agro.security.domain.Role;
import io.vavr.collection.HashSet;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationUserDetailsTest {

    @Test
    public void shouldReturnLoginAsUsername() {
        // given
        final String userLogin = "UserLogin";
        final ApplicationUser stubUser = new ApplicationUser();
        stubUser.setLogin(userLogin);

        // when
        final ApplicationUserDetails userDetails = new ApplicationUserDetails(stubUser);

        // then
        assertThat(userDetails.getUsername()).isEqualTo(userLogin);
    }

    @Test
    public void shouldReturnUserPassword() {
        // given
        final String userPassword = "Password";
        final ApplicationUser stubUser = new ApplicationUser();
        stubUser.setPassword(userPassword);

        // when
        final ApplicationUserDetails userDetails = new ApplicationUserDetails(stubUser);

        // then
        assertThat(userDetails.getPassword()).isEqualTo(userPassword);
    }

    @Test
    public void shouldBeNotExpiredByDefault() {
        // when
        final ApplicationUserDetails userDetails = new ApplicationUserDetails(new ApplicationUser());

        // then
        assertThat(userDetails.isAccountNonExpired()).isTrue();
    }

    @Test
    public void shouldBeNonLockedByDefault() {
        // when
        final ApplicationUserDetails userDetails = new ApplicationUserDetails(new ApplicationUser());

        // then
        assertThat(userDetails.isAccountNonLocked()).isTrue();
    }

    @Test
    public void shouldHaveNotExpiredCredentialsByDefault() {
        // when
        final ApplicationUserDetails userDetails = new ApplicationUserDetails(new ApplicationUser());

        // then
        assertThat(userDetails.isCredentialsNonExpired()).isTrue();
    }


    @Test
    public void shouldBeEnabledByDefault() {
        // when
        final ApplicationUserDetails userDetails = new ApplicationUserDetails(new ApplicationUser());

        // then
        assertThat(userDetails.isEnabled()).isTrue();
    }

    @Test
    public void shouldReturnUserRoleAsGrantedAuthority() {
        // given
        final String roleName = "ROLE_FAKE";
        final Role role = new Role();
        role.setRoleName(roleName);
        final ApplicationUser user = new ApplicationUser();
        user.setRoles(HashSet.of(role).toJavaSet());

        // when
        final ApplicationUserDetails userDetails = new ApplicationUserDetails(user);

        // then
        assertThat(userDetails.getAuthorities())
                .anyMatch(authority -> authority.getAuthority().equals(roleName));
    }


}