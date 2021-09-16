package com.dogigiri.core.streams.mapping;

import com.dogigiri.core.streams.Genre;
import com.dogigiri.core.streams.Movie;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // map() demo
        var movieList = List.of(
                new Movie("God father", 20, Genre.ACTION),
                new Movie("Tree of Life", 10, Genre.COMEDY),
                new Movie("Shawshang Redemption", 15, Genre.ACTION),
                new Movie("One flew over cuckoos nest", 20, Genre.COMEDY));
        long count = movieList.stream().map(Movie::getName).filter(name -> name.equals("God father")).count();
        System.out.println(count);

        // flatmap() demo
        var stream = Stream.of(List.of(1, 2, 3), List.of(5, 5, 6));
        stream.flatMap(List::stream).forEach(System.out::println);
    }
}
