package com.intelligenceparking.service.serviceImpl;

import com.intelligenceparking.bean.ParkingSlotModel;
import com.intelligenceparking.bean.ParkingSlotModel;
import com.intelligenceparking.dao.ParkingSlotDOMapper;
import com.intelligenceparking.dataobject.ParkingSlotDO;
import com.intelligenceparking.dataobject.ParkingSlotDO;
import com.intelligenceparking.service.ParkingSlotService;
import com.intelligenceparking.tool.requests.ParkingNearBy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {
    @Autowired
    private ParkingSlotDOMapper parkingSlotDOMapper;
    @Override
    public ParkingSlotModel selectParkingSlotById(int id) {
        ParkingSlotDO parkingSlotDO = parkingSlotDOMapper.selectByPrimaryKey(id);
        ParkingSlotModel parkingSlotModel = convertFromDO(parkingSlotDO);
        return parkingSlotModel;
    }

    @Override
    public void registerParkingSlot(ParkingSlotModel parkingSlotModel) {
        ParkingSlotDO parkingSlotDO = convertFromModel(parkingSlotModel);
        parkingSlotDOMapper.insertSelective(parkingSlotDO);
    }

    @Override
    public void deleteParkingSlot(int id) {
        parkingSlotDOMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateParkingSlot(ParkingSlotModel parkingSlotModel) {
        ParkingSlotDO parkingSlotDO = convertFromModel(parkingSlotModel);
        parkingSlotDOMapper.updateByPrimaryKeySelective(parkingSlotDO);
    }

    @Override
    public List<ParkingSlotModel> selectParkingSlotByOwnerId(int ownerId) {
        List<ParkingSlotDO> parkingSlotDOList = parkingSlotDOMapper.selectParkingSlotByOwnerId(ownerId);
        List<ParkingSlotModel> parkingSlotModels = convertFromDOList(parkingSlotDOList);
        return parkingSlotModels;
    }

    @Override
    public List<ParkingSlotModel> selectParkingSlotByFieldId(int fieldId) {
        List<ParkingSlotDO> parkingSlotDOList = parkingSlotDOMapper.selectParkingSlotByFieldId(fieldId);
        List<ParkingSlotModel> parkingSlotModels = convertFromDOList(parkingSlotDOList);
        return parkingSlotModels;
    }

    @Override
    public List<ParkingSlotModel> slotNearBy(ParkingNearBy parkingNearBy) {
        List<ParkingSlotDO> parkingSlotDOList = parkingSlotDOMapper.slotNearBy(parkingNearBy);
        List<ParkingSlotModel> parkingSlotModels = convertFromDOList(parkingSlotDOList);
        return parkingSlotModels;
    }

    private ParkingSlotDO convertFromModel(ParkingSlotModel parkingSlotModel) {
        if (parkingSlotModel == null) {
            return null;
        }
        ParkingSlotDO parkingSlotDO = new ParkingSlotDO();
        BeanUtils.copyProperties(parkingSlotModel, parkingSlotDO);
        return parkingSlotDO;
    }

    private ParkingSlotModel convertFromDO(ParkingSlotDO parkingSlotDO) {
        if (parkingSlotDO == null) {
            return null;
        }
        ParkingSlotModel parkingSlotModel = new ParkingSlotModel();
        BeanUtils.copyProperties(parkingSlotDO, parkingSlotModel);
        return parkingSlotModel;
    }

    private List<ParkingSlotModel> convertFromDOList(List<ParkingSlotDO> parkingSlotDOList) {
        if (parkingSlotDOList == null) {
            return null;
        }
        List<ParkingSlotModel> parkingSlotModelList= new ArrayList<>();
        for (ParkingSlotDO parkingSlotDO : parkingSlotDOList) {
            ParkingSlotModel parkingSlotModel = new ParkingSlotModel();
            BeanUtils.copyProperties(parkingSlotDO, parkingSlotModel);
            parkingSlotModelList.add(parkingSlotModel);
            System.out.println(parkingSlotModel);
        }
        return parkingSlotModelList;
    }
}
