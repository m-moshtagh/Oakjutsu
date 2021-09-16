package com.dogigiri.core.innerclasses;

public class Main {
    public static void main(String[] args) {
        OuterClass.innerClass in = new OuterClass.innerClass(); // for static inner class
//        OuterClass.innerClass in2 = new OuterClass().new innerClass(); //for non-static inner class
        in.display();
    }
}
