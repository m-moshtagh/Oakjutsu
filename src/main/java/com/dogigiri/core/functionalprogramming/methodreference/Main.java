package com.dogigiri.core.functionalprogramming.methodreference;

public class Main {
    public static void main(String[] args) {
        print(PrinterDevice::print);
        print(PrinterDevice::new);
    }

    public static void print(Printer printer) {
        printer.print("printer");
    }
}
