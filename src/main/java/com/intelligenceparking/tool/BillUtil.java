package com.intelligenceparking.tool;

import com.intelligenceparking.bean.BillModel;
import com.intelligenceparking.bean.CarModel;
import com.intelligenceparking.bean.ParkingSlotModel;
import com.intelligenceparking.bean.UserModel;
import com.intelligenceparking.service.BillService;
import com.intelligenceparking.service.CarService;
import com.intelligenceparking.service.ParkingSlotService;
import com.intelligenceparking.service.UserService;
import com.intelligenceparking.service.serviceImpl.BillServiceImpl;
import com.intelligenceparking.service.serviceImpl.CarServiceImpl;
import com.intelligenceparking.service.serviceImpl.ParkingSlotServiceImpl;
import com.intelligenceparking.service.serviceImpl.UserServiceImpl;
import com.intelligenceparking.tool.dynamicTable.DynamicBillTable;
import com.intelligenceparking.tool.pythonRecognize.recognize;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BillUtil {
    private final static String filePath = "/root/";
    public static void recognize(String fileName){
        //获取车牌号
        String commandPath = filePath + "recognize.py";
        String picPath = filePath + "License/" + fileName;
        String license = recognize.getLicense(commandPath,picPath);
//        license = "粤B26VE9";
        System.out.println(8 + ": " + license);
        createBillByHardwareId(8,license);
    }
    public static void createBillByHardwareId(int hardwareId,String license){
        BillService billService = SpringUtil.getBean(BillServiceImpl.class);
        ParkingSlotService parkingSlotService = SpringUtil.getBean(ParkingSlotServiceImpl.class);
        CarService carService = SpringUtil.getBean(CarServiceImpl.class);
        UserService userService = SpringUtil.getBean(UserServiceImpl.class);
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
        DynamicBillTable.insert(billModel.getPayerId(),billModel);
        billService.createBill(billModel);
    }
}
