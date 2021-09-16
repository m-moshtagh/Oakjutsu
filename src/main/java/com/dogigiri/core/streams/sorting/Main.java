package com.dogigiri.core.streams.sorting;

import com.dogigiri.core.streams.Genre;
import com.dogigiri.core.streams.Movie;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var movieList = List.of(
                new Movie("God father", 20, Genre.ACTION),
                new Movie("Tree of Life", 10, Genre.COMEDY),
                new Movie("Shawshang Redemption", 15, Genre.ACTION),
                new Movie("One flew over cuckoos nest", 20, Genre.COMEDY));

        movieList.stream().sorted(Comparator.comparing(Movie::getName).reversed()).forEach(System.out::println);
        // above expression is equals to this one but simpler
        movieList.stream().sorted((a, b) -> a.getName().compareTo(b.getName()));
    }
}
