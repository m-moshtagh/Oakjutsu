package com.dogigiri.core.generics.generictypes;

public class SingleGenericType <T>{
    T type;
    public SingleGenericType(T type){
        this.type = type;
    }

    public void showType() {
        System.out.println(type.getClass());
    }

}
