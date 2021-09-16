package com.dogigiri.core.streams.reducing;

import com.dogigiri.core.streams.Genre;
import com.dogigiri.core.streams.Movie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var movieList = List.of(
                new Movie("God father", Genre.ACTION),
                new Movie("Tree of Life", Genre.COMEDY),
                new Movie("Shawshang Redemption", Genre.ACTION),
                new Movie("One flew over cuckoos nest", Genre.COMEDY),
                new Movie("Tenet", Genre.ACTION));

        var reducedStream = movieList.stream().map(Movie::getLike).reduce((a, b) -> a + b);
        System.out.println(reducedStream.orElse(0));
    }
}
