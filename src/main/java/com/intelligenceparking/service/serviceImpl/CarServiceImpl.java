package com.intelligenceparking.service.serviceImpl;

import com.intelligenceparking.bean.BillModel;
import com.intelligenceparking.bean.CarModel;
import com.intelligenceparking.dao.CarDOMapper;
import com.intelligenceparking.dao.UserDOMapper;
import com.intelligenceparking.dataobject.BillDO;
import com.intelligenceparking.dataobject.CarDO;
import com.intelligenceparking.service.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDOMapper carDOMapper;

    @Override
    public CarModel selectCarById(int id) {
        CarDO carDO = carDOMapper.selectByPrimaryKey(id);
        return convertFromDO(carDO);
    }

    @Override
    public void registerCar(CarModel carModel) {
        CarDO carDO = convertFromModel(carModel);
        carDOMapper.insertSelective(carDO);
    }

    @Override
    public void deleteCar(int id) {
        carDOMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateCarMsg(CarModel carModel) {
        CarDO carDO = convertFromModel(carModel);
        carDOMapper.updateByPrimaryKeySelective(carDO);
    }

    @Override
    public List<CarModel> selectCarByOwnerId(int userId) {
        List<CarDO> carDOList = carDOMapper.selectCarByOwnerId(userId);
        List<CarModel> carModelList = convertFromDOList(carDOList);
        return  carModelList;
    }

    private CarDO convertFromModel(CarModel carModel) {
        if (carModel == null) {
            return null;
        }
        CarDO carDO = new CarDO();
        BeanUtils.copyProperties(carModel, carDO);
        return carDO;
    }

    private CarModel convertFromDO(CarDO carDO) {
        if (carDO == null) {
            return null;
        }
        CarModel carModel = new CarModel();
        BeanUtils.copyProperties(carDO, carModel);
        return carModel;
    }

    private List<CarModel> convertFromDOList(List<CarDO> carDOList) {
        if (carDOList == null) {
            return null;
        }
        List<CarModel> carModelList= new ArrayList<>();
        for (CarDO carDO : carDOList) {
            CarModel carModel = new CarModel();
            BeanUtils.copyProperties(carDO, carModel);
            carModelList.add(carModel);
            System.out.println(carModel);
        }
        return carModelList;
    }
}
