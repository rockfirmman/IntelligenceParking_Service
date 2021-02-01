package com.intelligenceparking.controller;


import com.intelligenceparking.bean.CarModel;
import com.intelligenceparking.response.CommonReturnType;
import com.intelligenceparking.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/registerCar")
    public CommonReturnType registerCar(
            @RequestParam(name = "license") String license,
            @RequestParam(name = "length") float length,
            @RequestParam(name = "width") float width,
            @RequestParam(name = "height") float height,
            @RequestParam(name = "color") String color,
            @RequestParam(name = "userId") int userId) {
        CarModel carModel = new CarModel();
        carModel.setLicense(license);
        carModel.setLength(length);
        carModel.setWidth(width);
        carModel.setHeight(height);
        carModel.setColor(color);
        carModel.setUserId(userId);
        carService.registerCar(carModel);
        return CommonReturnType.create(null);
    }

    @RequestMapping("/selectCarById")
    public CommonReturnType selectCarById(@RequestParam(value = "id",defaultValue = "1")int id) {
        CarModel carModel = carService.selectCarById(id);
        return CommonReturnType.create(carModel);
    }

    @RequestMapping("/selectCarByOwnerId")
    public CommonReturnType selectCarByOwnerId(@RequestParam(name = "userId") int userId) {
        List<CarModel> carModelList = carService.selectCarByOwnerId(userId);
        return CommonReturnType.create(carModelList);
    }

    @PostMapping("/updateCarMsg")
    public CommonReturnType updateCarMsg(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "license") String license,
            @RequestParam(name = "length") float length,
            @RequestParam(name = "width") float width,
            @RequestParam(name = "height") float height,
            @RequestParam(name = "color",defaultValue = "其他") String color) {
        //得到userId
        int userId = carService.selectCarById(id).getUserId();
        CarModel carModel = new CarModel();
        carModel.setId(id);
        carModel.setLicense(license);
        carModel.setLength(length);
        carModel.setWidth(width);
        carModel.setHeight(height);
        carModel.setColor(color);
        carModel.setUserId(userId);
        carService.updateCarMsg(carModel);
        return CommonReturnType.create(null);
    }

    @PostMapping("/verifyCar")
    public CommonReturnType verifyCar(@RequestParam(name = "id") int id) {
        CarModel carModel = carService.selectCarById(id);
        carModel.setVerification(true);
        carService.updateCarMsg(carModel);
        return CommonReturnType.create(carModel);
    }

    @PostMapping("/deleteCar")
    public CommonReturnType deleteCar(@RequestParam(name = "id") int id) {
        return null;
    }


}
