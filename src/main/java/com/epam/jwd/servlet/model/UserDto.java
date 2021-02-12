package com.epam.jwd.servlet.model;

public class UserDto {

    private final String login;
    private final String password;

    public UserDto(String login) {
        this.login = login;
        this.password = null;
    }

    public UserDto(String login, String password) {
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
