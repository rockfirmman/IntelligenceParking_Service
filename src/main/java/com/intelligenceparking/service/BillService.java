package com.intelligenceparking.service;

import com.intelligenceparking.bean.BillModel;
import com.intelligenceparking.dataobject.BillDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillService {
    /**
     * 通过id查询账单
     */
    BillDO selectBillById(int id);

    /**
     * 生成账单
     */
    void createBill(BillDO billDO);

    /**
     * 修改账单状态
     */
    void updateBillState(BillDO billDO);


    /**
     * 添加打分评论
     */
    void addComments(BillDO billDO);

    /**
     * 通过车主id查询账单
     */
    List<BillDO> selectBillByPayerId(@Param("payerId") int payerId);

    /**
     * 通过停车场id查询账单
     */
    List<BillDO> selectBillByFieldId(@Param("fieldId") int fieldId);
    /**
     * 通过停车位id查询账单
     */
    List<BillDO> selectBillBySlotId(@Param("slotId") int slotId);

    /**
     * 通过停车位拥有者id查询账单
     */
    List<BillDO> selectBillByOwnerId(@Param("ownerId") int ownerId);

    /**
     * 通过车辆id查询账单
     */
    List<BillDO> selectBillByCarId(@Param("carId") int carId);
}
