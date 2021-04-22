package com.intelligenceparking.service;

import com.intelligenceparking.bean.ParkingSlotModel;
import com.intelligenceparking.tool.requests.ParkingNearBy;

import java.util.List;

public interface ParkingSlotService {
    /**
     * 根据id查找停车位
     */
    ParkingSlotModel selectParkingSlotById(int id);

    /**
     * 登记停车位
     */
    void registerParkingSlot(ParkingSlotModel parkingSlotModel);

    /**
     * 删除停车位
     */
    void deleteParkingSlot(int id);

    /**
     * 根据 id 更新车辆信息
     */
    void updateParkingSlot(ParkingSlotModel parkingSlotModel);

    /**
     * 根据用户id查找停车位
     */
    List<ParkingSlotModel> selectParkingSlotByOwnerId(int ownerId);

    /**
     * 根据停车场id查找停车位
     */
    List<ParkingSlotModel> selectParkingSlotByFieldId(int fieldId);

    /**
     * 返回附近停车位
     */
    List<ParkingSlotModel> slotNearBy(ParkingNearBy parkingNearBy);

    /**
     * 根据硬件id查找停车位
     */
    ParkingSlotModel selectParkingSlotByHardwareId(int hardwareId);
}
