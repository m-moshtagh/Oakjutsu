package com.dogigiri.designpatterns.mosh.state.exercise;

public class Drive implements TravelMode {

    @Override
    public Object getDirection() {
        System.out.println("Direction for Drive.");
        return 3;
    }

    @Override
    public Integer getETA() {
        System.out.println("ETA for Drive");
        return 3;
    }
}
