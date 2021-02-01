package com.intelligenceparking.dataobject;

public class UserDO {
    private Integer id;

    private String username;

    private Byte isFrozed;

    private String password;

    private Byte isLogin;

    private String phone;

    private String email;

    private Byte isAdministrator;

    private String avatar;

    private String account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Byte getIsFrozed() {
        return isFrozed;
    }

    public void setIsFrozed(Byte isFrozed) {
        this.isFrozed = isFrozed;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Byte isLogin) {
        this.isLogin = isLogin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Byte getIsAdministrator() {
        return isAdministrator;
    }

    public void setIsAdministrator(Byte isAdministrator) {
        this.isAdministrator = isAdministrator;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }
}