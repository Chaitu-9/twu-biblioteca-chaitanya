package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    @Test
    public void ifNoBookIsAvailableInLibrary() {
        ArrayList<Book> booksList = new ArrayList<Book>();
        Library library = new Library(booksList);

        int actual = library.availableBooksCount();

        assertThat(actual, is(equalTo(0)));
    }
}