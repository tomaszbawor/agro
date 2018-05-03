package com.tbawor.agro.security.ui;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginUserDto {
    private final String login;
    private final String password;

    @JsonCreator
    public LoginUserDto(
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
