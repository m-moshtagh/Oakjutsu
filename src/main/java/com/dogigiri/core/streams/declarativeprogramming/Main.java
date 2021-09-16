package com.dogigiri.core.streams.declarativeprogramming;

import com.dogigiri.core.streams.Genre;
import com.dogigiri.core.streams.Movie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // We are going to count movies with likes more than 15
        var movieList = List.of(
                new Movie("God father", 20, Genre.ACTION),
                new Movie("Tree of Life", 10, Genre.COMEDY),
                new Movie("Shawshang Redemption", 15, Genre.ACTION),
                new Movie("One flew over cuckoos nest", 20, Genre.COMEDY));
    }

    // imperative programming
    public long countPerfectMoviesInImperativeWay(List<Movie> movieList) {
        long count = 0l;
        for (Movie movie : movieList) {
            if (movie.getLike() > 15) {
                count++;
            }
        }
        return count;
    }
    // declarative programming
    public long countPerfectMoviesInDeclarativeWay(List<Movie> movieList) {
        return movieList.stream().filter(movie -> movie.getLike() > 15).count();
    }
}
