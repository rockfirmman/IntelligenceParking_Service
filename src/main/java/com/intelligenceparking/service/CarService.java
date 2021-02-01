package com.intelligenceparking.service;

import com.intelligenceparking.bean.CarModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CarService {
    /**
     * 通过id查询车辆信息
     */
    CarModel selectCarById(@Param("id") int id);

    /**
     * 登记车辆
     */
    void registerCar(CarModel carModel);

    /**
     * 删除车辆
     */
    void deleteCar(@Param("id") int id);

    /**
     * 根据 id 更新车辆信息
     */
    void updateCarMsg(CarModel carModel);


    /**
     * 根据用户id查找车辆
     */
    List<CarModel> selectCarByOwnerId(@Param("userId") int userId);
}
