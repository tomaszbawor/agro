package com.tbawor.agro.security.ui;

import lombok.Value;

@Value
public class LoginUserDto {
    private final String login;
    private final String password;
}
