package com.dogigiri.core.autoboxing;

/*
 *  The process of assigning a primitive value to it's Wrapper type is called autobox which can be done by calling valueOf() method
 *  The process of assigning a wrapper type to a primitive type is called auto-unboxing. which is directly done by = operator.
 *  Java automatically does autoboxing without calling the value of by just = operator too.
 */
public class Main {
    public static void main(String[] args) {
        Character wrapperCharacter = Character.valueOf('j'); // -> Character wrapperCharacter = 'j';
        System.out.println("Wrapper character -> " + wrapperCharacter);
        char primitiveCharacter = wrapperCharacter;
        System.out.println("primitive character -> " + primitiveCharacter);
    }
}
