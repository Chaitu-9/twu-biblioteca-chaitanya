package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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
    public void shouldDisplayAvailableInLibrary() {
        ArrayList<Book> booksList = new ArrayList<Book>();
        ArrayList<Book> checkedoutBooksList = new ArrayList<Book>();
        BibliotecaView bibliotecaView = new BibliotecaView(null);
        booksList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
        booksList.add(new Book("The Hobbit", "Tolkein", "2001"));
        booksList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));
        Library library = new Library(booksList,checkedoutBooksList,bibliotecaView);

        library.displayAvailableBooks();

        assertThat(outContent.toString(), is(equalTo("1 Book Name : Harry Potter Author : J.K.Rowling yearOfPublication : 1990\n2 Book Name : The Hobbit Author : Tolkein yearOfPublication : 2001\n3 Book Name : Hound of Baskervilles Author : Doyle yearOfPublication : 1902\n")));
    }



//    @Test
//    public void shouldreturnErrorMessageIfParticularBookIsNotValid(){
//        ArrayList<Book> bookList = new ArrayList<Book>();
//        bookList.add(new Book("The Hobbit", "Tolkein", "2001"));
//        bookList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));
//        ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
//        checkedoutBookList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
//        BibliotecaView view = new BibliotecaView(null);
//        Library library = new Library(bookList,checkedoutBookList,view);
//
//        librarian.returnBook("Prince of Persia");
//
//
//        assertThat(outContent.toString(),is("That is not a valid book to return.\n"));
//    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}