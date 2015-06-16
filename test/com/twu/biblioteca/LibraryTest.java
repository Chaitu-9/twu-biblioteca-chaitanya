package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LibraryTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void ifNoBookIsAvailableInLibrary() {
        ArrayList<Book> booksList = new ArrayList<Book>();
        Library library = new Library(booksList,null, null);

        int actual = library.availableBooksCount();

        assertThat(actual, is(equalTo(0)));
    }

    @Test
    public void showAvailableBooksinLibrary() {
        ArrayList<Book> booksList = new ArrayList<Book>();
        booksList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
        booksList.add(new Book("The Hobbit", "Tolkein", "2001"));
        booksList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));
        Library library = new Library(booksList,null, null);

        ArrayList<Book> actualBooksList = library.availableListOfBooks();
        ArrayList<Book> expectedBooksList = new ArrayList<Book>();
        expectedBooksList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
        expectedBooksList.add(new Book("The Hobbit", "Tolkein", "2001"));
        expectedBooksList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));

        assertThat(actualBooksList, is(expectedBooksList));
    }

    @Test
    public void shouldcheckOutParticularBook(){
        ArrayList<Book> bookList = new ArrayList<Book>();
        ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
        bookList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
        bookList.add(new Book("The Hobbit", "Tolkein", "2001"));
        bookList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));
        BibliotecaView view = new BibliotecaView(null);
        Library library = new Library(bookList,checkedoutBookList,view);

        library.checkOutBook("Harry Potter");

        library.displayAvailableBooks();

        assertThat(outContent.toString(),is("Thank you! Enjoy the book\n" +
                "1 Book Name : The Hobbit Author : Tolkein yearOfPublication : 2001\n" +
                "2 Book Name : Hound of Baskervilles Author : Doyle yearOfPublication : 1902\n"));
    }

    @Test
    public void shouldreturnParticularBook(){
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("The Hobbit", "Tolkein", "2001"));
        bookList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));
        ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
        checkedoutBookList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
        BibliotecaView view = new BibliotecaView(null);
        Library library = new Library(bookList,checkedoutBookList,view);

        library.returnBook("Harry Potter");

        library.displayAvailableBooks();

        assertThat(outContent.toString(),is("Thank you for returning the book.\n" +
                "1 Book Name : The Hobbit Author : Tolkein yearOfPublication : 2001\n" +
                "2 Book Name : Hound of Baskervilles Author : Doyle yearOfPublication : 1902\n" +
                "3 Book Name : Harry Potter Author : J.K.Rowling yearOfPublication : 1990\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}