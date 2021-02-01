package com.intelligenceparking.dao;

import com.intelligenceparking.dataobject.UserDO;
import org.springframework.data.repository.query.Param;

public interface UserDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    void register(UserDO userDO);
    /**
     * 登陆验证
     */
    UserDO login(UserDO userDO);

    /**
     * 根据 id 更新用户信息
     */
    void updateMsg(UserDO userDO);

    /**
     * 成功验证账户后解冻账户
     */
    void registerVerify(@Param("email") String email);

    /**
     * 通过名字查询用户信息
     */
    UserDO findUserByUsername(@Param("username") String username);
}