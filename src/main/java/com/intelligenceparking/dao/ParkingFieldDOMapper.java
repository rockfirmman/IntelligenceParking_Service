package com.intelligenceparking.dao;

import com.intelligenceparking.bean.ParkingFieldModel;
import com.intelligenceparking.dataobject.ParkingFieldDO;
import com.intelligenceparking.tool.requests.ParkingNearBy;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ParkingFieldDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParkingFieldDO record);

    int insertSelective(ParkingFieldDO record);

    ParkingFieldDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ParkingFieldDO record);

    int updateByPrimaryKey(ParkingFieldDO record);

    /**
     * 返回所有停车场
     */
    List<ParkingFieldDO> findAllFields();

    /**
     * 返回附近停车场
     */
    List<ParkingFieldDO> fieldNearBy(ParkingNearBy parkingNearBy);
}