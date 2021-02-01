package com.intelligenceparking.tool.requests;

public class UserModifyAccountMsg {
    private String username;
    private String password;
    private String phone;
    private String email;
    private String avatar;
    private String account;

    public UserModifyAccountMsg(String username, String password, String phone, String email, String avatar, String account) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.avatar = avatar;
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "UserModifyAccountMsg{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
