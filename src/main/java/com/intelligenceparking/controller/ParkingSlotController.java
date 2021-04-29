package com.intelligenceparking.controller;

import com.intelligenceparking.bean.ParkingSlotModel;
import com.intelligenceparking.response.CommonReturnType;
import com.intelligenceparking.service.ParkingSlotService;
import com.intelligenceparking.tool.requests.ParkingNearBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkingslot")
public class ParkingSlotController {
    @Autowired
    private ParkingSlotService parkingSlotService;

    @PostMapping("/selectParkingSlotById")
    public CommonReturnType selectParkingSlotById(@RequestParam(name = "id") int id) {
        ParkingSlotModel parkingSlotModel = parkingSlotService.selectParkingSlotById(id);
        return CommonReturnType.create(parkingSlotModel);
    }

    @PostMapping("/registerParkingSlot")
    public CommonReturnType registerParkingSlot(
            @RequestParam(name = "length") float length,
            @RequestParam(name = "width") float width,
            @RequestParam(name = "height") float height,
            @RequestParam(name = "hardwareId") int hardwareId,
            @RequestParam(name = "price") float price,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "longitude") float longitude,
            @RequestParam(name = "latitude") float latitude,
            @RequestParam(name = "fieldId") int fieldId,
            @RequestParam(name = "ownerId") int ownerId) {
        ParkingSlotModel parkingSlotModel = new ParkingSlotModel();
        parkingSlotModel.setLength(length);
        parkingSlotModel.setWidth(width);
        parkingSlotModel.setHeight(height);
        parkingSlotModel.setHardwareId(hardwareId);
        parkingSlotModel.setPrice(price);
        parkingSlotModel.setName(name);
        parkingSlotModel.setLongitude(longitude);
        parkingSlotModel.setLatitude(latitude);
        parkingSlotModel.setFieldId(fieldId);
        parkingSlotModel.setOwnerId(ownerId);
        parkingSlotService.registerParkingSlot(parkingSlotModel);
        return CommonReturnType.create(parkingSlotModel);
    }

    @PostMapping("/updateParkingSlot")
    public CommonReturnType updateParkingSlot(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "length") float length,
            @RequestParam(name = "width") float width,
            @RequestParam(name = "height") float height,
            @RequestParam(name = "hardwareId") int hardwareId,
            @RequestParam(name = "price") float price,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "longitude") float longitude,
            @RequestParam(name = "latitude") float latitude,
            @RequestParam(name = "fieldId") int fieldId,
            @RequestParam(name = "ownerId") int ownerId) {
        ParkingSlotModel parkingSlotModel = new ParkingSlotModel();
        parkingSlotModel.setId(id);
        parkingSlotModel.setLength(length);
        parkingSlotModel.setWidth(width);
        parkingSlotModel.setHeight(height);
        parkingSlotModel.setHardwareId(hardwareId);
        parkingSlotModel.setPrice(price);
        parkingSlotModel.setName(name);
        parkingSlotModel.setLongitude(longitude);
        parkingSlotModel.setLatitude(latitude);
        parkingSlotModel.setFieldId(fieldId);
        parkingSlotModel.setOwnerId(ownerId);
        parkingSlotService.updateParkingSlot(parkingSlotModel);
        return CommonReturnType.create(parkingSlotModel);
    }

    @PostMapping("/deleteParkingSlot")
    public CommonReturnType deleteParkingSlot(@RequestParam(name = "id") int id) {
        parkingSlotService.deleteParkingSlot(id);
        return CommonReturnType.create(null);
    }

    @PostMapping("/selectParkingSlotByOwnerId")
    public CommonReturnType selectParkingSlotByOwnerId(@RequestParam(name = "ownerId") int ownerId) {
        List<ParkingSlotModel> parkingSlotModelList = parkingSlotService.selectParkingSlotByOwnerId(ownerId);
        return CommonReturnType.create(parkingSlotModelList);
    }

    @PostMapping("/selectParkingSlotByFieldId")
    public CommonReturnType selectParkingSlotByFieldId(@RequestParam(name = "fieldId") int fieldId) {
        List<ParkingSlotModel> parkingSlotModelList = parkingSlotService.selectParkingSlotByFieldId(fieldId);
        return CommonReturnType.create(parkingSlotModelList);
    }

    @RequestMapping("/slotNearBy")
    public CommonReturnType slotNearBy(
            @RequestParam(name = "userLongitude") float userLongitude,
            @RequestParam(name = "userLatitude") float userLatitude,
            @RequestParam(name = "distance") float distance) {
        ParkingNearBy parkingNearBy = new ParkingNearBy();
        parkingNearBy.setUserLongitude(userLongitude);
        parkingNearBy.setUserLatitude(userLatitude);
        parkingNearBy.setDistance(distance);
        List<ParkingSlotModel> parkingSlotModelList = parkingSlotService.slotNearBy(parkingNearBy);
        return CommonReturnType.create(parkingSlotModelList);
    }

    @PostMapping("/selectParkingSlotByHardwareId")
    public CommonReturnType selectParkingSlotByHardwareId(@RequestParam(name = "hardwareId") int hardwareId) {
        ParkingSlotModel parkingSlotModel = parkingSlotService.selectParkingSlotByHardwareId(hardwareId);
        return CommonReturnType.create(parkingSlotModel);
    }

}
