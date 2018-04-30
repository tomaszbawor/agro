package com.tbawor.agro.security.ui;

import com.tbawor.agro.security.application.command.ApplicationUserCommandHandler;
import com.tbawor.agro.security.application.query.ApplicationUserInfo;
import com.tbawor.agro.security.application.query.ApplicationUserQueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserRestControllerTest {

    @Mock
    private ApplicationUserQueryService queryService;

    @Mock
    private ApplicationUserCommandHandler commandHandler;

    @InjectMocks
    private UserRestController controller;
    
    @Test
    public void shouldSaveUserThroughCommandHandler() {
        // given
        final String userLogin = "login";
        final String userPassword = "examplePass";
        final RegisterUserDto registrationForm = new RegisterUserDto(
                userLogin,
                userPassword
        );

        // when
        controller.register(registrationForm);

        // then
        verify(commandHandler, times(1)).createUser(any());
    }
    
    @Test
    public void shouldReturnDetailsFromQueryService() {
        // when
        controller.findAll();
        
        // then
        verify(queryService).getAllApplicationUsers();
    }

}