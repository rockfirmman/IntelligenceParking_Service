package com.intelligenceparking.service;

import com.intelligenceparking.bean.FieldOwnerModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FieldOwnerService {
    void insert (FieldOwnerModel fieldOwnerModel);

    List<FieldOwnerModel> selectByFieldId(int fieldId);

    List<FieldOwnerModel> selectByOwnerId(int ownerId);

    void deleteFieldOwner(FieldOwnerModel fieldOwnerModel);
}
