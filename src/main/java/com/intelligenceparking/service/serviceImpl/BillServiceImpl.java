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
    public BillDO selectBillById(int id) {
        BillDO billDO = billDOMapper.selectBillById(id);
        return billDO;
    }

    @Override
    public void createBill(BillDO billDO) {
//        BillDO billDO = convertFromModel(billModel);
        billDOMapper.createBill(billDO);
    }

    @Override
    public void updateBillState(BillDO billDO) {
//        BillDO billDO = convertFromModel(billModel);
        billDOMapper.updateBillState(billDO);
    }

    @Override
    public void addComments(BillDO billDO) {
//        BillDO billDO = convertFromModel(billModel);
        billDOMapper.addComments(billDO);
    }

    @Override
    public List<BillDO> selectBillByPayerId(int payerId) {
        List<BillDO> billDOList = billDOMapper.selectBillByPayerId(payerId);
        return billDOList;
    }

    @Override
    public List<BillDO> selectBillByFieldId(int fieldId) {
        return null;
    }

    @Override
    public List<BillDO> selectBillBySlotId(int slotId) {
        return null;
    }

    @Override
    public List<BillDO> selectBillByOwnerId(int ownerId) {
        return null;
    }

    @Override
    public List<BillDO> selectBillByCarId(int carId) {
        return null;
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
