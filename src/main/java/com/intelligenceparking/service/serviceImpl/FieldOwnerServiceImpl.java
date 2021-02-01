package com.intelligenceparking.service.serviceImpl;

import com.intelligenceparking.bean.FieldOwnerModel;
import com.intelligenceparking.bean.FieldOwnerModel;
import com.intelligenceparking.dao.FieldOwnerDOMapper;
import com.intelligenceparking.dataobject.FieldOwnerDOKey;
import com.intelligenceparking.dataobject.FieldOwnerDOKey;
import com.intelligenceparking.service.FieldOwnerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FieldOwnerServiceImpl implements FieldOwnerService {
    @Autowired
    private FieldOwnerDOMapper fieldOwnerDOMapper;

    @Override
    public void insert(FieldOwnerModel fieldOwnerModel) {
        FieldOwnerDOKey fieldOwnerDOKey = convertFromModel(fieldOwnerModel);
        fieldOwnerDOMapper.insert(fieldOwnerDOKey);
    }

    @Override
    public List<FieldOwnerModel> selectByFieldId(int fieldId) {
        List<FieldOwnerDOKey> FieldOwnerDOKeyList = fieldOwnerDOMapper.selectByFieldId(fieldId);
        List<FieldOwnerModel> FieldOwnerModelList= convertFromDOList(FieldOwnerDOKeyList);
        return FieldOwnerModelList;
    }

    @Override
    public List<FieldOwnerModel> selectByOwnerId(int ownerId) {
        List<FieldOwnerDOKey> FieldOwnerDOKeyList = fieldOwnerDOMapper.selectByOwnerId(ownerId);
        List<FieldOwnerModel> FieldOwnerModelList= convertFromDOList(FieldOwnerDOKeyList);
        return FieldOwnerModelList;
    }

    @Override
    public void deleteFieldOwner(FieldOwnerModel fieldOwnerModel) {
        FieldOwnerDOKey fieldOwnerDOKey = convertFromModel(fieldOwnerModel);
        fieldOwnerDOMapper.deleteByPrimaryKey(fieldOwnerDOKey);
    }

    private FieldOwnerDOKey convertFromModel(FieldOwnerModel fieldOwnerModel) {
        if (fieldOwnerModel == null) {
            return null;
        }
        FieldOwnerDOKey fieldOwnerDOKey = new FieldOwnerDOKey();
        BeanUtils.copyProperties(fieldOwnerModel, fieldOwnerDOKey);
        return fieldOwnerDOKey;
    }

    private FieldOwnerModel convertFromDO(FieldOwnerDOKey fieldOwnerDOKey) {
        if (fieldOwnerDOKey == null) {
            return null;
        }
        FieldOwnerModel fieldOwnerModel = new FieldOwnerModel();
        BeanUtils.copyProperties(fieldOwnerDOKey, fieldOwnerModel);
        return fieldOwnerModel;
    }

    private List<FieldOwnerModel> convertFromDOList(List<FieldOwnerDOKey> fieldOwnerDOKeyList) {
        if (fieldOwnerDOKeyList == null) {
            return null;
        }
        List<FieldOwnerModel> fieldOwnerModelList= new ArrayList<>();
        for (FieldOwnerDOKey fieldOwnerDOKey : fieldOwnerDOKeyList) {
            FieldOwnerModel fieldOwnerModel = new FieldOwnerModel();
            BeanUtils.copyProperties(fieldOwnerDOKey, fieldOwnerModel);
            fieldOwnerModelList.add(fieldOwnerModel);
            System.out.println(fieldOwnerModel);
        }
        return fieldOwnerModelList;
    }
}
