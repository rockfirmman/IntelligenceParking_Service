package com.intelligenceparking.bean;

public class ParkingSlotModel {
    private int id;
    private boolean isOccupied;
    private boolean isBanned;
    private float length;
    private float width;
    private float height;
    private int hardwareId;
    private float price;
    private String name;
    private float longitude;
    private float latitude;
    private String pictureUrl;
    private int fieldId;
    private int ownerId;

    public int getId() {
        return id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public int getHardwareId() {
        return hardwareId;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public int getFieldId() {
        return fieldId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setHardwareId(int hardwareId) {
        this.hardwareId = hardwareId;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "ParkingSlotModel{" +
                "id=" + id +
                ", isOccupied=" + isOccupied +
                ", isBanned=" + isBanned +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", hardwareId=" + hardwareId +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", fieldId=" + fieldId +
                ", ownerId=" + ownerId +
                '}';
    }
}
