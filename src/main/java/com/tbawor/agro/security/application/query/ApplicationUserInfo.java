package com.tbawor.agro.security.application.query;

public class ApplicationUserInfo {

    private final Integer id;
    private final String login;

    public ApplicationUserInfo(Integer id, String login) {
        this.id = id;
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    static class NullApplicationUserInfo extends ApplicationUserInfo {
        NullApplicationUserInfo() {
            super(null, null);
        }
    }
}
