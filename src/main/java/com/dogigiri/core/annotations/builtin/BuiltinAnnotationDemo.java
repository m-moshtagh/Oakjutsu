package com.dogigiri.core.annotations.builtin;


import java.applet.Applet;
import java.util.function.Supplier;

/**
 * This is a simple demo of Java built-in annotations.
 *
 * @author Dogigiri
 * @version 1.0
 * @since 2021
 */
public class BuiltinAnnotationDemo<T> {
    /**
     * A method to show @Deprecated annotation
     */
    @Deprecated
    public static void show() {
        System.out.println("Im deprecated");
    }

    /**
     * method to show @safeVarargs annotation
     * @param t a set of strings
     */
    @SafeVarargs
    public final void testVarargs(T... t) {
        for (T s : t) {
            System.out.println(s);
        }
    }

    /**
     *
     * @param args suppress warning annotation demo
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        var a = new BuiltinAnnotationDemo();
        a.testVarargs("jamal", "kamal");
        show();
        int width = Applet.WIDTH;
        System.out.println(width);
    }
    @FunctionalInterface
    public interface functionalInterface{
        /**
         *
         * @param stringSupplier demo of a functional interface
         */
        void execute(Supplier<String> stringSupplier);
    }
}
