package com.intelligenceparking.service;

import com.intelligenceparking.bean.UserModel;
import com.intelligenceparking.tool.requests.UserRegisterVerifyMsg;

public interface UserService {
    /**
     * Register.
     *
     * @param userModel the user model
     *
     */
    void register(UserModel userModel);

    UserModel login(UserModel userModel);

    void registerVerify(UserRegisterVerifyMsg userRegisterVerifyMsg);

    void updateMsg(UserModel userModel);
}
