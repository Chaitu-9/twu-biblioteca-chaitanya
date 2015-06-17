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

    
}
