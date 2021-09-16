package com.dogigiri.datastructures.nonlinear.binarytree;

public class RecursionDemo {
    public int factorial(int value) {
        if (value == 0) {
            return 1;
        }
        return value * factorial(value - 1);
    }

    public int factorialLoop(int value) {
        int fact = 1;
        for (var i = value; i > 1; i--) {
            fact *= i;
        }
        return fact;
    }
}
