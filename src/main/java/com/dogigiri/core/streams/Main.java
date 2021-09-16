package com.dogigiri.core.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
         * These helps us with iterating and manipulating Collections.
         * Streams means that we don't need to store full object on memory for usage. like watching a streamed video on
         * an streaming platform.
         * This is really helpful in working with collections.
         */
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);

//        List<Integer> squareList = new ArrayList<>();
//        for (Integer i : list) {
//            squareList.add(i * i);
//        }
        // but with streams we can write this whole code in a single line.

        /*
         * map method is used to change or convert the representation of a collection
         * Lambda expression syntax is like we pss two representation of the input and output of the representation.
         * for example we say w -> 2*w this will show that we want to multiply the input with 2.
         * We have two types of operations working with streams: 1- intermediate 2- terminal
         * intermediate functions like map can be called in a chain form but terminal ones are the last one to be called
         * and we can't chain any operations afterwards.
         */
//        List<Integer> streamMappedSquareList = squareList.stream().map(element -> element * element).collect(Collectors.toList());
//        for (Integer x : streamMappedSquareList) {
//            System.out.println(x);
//        }

        /*
         * for example we wan to store the squared values in a set. we compare both normal and stream ways:
         */

//        Set<Integer> squaredSet = new HashSet<>();
//        for (Integer i : list) {
//            squaredSet.add(i * i);
//        }
//        squaredSet.forEach(System.out::println);

//        Set<Integer> squaredSet = list.stream().map(element -> element * element).collect(Collectors.toSet());
//        squaredSet.forEach(System.out::println);
        /*
         * We can also filter the collection and collect the result using filter method. whenever we need to apply a condition
         * on a stream we can do it by filter method.
         */
        List<String> languages = Arrays.asList("Java", "python", "Kotlin", "Scala", "C", "C#", "C++");
//        List<String> filteredResult = new ArrayList<>();
//        for (String a : languages) {
//            if (a.startsWith("C")) {
//                filteredResult.add(a);
//            }
//        }

//        List<String> filteredResult = languages.stream().filter(x -> x.startsWith("C")).collect(Collectors.toList());
//        filteredResult.stream().sorted().forEach(System.out::println);

        /*
         * Reduce functionality:
         * Whenever we need to change the whole collection and produce only a single result we use reduce.
         * for example we want to calculate the sum of all the collection elements into a single result.
         * we need to understand Identity, Accumulator and Combiner
         * Identity is an element which is the initial value of the reduction operation and the default result if the stream is empty
         *
         * Accumulator is a function that takes two parameters: 1-a partial result of the reduction parameter for example in case of
         * summing all elements in list we need to save the sum till the second element.
         * 2- the second argument is the next element of the stream.
         *
         * Combiner is an optional function which you will require to use if you want to sum two elements that don't have same datatype.
         * for example in this case bot arguments of accumulator function are the same data type. so we don't need combiner.
         */

        Integer sumOfElements = list.stream().reduce(0, (sum, i) -> sum + i);
        System.out.println(sumOfElements);
    }
}
