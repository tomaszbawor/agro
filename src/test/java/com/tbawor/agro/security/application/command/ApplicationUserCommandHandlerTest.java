package com.tbawor.agro.security.application.command;

import com.tbawor.agro.security.domain.ApplicationUser;
import com.tbawor.agro.security.domain.ApplicationUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationUserCommandHandlerTest {

    @InjectMocks
    private ApplicationUserCommandHandler commandHandler;

    @Mock
    private ApplicationUserRepository repository;

    @Test
    public void shouldSaveUserInRepositoryWithProperParameters() {
        // given
        final String userLogin = "SomeLogin";
        final String userPassword = "SomePassword";

        final ArgumentCaptor<ApplicationUser> userCaptor = ArgumentCaptor.forClass(ApplicationUser.class);

        // when
        commandHandler.createUser(new CreateApplicationUserCommand() {
            @Override
            public String getLogin() {
                return userLogin;
            }

            @Override
            public String getPassword() {
                return userPassword;
            }
        });

        // then
        verify(repository).save(userCaptor.capture());

        final ApplicationUser savedUser = userCaptor.getValue();
        assertThat(savedUser.getLogin()).isEqualTo(userLogin);
        assertThat(savedUser.getPassword()).isEqualTo(userPassword);
    }

}