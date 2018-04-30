package com.tbawor.agro.security.application.query;

import com.tbawor.agro.security.domain.ApplicationUser;
import com.tbawor.agro.security.domain.ApplicationUserRepository;
import io.vavr.control.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class ApplicationUserQueryServiceTest {

    @Mock
    private ApplicationUserRepository repository;

    @InjectMocks
    private ApplicationUserQueryService service;

    @Test
    public void shouldSearchForLoginInRepository() {
        // given
        final String userLogin = "Example";
        doReturn(Option.none()).when(repository).findByLogin(any());
        
        // when
        service.findByLogin(userLogin);
        
        // then
        verify(repository).findByLogin(eq(userLogin));
    }

    @Test
    public void shouldReturnProperValuesWhenSearchingByLogin() {
        // given
        final Integer userId = 10;
        final String userLogin = "SomeLogin";
        final String userPassword = "ExamplePassword";

        final ApplicationUser user = new ApplicationUser();
        user.setId(userId);
        user.setLogin(userLogin);
        user.setPassword(userPassword);

        doReturn(Option.of(user)).when(repository).findByLogin(eq(userLogin));

        // when
        final ApplicationUserInfo userDetails = service.findByLogin(userLogin);

        // then
        assertThat(userDetails.getId()).isEqualTo(userId);
        assertThat(userDetails.getLogin()).isEqualTo(userLogin);
    }

    @Test
    public void shouldReturnNullObjectWhenNoUserFound() {
        // given
        final String userLogin = "SomeLoginToCheck";
        doReturn(Option.none()).when(repository).findByLogin(eq(userLogin));

        // when
        final ApplicationUserInfo userDetails = service.findByLogin(userLogin);

        // then
        assertThat(userDetails).isExactlyInstanceOf(ApplicationUserInfo.NullApplicationUserInfo.class);

    }

}