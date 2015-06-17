package com.twu.biblioteca;

public class Movie {
    String name, director;
    int year;
    double rating;

    public Movie(String name, int year, String director, double rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "name : " + name +" year : " + year +" director : " + director + " rating : " + rating ;
    }
}
