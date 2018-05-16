package com.tbawor.agro.security.application.query;

import lombok.Getter;

@Getter
public class ApplicationUserInfo {

    private final Integer id;
    private final String login;

    public ApplicationUserInfo(Integer id, String login) {
        this.id = id;
        this.login = login;
    }

    static class NullApplicationUserInfo extends ApplicationUserInfo {
        NullApplicationUserInfo() {
            super(null, null);
        }
    }
}
