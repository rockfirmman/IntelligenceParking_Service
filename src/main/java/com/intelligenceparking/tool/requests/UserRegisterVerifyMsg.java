package com.intelligenceparking.tool.requests;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

public class UserRegisterVerifyMsg {
    @Email
    private String email;
    @NotNull(message = "验证码不能为空")
    private String code;

    public UserRegisterVerifyMsg(String email, String code) {
        this.email = email;
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "UserRegisterVerifyMsg{" +
                "email='" + email + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
