package com.dogigiri.core.switchexpressions;

public sealed interface Consumable permits Beverage {
    void consume();
}
