package com.intelligenceparking.controller;

import com.intelligenceparking.bean.ParkingFieldModel;
import com.intelligenceparking.response.CommonReturnType;
import com.intelligenceparking.service.ParkingFieldService;
import com.intelligenceparking.tool.requests.ParkingNearBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parkingfield")
public class ParkingFieldController {
    @Autowired
    private ParkingFieldService parkingFieldService;

    @RequestMapping("/selectFieldById")
    public CommonReturnType selectFieldById(@RequestParam(name = "id") int id) {
        ParkingFieldModel parkingFieldModel = parkingFieldService.selectFieldById(id);
        return CommonReturnType.create(parkingFieldModel);
    }

    @RequestMapping("/registerParkingField")
    public CommonReturnType registerParkingField(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "longitude") float longitude,
            @RequestParam(name = "latitude") float latitude,
            @RequestParam(name = "description") String description) {
        ParkingFieldModel parkingFieldModel = new ParkingFieldModel();
        parkingFieldModel.setName(name);
        parkingFieldModel.setLongitude(longitude);
        parkingFieldModel.setLatitude(latitude);
        parkingFieldModel.setDescription(description);
        parkingFieldService.registerParkingField(parkingFieldModel);
        return CommonReturnType.create(null);
    }

    @RequestMapping("/updateParkingField")
    public CommonReturnType updateParkingField(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "longitude") float longitude,
            @RequestParam(name = "latitude") float latitude,
            @RequestParam(name = "description") String description) {
        ParkingFieldModel parkingFieldModel = new ParkingFieldModel();
        parkingFieldModel.setId(id);
        parkingFieldModel.setName(name);
        parkingFieldModel.setLongitude(longitude);
        parkingFieldModel.setLatitude(latitude);
        parkingFieldModel.setDescription(description);
        parkingFieldService.updateParkingField(parkingFieldModel);
        return CommonReturnType.create(parkingFieldModel);
    }

    @RequestMapping("/uploadFile")
    public CommonReturnType uploadFile(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "pictureUrl") float pictureUrl,
            @RequestParam(name = "coordinateUrl") String description) {
        //TODO 文件传输存储
        return CommonReturnType.create(null);
    }

    @RequestMapping("/deleteParkingField")
    public CommonReturnType deleteParkingField(@RequestParam(name = "id") int id) {
        //TODO
        return null;
    }

    @RequestMapping("/findAllFields")
    public CommonReturnType findAllFields() {
        List<ParkingFieldModel> parkingFieldModelList = parkingFieldService.findAllFields();
        return CommonReturnType.create(parkingFieldModelList);
    }

    @RequestMapping("/fieldNearBy")
    public CommonReturnType fieldNearBy(
            @RequestParam(name = "userLongitude") float userLongitude,
            @RequestParam(name = "userLatitude") float userLatitude,
            @RequestParam(name = "distance") float distance) {
        ParkingNearBy parkingNearBy = new ParkingNearBy();
        parkingNearBy.setUserLongitude(userLongitude);
        parkingNearBy.setUserLatitude(userLatitude);
        parkingNearBy.setDistance(distance);
        List<ParkingFieldModel> parkingFieldModelList = parkingFieldService.fieldNearBy(parkingNearBy);
        return CommonReturnType.create(parkingFieldModelList);
    }
}
