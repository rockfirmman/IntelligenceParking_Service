package com.intelligenceparking.service;

import com.intelligenceparking.bean.BillModel;
import com.intelligenceparking.dataobject.BillDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillService {
    /**
     * 通过id查询账单
     */
    BillModel selectBillById(int id);

    /**
     * 生成账单
     */
    void createBill(BillModel billModel);

    /**
     * 修改账单状态
     */
    void updateBillState(BillModel billModel);

    /**
     * 通过车主id查询账单
     */
    List<BillModel> selectBillByPayerId(@Param("payerId") int payerId);

    /**
     * 通过停车场id查询账单
     */
    List<BillModel> selectBillByFieldId(@Param("fieldId") int fieldId);
    /**
     * 通过停车位id查询账单
     */
    List<BillModel> selectBillBySlotId(@Param("slotId") int slotId);

    /**
     * 通过停车位拥有者id查询账单
     */
    List<BillModel> selectBillByOwnerId(@Param("ownerId") int ownerId);

    /**
     * 通过车辆id查询账单
     */
    List<BillModel> selectBillByCarId(@Param("carId") int carId);
}
