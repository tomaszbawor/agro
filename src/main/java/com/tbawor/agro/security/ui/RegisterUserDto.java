package com.tbawor.agro.security.ui;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tbawor.agro.security.application.command.CreateApplicationUserCommand;

class RegisterUserDto implements CreateApplicationUserCommand {

    private final String login;
    private final String password;

    @JsonCreator
    public RegisterUserDto(
            @JsonProperty("login") String login,
            @JsonProperty("password") String password
    ) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
