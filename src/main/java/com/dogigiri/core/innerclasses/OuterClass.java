package com.dogigiri.core.innerclasses;

public class OuterClass {
    private int pAge;
    private static int psAge;
    static int sAge;

    public static void rage() {

    }

    private void sum() {

    }
      static class innerClass{
        public void display() {
            System.out.println("Static inner class can only access the static properties & Methods");
            System.out.println("non- static inner class can access all properties & Methods");
            System.out.println("we can also define a class in a local method but we need to instantiate it inside the method");
        }
    }
}
