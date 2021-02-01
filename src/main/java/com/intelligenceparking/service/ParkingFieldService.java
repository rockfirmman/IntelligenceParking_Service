package com.intelligenceparking.service;

import com.intelligenceparking.bean.ParkingFieldModel;
import com.intelligenceparking.tool.requests.ParkingNearBy;

import java.util.List;

public interface ParkingFieldService {
    /**
     * 根据id查找停车场
     */
    public ParkingFieldModel selectFieldById(int id);

    /**
     * 注册
     */
    public void registerParkingField(ParkingFieldModel parkingFieldModel);

    /**
     * 更新车辆信息
     */
    public void updateParkingField(ParkingFieldModel parkingFieldModel);

    /**
     * 根据id 删除车辆
     */
    public void deleteParkingField(int id);

    /**
     * 返回所有停车场
     */
    public List<ParkingFieldModel> findAllFields();

    /**
     * 返回附近停车场
     */
    public List<ParkingFieldModel> fieldNearBy(ParkingNearBy parkingNearBy);
}
