package com.dogigiri.designpatterns.mosh.state.exercise;

public class Walk implements TravelMode {

    @Override
    public Object getDirection() {
        System.out.println("Direction for Walk.");
        return 2;
    }

    @Override
    public Integer getETA() {
        System.out.println("ETA for Walk");
        return 2;
    }
}
