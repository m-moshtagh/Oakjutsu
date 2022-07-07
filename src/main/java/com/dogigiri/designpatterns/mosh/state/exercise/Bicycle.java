package com.dogigiri.designpatterns.mosh.state.exercise;

public class Bicycle implements TravelMode {

    @Override
    public Object getDirection() {
        System.out.println("Direction for Bicycle.");
        return 1;
    }

    @Override
    public Integer getETA() {
        System.out.println("ETA for Bicycle");
        return 1;
    }
}
