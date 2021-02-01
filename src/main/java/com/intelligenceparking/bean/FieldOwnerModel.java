package com.intelligenceparking.bean;

public class FieldOwnerModel {
    private int fieldId;
    private int ownerId;

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "FieldOwnerModel{" +
                "fieldId=" + fieldId +
                ", ownerId=" + ownerId +
                '}';
    }
}
