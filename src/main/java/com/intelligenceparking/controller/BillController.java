package com.intelligenceparking.controller;



import com.intelligenceparking.bean.BillModel;
import com.intelligenceparking.bean.CarModel;
import com.intelligenceparking.bean.ParkingSlotModel;
import com.intelligenceparking.response.CommonReturnType;
import com.intelligenceparking.service.BillService;
import com.intelligenceparking.service.CarService;
import com.intelligenceparking.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private CarService carService;
    @Autowired
    private ParkingSlotService parkingSlotService;

    @PostMapping(value="/selectBillById")
    public CommonReturnType selectBillById(
            @RequestParam(name = "id") int id){
        BillModel billModel = billService.selectBillById(id);
        return CommonReturnType.create(billModel);
    }

    @PostMapping(value="/createBill")
    public CommonReturnType createBill(
            @RequestParam(name = "carId") int carId,
            @RequestParam(name = "slotId") int slotId,
            @RequestParam(name = "fieldId") int fieldId,
            @RequestParam(name = "payerId") int payerId,
            @RequestParam(name = "ownerId") int ownerId,
            @RequestParam(name = "startTime") Date startTime){
        BillModel billModel = new BillModel();
        billModel.setCarId(carId);
        billModel.setSlotId(slotId);
        billModel.setFieldId(fieldId);
        billModel.setPayerId(payerId);
        billModel.setOwnerId(ownerId);
        billModel.setStartTime(startTime);
        billModel.setCost(0);
        billModel.setScore(0);
        billService.createBill(billModel);
        return CommonReturnType.create(null);
    }

    @PostMapping(value="/startBill")
    public CommonReturnType startBill(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "startTime") Date startTime){
        BillModel billModel = billService.selectBillById(id);
        billModel.setId(id);
        billModel.setState(3);
        billModel.setStartTime(startTime);
        billService.updateBillState(billModel);
        return null;
    }

    @PostMapping(value="/endBill")
    public CommonReturnType endBill(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "endTime") Date endTime){
        BillModel billModel = billService.selectBillById(id);
        billModel.setId(id);
        billModel.setState(4);
        billModel.setEndTime(endTime);
        billService.updateBillState(billModel);
        return null;
    }

    @PostMapping(value="/addComments")
    public CommonReturnType addComments(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "score") int score,
            @RequestParam(name = "comments") String comments){
        BillModel billModel = new BillModel();
        billModel.setId(id);
        billModel.setScore(score);
        billModel.setComments(comments);
        billService.updateBillState(billModel);
        return CommonReturnType.create(null);
    }

    @PostMapping(value="/selectBillByPayerId")
    public CommonReturnType selectBillByPayerId(@RequestParam(name = "payerId") int payerId){
        List<BillModel> billModelList = billService.selectBillByPayerId(payerId);
        return CommonReturnType.create(billModelList);
    }

    @PostMapping(value="/selectBillByFieldId")
    public CommonReturnType selectBillByFieldId(@RequestParam(name = "fieldId") int fieldId){
        List<BillModel> billModelList = billService.selectBillByFieldId(fieldId);
        return CommonReturnType.create(billModelList);
    }

    @PostMapping(value="/selectBillBySlotId")
    public CommonReturnType selectBillBySlotId(@RequestParam(name = "slotId") int slotId){
        List<BillModel> billModelList = billService.selectBillBySlotId(slotId);
        return CommonReturnType.create(billModelList);
    }

    @PostMapping(value="/selectBillByOwnerId")
    public CommonReturnType selectBillByOwnerId(@RequestParam(name = "ownerId") int ownerId){
        List<BillModel> billModelList = billService.selectBillByOwnerId(ownerId);
        return CommonReturnType.create(billModelList);
    }

    @PostMapping(value="/selectBillByCarId")
    public CommonReturnType selectBillByCarId(@RequestParam(name = "carId") int carId){
        List<BillModel> billModelList = billService.selectBillByCarId(carId);
        return CommonReturnType.create(billModelList);
    }

    public void createBillByHardwareId(
            @RequestParam(name = "hardwareId") int hardwareId,
            @RequestParam(name = "license") String license){
        ParkingSlotModel parkingSlotModel = parkingSlotService.selectParkingSlotByHardwareId(hardwareId);
        CarModel carModel = carService.selectCarByLicense(license);
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BillModel billModel = new BillModel();
        billModel.setCarId(carModel.getId());
        billModel.setPayerId(carModel.getUserId());
        billModel.setSlotId(parkingSlotModel.getId());
        billModel.setFieldId(parkingSlotModel.getFieldId());
        billModel.setOwnerId(parkingSlotModel.getOwnerId());
        billModel.setStartTime(day);
        billModel.setState(1);
        billModel.setScore(0);
        billModel.setCost(0);
        billService.createBill(billModel);
    }

    public void endBillByHardwareId(@RequestParam(name = "hardwareId") int hardwareId){
        ParkingSlotModel parkingSlotModel = parkingSlotService.selectParkingSlotByHardwareId(hardwareId);
        List<BillModel> billModelList = billService.selectBillBySlotId(parkingSlotModel.getId());
        BillModel billModel = new BillModel();
        for(BillModel bill:billModelList){
            if (bill.getState()==1){
                billModel = bill;
                break;
            }
        }
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        billModel.setState(2);
        billModel.setEndTime(day);
        long stateTimeLong = billModel.getStartTime().getTime();
        long endTimeLong = billModel.getEndTime().getTime();
        float cost = (endTimeLong-stateTimeLong+60*1000*60-1)/(1000*60*60);
        cost *= parkingSlotModel.getPrice();
        billModel.setCost(cost);
        System.out.println(cost);
        billService.updateBillState(billModel);
    }
}
