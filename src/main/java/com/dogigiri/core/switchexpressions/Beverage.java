package com.dogigiri.core.switchexpressions;

public sealed class Beverage implements Consumable permits Coffee, Tea {
    private double temperature;

    public double getTemperature() {
        return temperature;
    }

    public void heatUp(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public void consume() {
        System.out.println("Consumed");
    }
}
