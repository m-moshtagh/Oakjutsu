package com.dogigiri.core.streams;

public class Movie {
    private String name;
    private int like;
    private Genre genre;

    public Movie(String name, int like, Genre genre) {
        this.name = name;
        this.like = like;
        this.genre = genre;
    }

    public Movie(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", like=" + like +
                '}';
    }

    public Genre getGenre() {
        return genre;
    }
}
