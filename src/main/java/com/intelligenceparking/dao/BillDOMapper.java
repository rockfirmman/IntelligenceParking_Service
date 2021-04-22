package com.intelligenceparking.dao;

import com.intelligenceparking.bean.BillModel;
import com.intelligenceparking.dataobject.BillDO;
import com.intelligenceparking.response.CommonReturnType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BillDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillDO record);

    int insertSelective(BillDO record);

    BillDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BillDO record);

    int updateByPrimaryKey(BillDO record);

    /**
     * 通过车主id查询账单
     */
    List<BillDO> selectBillByPayerId(@Param("payerId") int payerId);

    /**
     * 通过停车场id查询账单
     */
    BillDO selectBillByFieldId(@Param("fieldId") int fieldId);
    /**
     * 通过停车位id查询账单
     */
    BillDO selectBillBySlotId(@Param("slotId") int slotId);

    /**
     * 通过停车位拥有者id查询账单
     */
    BillDO selectBillByOwnerId(@Param("ownerId") int ownerId);

    /**
     * 通过车辆id查询账单
     */
    BillDO selectBillByCarId(@Param("carId") int carId);
}