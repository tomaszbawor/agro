package com.tbawor.agro.security.application;

import com.tbawor.agro.security.domain.ApplicationUser;
import com.tbawor.agro.security.domain.ApplicationUserRepository;
import io.vavr.control.Option;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

public class UserDetailsServiceImplTest {

    private ApplicationUserRepository repository;
    private UserDetailsServiceImpl userDetailsService;

    @Before
    public void setUp() {
        repository = Mockito.mock(ApplicationUserRepository.class);
        userDetailsService = new UserDetailsServiceImpl(repository);
    }

    @Test
    public void shouldFindUsernameInRepository() {
        // given
        final String username = "LoginOfUser";
        doReturn(Option.of(new ApplicationUser())).when(repository).findByLogin(anyString());

        // when
        userDetailsService.loadUserByUsername(username);

        // then
        Mockito.verify(repository).findByLogin(Mockito.eq(username));
    }

    @Test
    public void shouldThrowUsernameNotFoundExceptionWhenNoUserInRepository() {
        // given
        final String username = "SomeUsername";
        doReturn(Option.none()).when(repository).findByLogin(anyString());

        try {
            // when
            userDetailsService.loadUserByUsername(username);
            fail("Should throw username not found exception");
        } catch (Exception ex) {
            // then
            assertThat(ex).isInstanceOf(UsernameNotFoundException.class);
            assertThat(ex).hasMessage("Username: " + username + " not found in database");
        }
    }
}