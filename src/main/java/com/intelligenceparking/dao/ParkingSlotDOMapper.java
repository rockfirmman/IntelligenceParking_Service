package com.intelligenceparking.dao;

import com.intelligenceparking.bean.ParkingSlotModel;
import com.intelligenceparking.dataobject.ParkingSlotDO;
import com.intelligenceparking.tool.requests.ParkingNearBy;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ParkingSlotDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParkingSlotDO record);

    int insertSelective(ParkingSlotDO record);

    ParkingSlotDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ParkingSlotDO record);

    int updateByPrimaryKey(ParkingSlotDO record);

    /**
     * 根据用户id查找停车位
     */
    List<ParkingSlotDO> selectParkingSlotByOwnerId(@Param("ownerId") int ownerId);

    /**
     * 根据停车场id查找停车位
     */
    List<ParkingSlotDO> selectParkingSlotByFieldId(@Param("fieldId") int fieldId);

    /**
     * 返回附近停车位
     */
    List<ParkingSlotDO> slotNearBy(ParkingNearBy parkingNearBy);

    /**
     * 根据硬件id查找停车位
     */
    ParkingSlotDO selectParkingSlotByHardwareId(@Param("hardwareId") int hardwareId);
}