package com.dogigiri.core.streams.collecting;

import com.dogigiri.core.streams.Genre;
import com.dogigiri.core.streams.Movie;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var movieList = List.of(
                new Movie("God father", 20, Genre.ACTION),
                new Movie("Tree of Life", 10, Genre.COMEDY),
                new Movie("Shawshang Redemption", 15, Genre.ACTION),
                new Movie("One flew over cuckoos nest", 20, Genre.COMEDY ));

        // we can use movie -> movie instead of Function.identity().
        var movies = movieList.stream().filter(test -> test.getLike() >= 15).collect(Collectors.toMap(Movie::getName, Function.identity()));
        movies.forEach((key, value) -> System.out.println(value + " key was" + key));

        var number = movieList.stream().map(Movie::getLike).collect(Collectors.summarizingInt(t -> t));
        System.out.println(number);

        var movieName = movieList.stream().map(Movie::getName).collect(Collectors.joining("& "));
        System.out.println(movieName);

        // GroupingBy demo
        var movieByGenre = movieList.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.toList()));
        System.out.println(movieByGenre);
        var sumByGenre = movieList.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
        System.out.println(sumByGenre);
        var movieNamesByGenre = movieList.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.mapping(Movie::getName ,Collectors.joining(" ,"))));
        System.out.println(movieNamesByGenre);

        // partitioningBy demo
        var isLikeMoreThanFifteen = movieList.stream().
                collect(Collectors.partitioningBy(t -> t.getLike() >= 15, Collectors.mapping(Movie::getName, Collectors.joining("& "))));
        System.out.println(isLikeMoreThanFifteen);
    }
}
