package com.intelligenceparking.tool.requests;

import org.springframework.web.bind.annotation.RequestParam;

public class ParkingNearBy {
    private float userLongitude;
    private float userLatitude;
    private float distance;

    public float getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(float userLongitude) {
        this.userLongitude = userLongitude;
    }

    public float getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(float userLatitude) {
        this.userLatitude = userLatitude;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "ParkingNearBy{" +
                "userLongitude=" + userLongitude +
                ", userLatitude=" + userLatitude +
                ", distance=" + distance +
                '}';
    }
}
