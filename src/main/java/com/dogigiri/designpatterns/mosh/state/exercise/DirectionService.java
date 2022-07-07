package com.dogigiri.designpatterns.mosh.state.exercise;

public class DirectionService {
    private TravelMode travelMode;

    public Object getEta() {
        return this.travelMode.getETA();
    }

    public Object getDirection() {
        return this.travelMode.getDirection();
    }

    public DirectionService setTravelMode(TravelMode travelMode) {
        this.travelMode = travelMode;
        return this;
    }
}
