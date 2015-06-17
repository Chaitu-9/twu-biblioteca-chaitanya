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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (year != movie.year) return false;
        if (Double.compare(movie.rating, rating) != 0) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        return !(director != null ? !director.equals(movie.director) : movie.director != null);

    }

    @Override
    public int hashCode() {
        int result;
        result = name != null ? name.hashCode() : 0;
        return result;
    }
}
