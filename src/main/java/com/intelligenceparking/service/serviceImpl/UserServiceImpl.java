package com.intelligenceparking.service.serviceImpl;


import com.intelligenceparking.bean.UserModel;
import com.intelligenceparking.dao.UserDOMapper;
import com.intelligenceparking.dataobject.UserDO;
import com.intelligenceparking.service.UserService;
import com.intelligenceparking.tool.requests.UserRegisterVerifyMsg;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public void register(UserModel userModel) {
        UserDO userDO = convertFromModel(userModel);
        userDOMapper.register(userDO);
    }

    @Override
    public UserModel login(UserModel userModel) {
        UserDO userDO = convertFromModel(userModel);
        return convertFromDO(userDOMapper.login(userDO));
    }

    @Override
    public void registerVerify(UserRegisterVerifyMsg userRegisterVerifyMsg){
        userDOMapper.registerVerify(userRegisterVerifyMsg.getEmail());
    }

    @Override
    public void updateMsg(UserModel userModel) {
        UserDO userDO = convertFromModel(userModel);
        userDOMapper.updateMsg(userDO);
    }

    @Override
    public UserModel selectUserById(int id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        return convertFromDO(userDO);
    }

    private UserDO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userModel, userDO);
        return userDO;
    }

    private UserModel convertFromDO(UserDO userDO) {
        if (userDO == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);
        return userModel;
    }
}
