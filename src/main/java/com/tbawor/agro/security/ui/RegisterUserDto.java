package com.tbawor.agro.security.ui;

import com.tbawor.agro.security.application.command.CreateApplicationUserCommand;
import lombok.Value;

@Value
class RegisterUserDto implements CreateApplicationUserCommand {

    private final String login;
    private final String password;

}
