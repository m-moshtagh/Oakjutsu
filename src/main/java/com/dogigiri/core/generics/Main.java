package com.dogigiri.core.generics;

import com.dogigiri.core.compareObjects.Athlete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 *  Generics Types are Classes that have Abstract Parameters which can represent any Type. whenever we need a class to be
 * implemented with Lots of Types we use Generic Types. So we just implement a class that accepts generic Objects.
 * Java collection framework classes are a good implementation of Generics.
 * We usually represent types by T -> type, E -> element, K -> key and V -> Value
 */
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
