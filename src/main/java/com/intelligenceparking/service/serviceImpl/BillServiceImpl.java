package com.intelligenceparking.service.serviceImpl;

import com.intelligenceparking.bean.BillModel;
import com.intelligenceparking.bean.UserModel;
import com.intelligenceparking.dao.BillDOMapper;
import com.intelligenceparking.dataobject.BillDO;
import com.intelligenceparking.dataobject.UserDO;
import com.intelligenceparking.service.BillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillDOMapper billDOMapper;

    @Override
    public BillModel selectBillById(int id) {
        BillDO billDO = billDOMapper.selectByPrimaryKey(id);
        return convertFromDO(billDO);
    }

    @Override
    public void createBill(BillModel billModel) {
        BillDO billDO = convertFromModel(billModel);
        billDOMapper.insert(billDO);
    }

    @Override
    public void updateBillState(BillModel billModel) {
        BillDO billDO = convertFromModel(billModel);
        billDOMapper.updateByPrimaryKeySelective(billDO);
    }

    @Override
    public List<BillModel> selectBillByPayerId(int payerId) {
        List<BillDO> billDOList = billDOMapper.selectBillByPayerId(payerId);
        return convertFromDOList(billDOList);
    }

    @Override
    public List<BillModel> selectBillByFieldId(int fieldId) {
        List<BillDO> billDOList = billDOMapper.selectBillByFieldId(fieldId);
        return convertFromDOList(billDOList);
    }

    @Override
    public List<BillModel> selectBillBySlotId(int slotId) {
        List<BillDO> billDOList = billDOMapper.selectBillBySlotId(slotId);
        return convertFromDOList(billDOList);
    }

    @Override
    public List<BillModel> selectBillByOwnerId(int ownerId) {
        List<BillDO> billDOList = billDOMapper.selectBillByOwnerId(ownerId);
        return convertFromDOList(billDOList);
    }

    @Override
    public List<BillModel> selectBillByCarId(int carId) {
        List<BillDO> billDOList = billDOMapper.selectBillByCarId(carId);
        return convertFromDOList(billDOList);
    }

    private BillDO convertFromModel(BillModel billModel) {
        if (billModel == null) {
            return null;
        }
        BillDO billDO = new BillDO();
        BeanUtils.copyProperties(billModel, billDO);
        return billDO;
    }

    private BillModel convertFromDO(BillDO billDO) {
        if (billDO == null) {
            return null;
        }
        BillModel billModel = new BillModel();
        BeanUtils.copyProperties(billDO, billModel);
        return billModel;
    }

    private List<BillModel> convertFromDOList(List<BillDO> billDOList) {
        if (billDOList == null) {
            return null;
        }
        List<BillModel> billModelList= new ArrayList<>();
//        for (BillDO billDO : billDOList) {
//            BillModel billModel = new BillModel();
//            BeanUtils.copyProperties(billDO, billModel);
//            billModelList.add(billModel);
//            System.out.println(billModel);
//        }
        for(int i = 0 ; i < billDOList.size() ; i++){
            BillModel billModel = new BillModel();
            BeanUtils.copyProperties(billDOList.get(i), billModel);
            billModelList.add(billModel);
            System.out.println(billModel);
        }
        return billModelList;
    }
}
