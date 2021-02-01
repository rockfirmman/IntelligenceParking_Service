package com.intelligenceparking.service.serviceImpl;

import com.intelligenceparking.bean.ParkingFieldModel;
import com.intelligenceparking.bean.ParkingFieldModel;
import com.intelligenceparking.dao.ParkingFieldDOMapper;
import com.intelligenceparking.dataobject.ParkingFieldDO;
import com.intelligenceparking.dataobject.ParkingFieldDO;
import com.intelligenceparking.service.ParkingFieldService;
import com.intelligenceparking.tool.requests.ParkingNearBy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ParkingFieldServiceImpl implements ParkingFieldService {
    @Autowired
    private ParkingFieldDOMapper parkingFieldDOMapper;
    @Override
    public ParkingFieldModel selectFieldById(int id) {
        ParkingFieldDO parkingFieldDO = parkingFieldDOMapper.selectByPrimaryKey(id);
        ParkingFieldModel parkingFieldModel = convertFromDO(parkingFieldDO);
        return parkingFieldModel;
    }

    @Override
    public void registerParkingField(ParkingFieldModel parkingFieldModel) {
        ParkingFieldDO parkingFieldDO = convertFromModel(parkingFieldModel);
        parkingFieldDOMapper.insertSelective(parkingFieldDO);
    }

    @Override
    public void updateParkingField(ParkingFieldModel parkingFieldModel) {
        ParkingFieldDO parkingFieldDO = convertFromModel(parkingFieldModel);
        parkingFieldDOMapper.updateByPrimaryKeySelective(parkingFieldDO);
    }

    @Override
    public void deleteParkingField(int id) {
        parkingFieldDOMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ParkingFieldModel> findAllFields() {
        List<ParkingFieldDO> parkingFieldDOList = parkingFieldDOMapper.findAllFields();
        List<ParkingFieldModel> parkingFieldModelList = convertFromDOList(parkingFieldDOList);
        return parkingFieldModelList;
    }

    @Override
    public List<ParkingFieldModel> fieldNearBy(ParkingNearBy parkingNearBy) {
        List<ParkingFieldDO> parkingFieldDOList = parkingFieldDOMapper.fieldNearBy(parkingNearBy);
        List<ParkingFieldModel> parkingFieldModelList = convertFromDOList(parkingFieldDOList);
        return parkingFieldModelList;
    }


    private ParkingFieldDO convertFromModel(ParkingFieldModel parkingFieldModel) {
        if (parkingFieldModel == null) {
            return null;
        }
        ParkingFieldDO parkingFieldDO = new ParkingFieldDO();
        BeanUtils.copyProperties(parkingFieldModel, parkingFieldDO);
        return parkingFieldDO;
    }

    private ParkingFieldModel convertFromDO(ParkingFieldDO parkingFieldDO) {
        if (parkingFieldDO == null) {
            return null;
        }
        ParkingFieldModel parkingFieldModel = new ParkingFieldModel();
        BeanUtils.copyProperties(parkingFieldDO, parkingFieldModel);
        return parkingFieldModel;
    }

    private List<ParkingFieldModel> convertFromDOList(List<ParkingFieldDO> parkingFieldDOList) {
        if (parkingFieldDOList == null) {
            return null;
        }
        List<ParkingFieldModel> parkingFieldModelList= new ArrayList<>();
        for (ParkingFieldDO parkingFieldDO : parkingFieldDOList) {
            ParkingFieldModel parkingFieldModel = new ParkingFieldModel();
            BeanUtils.copyProperties(parkingFieldDO, parkingFieldModel);
            parkingFieldModelList.add(parkingFieldModel);
            System.out.println(parkingFieldModel);
        }
        return parkingFieldModelList;
    }
}
