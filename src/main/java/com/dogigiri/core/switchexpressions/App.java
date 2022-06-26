package com.dogigiri.core.switchexpressions;

public class App {
    public static void main(String[] args) {
        var beverage = new Beverage();
        beverage.heatUp(35.5);
        var coffee = new Coffee();
        var tea = new Tea();
        printSpecificMessagePerType(beverage);
        printSpecificMessagePerType(coffee);
        printSpecificMessagePerType(tea);
    }

    private static void printSpecificMessagePerType(Consumable consumable) {
        switch (consumable) {
            case Coffee coffee -> coffee.addCream();
            case Tea tea -> tea.stirTea();
            default -> System.out.println("nothing special to be done!");
        }
        consumable.consume();
    }
}
