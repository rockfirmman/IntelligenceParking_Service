package com.intelligenceparking.dao;

import com.intelligenceparking.bean.CarModel;
import com.intelligenceparking.dataobject.CarDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CarDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarDO record);

    int insertSelective(CarDO record);

    CarDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarDO record);

    int updateByPrimaryKey(CarDO record);

    /**
     * 根据用户id查找车辆
     */
    List<CarDO> selectCarByOwnerId(@Param("userId") int userId);

    /**
     * 通过牌照查询车辆信息
     */
    CarDO selectCarByLicense(@Param("license") String license);
}