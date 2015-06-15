package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    @Test
    public void ifNoBookIsAvailableInLibrary() {
        Library library = new Library();

        int actual = library.availableBooksCount();

        assertThat(actual, is(equalTo(0)));
    }
}