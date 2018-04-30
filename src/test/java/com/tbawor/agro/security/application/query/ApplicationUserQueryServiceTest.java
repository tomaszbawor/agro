package com.tbawor.agro.security.application.query;

import com.tbawor.agro.security.domain.ApplicationUser;
import com.tbawor.agro.security.domain.ApplicationUserRepository;
import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


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

    @Test
    public void shouldFindAllUsersInRepository() {
        // given
        when(repository.findAll()).thenReturn(List.empty());


        // when
        service.getAllApplicationUsers();

        // then
        verify(repository, times(1)).findAll();
    }

    @Test
    public void shouldReturnCorrectDataFromRepositoryWhenFindingAllUsers() {
        // given
        final Integer userId = 23;
        final String userLogin = "UserLogin";
        final String userPassword = "Password";
        ApplicationUser user = new ApplicationUser();
        user.setId(userId);
        user.setLogin(userLogin);
        user.setPassword(userPassword);

        when(repository.findAll()).thenReturn(List.of(user));

        // when
        final Seq<ApplicationUserInfo> users = service.getAllApplicationUsers();

        // then
        assertThat(users).hasSize(1);
        assertThat(users.get().getId()).isEqualTo(userId);
        assertThat(users.get().getLogin()).isEqualTo(userLogin);
    }

}