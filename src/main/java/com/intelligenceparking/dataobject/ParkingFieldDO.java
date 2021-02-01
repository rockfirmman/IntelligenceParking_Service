package com.intelligenceparking.dataobject;

public class ParkingFieldDO {
    private Integer id;

    private Byte isBanned;

    private String name;

    private Float longitude;

    private Float latitude;

    private String description;

    private String pictureUrl;

    private String coordinateUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Byte isBanned) {
        this.isBanned = isBanned;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getCoordinateUrl() {
        return coordinateUrl;
    }

    public void setCoordinateUrl(String coordinateUrl) {
        this.coordinateUrl = coordinateUrl == null ? null : coordinateUrl.trim();
    }
}