package com.dogigiri.core.datatypeconversion;

public class Main {
    public static void main(String[] args) {
        // small to larger variable
        int a = 25;
        long b = a;
        System.out.printf("int %d and long %d \n", a, b);

        //larger to smaller variable (needs casting)
        long c = 4646L;
        int d = (int) c;
        System.out.printf("int %d and long %d \n", c, d);
    }
}
