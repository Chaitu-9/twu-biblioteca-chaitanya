package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MovieTest {

    @Test
    public void shouldPrintFirstMovieDetails(){
        Movie movie = new Movie("Inception",2010,"Nolan",8.8);

        String actualValue = "name : Inception year : 2010 director : Nolan rating : 8.8";

        assertThat(actualValue, is(movie.toString()));
    }

    @Test
    public void testForReflexivity() {
        Movie movie1 = null;

        assertEquals(movie1, movie1);
    }

    @Test
    public void testForComparingNullObjectsWithAMovie() {
        Movie movie1 = null;

        assertThat(movie1, not(equalTo(null)));
    }

    @Test
    public void testForEquality() {
        Movie movie1 = null;
        Movie movie2 = null;

        assertEquals(movie1, movie2);
    }

    @Test
    public void testForDifferentObjects() {
        Movie movie1 = null;
        Object one = new Integer(1);

        assertThat(movie1, not(equalTo(one)));
    }

    @Test
    public void testForTransitivity() {
        Movie movie1 = null;
        Movie movie2 = null;
        Movie movie3 = null;

        assertEquals(movie1, movie2);
        assertEquals(movie2, movie1);
        assertEquals(movie1, movie3);
    }

    @Test
    public void testForSymmetry() {
        Movie movie1 = null;
        Movie movie2 = null;

        assertEquals(movie1, movie2);
        assertEquals(movie2, movie1);
    }

    @Test
    public void equalityTestForHashCode() {
        Movie movie1 = null;
        Movie movie2 = null;

        assertEquals(movie1.hashCode(), movie2.hashCode());
    }

}
