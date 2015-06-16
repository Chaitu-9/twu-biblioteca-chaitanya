package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OptionsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintWelcomeMessage(){
        ArrayList<Book> booksList = new ArrayList<Book>();
        Library library = new Library(booksList,null, null);
        Options options = new Options(library);

        String actualMessage = Messages.WELCOME_MESSAGE;
        options.welcome();
        String expectedMessage = outContent.toString();

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldPrintAvailableOptions(){
        ArrayList<Book> booksList = new ArrayList<Book>();
        Library library = new Library(booksList,null, null);
        Options options = new Options(library);

        String actualMessage = "\n1. " + Messages.LIST_BOOKS + "\n" +
                "2. "+ Messages.CHECKOUT +"\n" +
                "3. " + Messages.RETURN +"\n"+
                "4. " + Messages.EXIT + "\n";
        options.displayOptions();
        String expectedMessage = outContent.toString();

        assertThat(actualMessage, is(expectedMessage));
    }

    @After
    public void cleanUp(){
        System.setOut(null);
    }
}
