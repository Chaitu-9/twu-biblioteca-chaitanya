package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class OptionsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inContent = null;


    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldcallWelcomeAndDisplayOptionsMethod(){
        Library library = new Library(null,null, null);
        Options options = new Options(library, null, null);

        options.start();

        String actualMessage = Messages.WELCOME_MESSAGE + "\n1. " + Messages.LIST_BOOKS + "\n" +
                "2. "+ Messages.CHECKOUT_BOOK +"\n" +
                "3. " + Messages.RETURN_BOOK +"\n"+
                "4. " + Messages.LIST_MOVIES +"\n"+
                "5. " + Messages.CHECKOUT_MOVIE +"\n"+
                "6. " + Messages.RETURN_MOVIE +"\n"+
                "7. " + Messages.EXIT + "\n";
        String expectedMessage = outContent.toString();

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        ArrayList<Book> booksList = new ArrayList<Book>();
        Library library = new Library(booksList, null, null);
        Options options = new Options(library, null, null);

        String actualMessage = Messages.WELCOME_MESSAGE;
        options.welcome();
        String expectedMessage = outContent.toString();

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldPrintAvailableOptions(){
        ArrayList<Book> booksList = new ArrayList<Book>();
        Library library = new Library(booksList,null, null);
        Options options = new Options(library, null, null);

        String actualMessage = "\n1. " + Messages.LIST_BOOKS + "\n" +
                "2. "+ Messages.CHECKOUT_BOOK +"\n" +
                "3. " + Messages.RETURN_BOOK +"\n"+
                "4. " + Messages.LIST_MOVIES +"\n"+
                "5. " + Messages.CHECKOUT_MOVIE +"\n"+
                "6. " + Messages.RETURN_MOVIE +"\n"+
                "7. " + Messages.EXIT + "\n";
        options.displayOptions();
        String expectedMessage = outContent.toString();

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldDisplayAvailableBooksWhenFirstOptionIsSelected(){
        inContent = new ByteArrayInputStream("1\n7".getBytes());

        ArrayList<Book> booksList = new ArrayList<Book>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = mock(Library.class);
        Options options = new Options(library,bibliotecaView, null);

        options.selectOption();


        verify(library, times(1)).displayAvailableBooks();

    }

    @Test
    public void shouldCallCheckOutFunctionWhenSecondOptionIsSelected(){
        inContent = new ByteArrayInputStream("2\nHarry Potter\n7".getBytes());

        ArrayList<Book> availableBooksList = new ArrayList<Book>();
        ArrayList<Movie> checkedoutBooksList = new ArrayList<Movie>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = new Library(availableBooksList,checkedoutBooksList,bibliotecaView);
        Librarian librarian =mock(Librarian.class);
        Options options = new Options(library,bibliotecaView,librarian);

        options.selectOption();
        String bookName = "Harry Potter";

        verify(librarian,times(1)).checkOutBook(bookName);
    }

    @Test
    public void shouldCallReturnBookFunctionWhenThirdOptionIsSelected(){
        inContent = new ByteArrayInputStream("3\nHarry Potter\n7".getBytes());

        ArrayList<Book> availableBooksList = new ArrayList<Book>();
        ArrayList<Movie> checkedoutBooksList = new ArrayList<Movie>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = new Library(availableBooksList,checkedoutBooksList,bibliotecaView);
        Librarian librarian =mock(Librarian.class);
        Options options = new Options(library,bibliotecaView, librarian);

        options.selectOption();
        String bookName = "Harry Potter";

        verify(librarian,times(1)).returnBook(bookName);
    }

    @Test
    public void shouldDisplayAvailableMoviesWhenFourthOptionIsSelected(){
        inContent = new ByteArrayInputStream("4\n7".getBytes());

        ArrayList<Book> booksList = new ArrayList<Book>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = mock(Library.class);
        Options options = new Options(library,bibliotecaView, null);

        options.selectOption();


        verify(library, times(1)).displayAvailableMovies();

    }

    @Test
    public void shouldCallCheckOutMovieFunctionWhenFifthOptionIsSelected(){
        inContent = new ByteArrayInputStream("5\nHarry Potter\n7".getBytes());

        ArrayList<Book> availableBooksList = new ArrayList<Book>();
        ArrayList<Movie> checkedoutBooksList = new ArrayList<Movie>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = new Library(availableBooksList,checkedoutBooksList,bibliotecaView);
        Librarian librarian =mock(Librarian.class);
        Options options = new Options(library,bibliotecaView,librarian);

        options.selectOption();
        String movieName = "Harry Potter";

        verify(librarian,times(1)).checkOutMovie(movieName);
    }

    @Test
    public void shouldCallReturnMovieFunctionWhenSixthOptionIsSelected(){
        inContent = new ByteArrayInputStream("6\nHarry Potter\n7".getBytes());

        ArrayList<Book> availableBooksList = new ArrayList<Book>();
        ArrayList<Movie> checkedoutBooksList = new ArrayList<Movie>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = new Library(availableBooksList,checkedoutBooksList,bibliotecaView);
        Librarian librarian =mock(Librarian.class);
        Options options = new Options(library,bibliotecaView, librarian);

        options.selectOption();
        String movieName = "Harry Potter";

        verify(librarian,times(1)).returnMovie(movieName);
    }


    @Test
    public void shouldExitWhenSeventhOptionIsSelected() {
        inContent = new ByteArrayInputStream("7".getBytes());

        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = mock(Library.class);
        Options options = new Options(library,bibliotecaView, null);

        options.selectOption();
        exit.expectSystemExitWithStatus(0);
        System.exit(0);
    }


    @After
    public void cleanUp(){
        System.setOut(null);
    }
}
