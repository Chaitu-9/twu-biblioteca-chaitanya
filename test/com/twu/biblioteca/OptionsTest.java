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
import static org.mockito.Mockito.*;

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
        Options options = new Options(library, null);

        options.start();

        String actualMessage = Messages.WELCOME_MESSAGE + "\n1. " + Messages.LIST_BOOKS + "\n" +
                "2. "+ Messages.CHECKOUT +"\n" +
                "3. " + Messages.RETURN +"\n"+
                "4. " + Messages.EXIT + "\n";
        String expectedMessage = outContent.toString();

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldPrintWelcomeMessage(){
        ArrayList<Book> booksList = new ArrayList<Book>();
        Library library = new Library(booksList,null, null);
        Options options = new Options(library, null);

        String actualMessage = Messages.WELCOME_MESSAGE;
        options.welcome();
        String expectedMessage = outContent.toString();

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldPrintAvailableOptions(){
        ArrayList<Book> booksList = new ArrayList<Book>();
        Library library = new Library(booksList,null, null);
        Options options = new Options(library, null);

        String actualMessage = "\n1. " + Messages.LIST_BOOKS + "\n" +
                "2. "+ Messages.CHECKOUT +"\n" +
                "3. " + Messages.RETURN +"\n"+
                "4. " + Messages.EXIT + "\n";
        options.displayOptions();
        String expectedMessage = outContent.toString();

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldDisplayAvailableBooksWhenFirstOptionIsSelected(){
        inContent = new ByteArrayInputStream("1\n4".getBytes());

        ArrayList<Book> booksList = new ArrayList<Book>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = mock(Library.class);
        Options options = new Options(library,bibliotecaView);

        options.selectOption();


        verify(library, times(1)).displayAvailableBooks();

    }

    @Test
    public void shouldCallCheckOutFunctionWhenSecondOptionIsSelected(){
        inContent = new ByteArrayInputStream("2\nHarry Potter\n4".getBytes());

        ArrayList<Book> booksList = new ArrayList<Book>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = mock(Library.class);
        Options options = new Options(library,bibliotecaView);

        options.selectOption();
        String bookName = "Harry Potter";

        verify(library,times(1)).checkOutBook(bookName);
    }

    @Test
    public void shouldCallReturnFunctionWhenThirdOptionIsSelected(){
        inContent = new ByteArrayInputStream("3\nHarry Potter\n4".getBytes());

        ArrayList<Book> booksList = new ArrayList<Book>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = mock(Library.class);
        Options options = new Options(library,bibliotecaView);

        options.selectOption();
        String bookName = "Harry Potter";

        verify(library,times(1)).returnBook(bookName);
    }

    @Test
    public void shouldExitWhenFourthOptionIsSelected() {
        inContent = new ByteArrayInputStream("4".getBytes());

        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = mock(Library.class);
        Options options = new Options(library,bibliotecaView);

        options.selectOption();
        exit.expectSystemExitWithStatus(0);
        System.exit(0);
    }


    @After
    public void cleanUp(){
        System.setOut(null);
    }
}
