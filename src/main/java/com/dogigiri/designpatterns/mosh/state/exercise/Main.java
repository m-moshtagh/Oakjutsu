package com.dogigiri.designpatterns.mosh.state.exercise;

public class Main {
    public static void main(String[] args) {
        var directionService = new DirectionService().setTravelMode(new Drive());
        System.out.println(directionService.getDirection() + " and " + directionService.getEta());
    }
}
