package com.intelligenceparking.tool.requests;

import org.hibernate.validator.constraints.NotBlank;

public class UserLoginMsg {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public UserLoginMsg(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserLoginMsg{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
