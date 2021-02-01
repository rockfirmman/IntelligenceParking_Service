package com.intelligenceparking.bean;

public class UserModel {
    private int id;
    private String username;
    private boolean isFrozen;
    private String password;
    private boolean isLogin;
    private String phone;
    private String email;
    private boolean isAdministrator;
    private String avatar;
    private String account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", isFrozen=" + isFrozen +
                ", password='" + password + '\'' +
                ", isLogin=" + isLogin +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", isAdministrator=" + isAdministrator +
                ", avatar='" + avatar + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
