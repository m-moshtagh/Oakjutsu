package com.dogigiri.core.exceptions;

public class DemoOfChainingException {
    public static void main(String[] args) {
        try {
            chainOne(-1);
        } catch (CustomException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            chainTwo(-2);
        } catch (SecondCustomException e) {
            e.printStackTrace();
        }
    }

    public static void chainOne(int a) throws CustomException{
        if (a < 0) {
            var e1 = new CustomException();
            var e2 = new SecondCustomException();
            e1.initCause(e2);
            throw e1;
        }
    }

    public static void chainTwo(int b) throws SecondCustomException{
        if (b < -1) {
            throw new SecondCustomException(new CustomException());
        }
    }
}
