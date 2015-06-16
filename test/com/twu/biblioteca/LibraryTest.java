package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    @Test
    public void ifNoBookIsAvailableInLibrary() {
        ArrayList<Book> booksList = new ArrayList<Book>();
        Library library = new Library(booksList, null);

        int actual = library.availableBooksCount();

        assertThat(actual, is(equalTo(0)));
    }

    @Test
    public void showAvailableBooksinLibrary() {
        ArrayList<Book> booksList = new ArrayList<Book>();
        booksList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
        booksList.add(new Book("The Hobbit", "Tolkein", "2001"));
        booksList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));
        Library library = new Library(booksList, null);

        ArrayList<Book> actualBooksList = library.availableListOfBooks();
        ArrayList<Book> expectedBooksList = new ArrayList<Book>();
        expectedBooksList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
        expectedBooksList.add(new Book("The Hobbit", "Tolkein", "2001"));
        expectedBooksList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));

        assertThat(actualBooksList, is(expectedBooksList));
    }
}