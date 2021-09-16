package com.dogigiri.core.exceptions;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};

        try {
            try {
                try {
                    int indexNotFound = array[10];
                } catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("Third Block threw The same problem to Second One");
                    throw exception;
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Second Block threw the same problem to First One");
                throw exception;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("First Try block");
        } finally {
            System.out.println("You are trying to access invalid index");
        }
    }
}
