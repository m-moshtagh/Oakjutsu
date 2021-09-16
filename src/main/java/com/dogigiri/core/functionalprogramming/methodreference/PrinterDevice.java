package com.dogigiri.core.functionalprogramming.methodreference;

public class PrinterDevice {
    public static void print(String message) {
        System.out.println("printing with " + message);
    }

    public PrinterDevice(String message) {
        System.out.println("Print with the device: " + message);
    }
}
