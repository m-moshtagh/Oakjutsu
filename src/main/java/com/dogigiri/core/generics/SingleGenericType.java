package com.dogigiri.core.generics;

public class SingleGenericType <T>{
    T type;
    SingleGenericType(T type){
        this.type = type;
    }

    public void showType() {
        System.out.println(type.getClass());
    }

}
