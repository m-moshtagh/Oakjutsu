package com.dogigiri.core.generics.generictypes;

public class DoubleGenericType <T, U extends Number>{
    T type;
    U id;
    public DoubleGenericType(T type, U id){
        this.type = type;
        this.id = id;
    }

    public void showType() {
        System.out.println("type is " + type.getClass() + " Id is type of " + id.getClass());
    }
}
