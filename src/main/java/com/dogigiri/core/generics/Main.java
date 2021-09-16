package com.dogigiri.core.generics;


import com.dogigiri.core.compareobjects.Athlete;
import com.dogigiri.core.generics.generictypes.DoubleGenericType;
import com.dogigiri.core.generics.generictypes.SingleGenericType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("This is a Demo of Generics");

        SingleGenericType<String> obj = new SingleGenericType<>("rise");
        DoubleGenericType<Athlete, Long> obj2 = new DoubleGenericType<>(new Athlete(), 1L);
        obj2.showType();
        obj.showType();
    }
}
