package com.intelligenceparking.bean;

public class CarModel {
    private int id;
    private String license;
    private String type;
    private float length;
    private float width;
    private float height;
    private String color;
    private int userId;
    private boolean verification;

    public int getId() {
        return id;
    }

    public String getLicense() {
        return license;
    }

    public String getType() {
        return type;
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

    public String getColor() {
        return color;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isVerification() {
        return verification;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setColor(String color) {
        this.color = color;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "id=" + id +
                ", license='" + license + '\'' +
                ", type='" + type + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", userId=" + userId +
                ", verification=" + verification +
                '}';
    }
}
