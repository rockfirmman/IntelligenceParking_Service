package com.intelligenceparking.controller;


import com.intelligenceparking.bean.BillModel;
import com.intelligenceparking.controller.viewobject.BillVO;
import com.intelligenceparking.dataobject.BillDO;
import com.intelligenceparking.response.CommonReturnType;
import com.intelligenceparking.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping(value="/selectBillById")
    public CommonReturnType selectBillById(
            @RequestParam(name = "id") int id){
        BillDO billDO = billService.selectBillById(id);
        return CommonReturnType.create(billDO);
    }

    @PostMapping(value="/createBill")
    public CommonReturnType createBill(
            @RequestParam(name = "carId") int carId,
            @RequestParam(name = "slotId") int slotId,
            @RequestParam(name = "fieldId") int fieldId,
            @RequestParam(name = "payerId") int payerId,
            @RequestParam(name = "ownerId") int ownerId,
            @RequestParam(name = "startTime") Date startTime){
        BillDO billDO = new BillDO();
        billDO.setCarId(carId);
        billDO.setSlotId(slotId);
        billDO.setFieldId(fieldId);
        billDO.setPayerId(payerId);
        billDO.setOwnerId(ownerId);
        billDO.setStartTime(startTime);
        billService.createBill(billDO);
        return CommonReturnType.create(null);
    }

    @PostMapping(value="/startBill")
    public CommonReturnType startBill(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "startTime") Date startTime){
        BillDO billDO = new BillDO();
        billDO.setId(id);
        billDO.setState(3);
        billDO.setStartTime(startTime);
        billService.updateBillState(billDO);
        return null;
    }

    @PostMapping(value="/endBill")
    public CommonReturnType endBill(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "endTime") Date endTime){
        BillDO billDO = new BillDO();
        billDO.setId(id);
        billDO.setState(4);
        billDO.setEndTime(endTime);
        billService.updateBillState(billDO);
        return null;
    }

    @PostMapping(value="/updateBillState")
    public CommonReturnType updateBillState(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "state") int state,
            @RequestParam(name = "cost") float cost,
            @RequestParam(name = "startTime") Date startTime,
            @RequestParam(name = "endTime") Date endTime){
        //TODO, count cost
        BillDO billDO = new BillDO();
        billDO.setId(id);
        billDO.setState(state);
        billDO.setCost(cost);
        billDO.setStartTime(startTime);
        billDO.setEndTime(endTime);
        billService.updateBillState(billDO);
        return CommonReturnType.create(null);
    }

    @PostMapping(value="/addComments")
    public CommonReturnType addComments(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "score") int score,
            @RequestParam(name = "comments") String comments){
        BillDO billDO = new BillDO();
        billDO.setId(id);
        billDO.setScore(score);
        billDO.setComments(comments);
        billService.addComments(billDO);
        return CommonReturnType.create(null);
    }

    @PostMapping(value="/selectBillByPayerId")
    public CommonReturnType selectBillByPayerId(@RequestParam(name = "payerId") int payerId){
        List<BillDO> billDOList = billService.selectBillByPayerId(payerId);
        return CommonReturnType.create(billDOList);
    }

    @PostMapping(value="/selectBillByFieldId")
    public CommonReturnType selectBillByFieldId(@RequestParam(name = "fieldId") int fieldId){
        List<BillDO> billDOList = billService.selectBillByFieldId(fieldId);
        return CommonReturnType.create(billDOList);
    }

    @PostMapping(value="/selectBillBySlotId")
    public CommonReturnType selectBillBySlotId(@RequestParam(name = "slotId") int slotId){
        List<BillDO> billDOList = billService.selectBillBySlotId(slotId);
        return CommonReturnType.create(billDOList);
    }

    @PostMapping(value="/selectBillByOwnerId")
    public CommonReturnType selectBillByOwnerId(@RequestParam(name = "ownerId") int ownerId){
        List<BillDO> billDOList = billService.selectBillByOwnerId(ownerId);
        return CommonReturnType.create(billDOList);
    }

    @PostMapping(value="/selectBillByCarId")
    public CommonReturnType selectBillByCarId(@RequestParam(name = "carId") int carId){
        List<BillDO> billDOList = billService.selectBillByCarId(carId);
        return CommonReturnType.create(billDOList);
    }
}
