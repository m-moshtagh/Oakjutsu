package com.dogigiri.designpatterns.mosh.state.exercise;

public class Transit implements TravelMode {

    @Override
    public Object getDirection() {
        System.out.println("Direction for Transit.");
        return 4;
    }

    @Override
    public Integer getETA() {
        System.out.println("ETA for Transit");
        return 4;
    }
}
