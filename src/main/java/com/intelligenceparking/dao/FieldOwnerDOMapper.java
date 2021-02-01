package com.intelligenceparking.dao;

import com.intelligenceparking.dataobject.FieldOwnerDOKey;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FieldOwnerDOMapper {
    int deleteByPrimaryKey(FieldOwnerDOKey key);

    int insert(FieldOwnerDOKey record);

    int insertSelective(FieldOwnerDOKey record);

    List<FieldOwnerDOKey> selectByFieldId(int fieldId);

    List<FieldOwnerDOKey> selectByOwnerId(int ownerId);
}