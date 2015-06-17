package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


    public class LibrarianTest {

        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        @Before
        public void setUp() {
            System.setOut(new PrintStream(outContent));
        }

        @Test
        public void shouldCheckoutParticularBook(){
        ArrayList<Book> availableBooksList = new ArrayList<Book>();
        BibliotecaView view = new BibliotecaView(null);
        ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
        Library library = new Library(availableBooksList,checkedoutBookList,view);
        Librarian librarian = new Librarian(availableBooksList,checkedoutBookList,library, view);

        availableBooksList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
        availableBooksList.add(new Book("The Hobbit", "Tolkein", "2001"));
        availableBooksList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));

        librarian.checkOutBook("Harry Potter");


        assertThat(outContent.toString(),is("Thank you! Enjoy the book\n"));
        }

        @Test
        public void shouldPrintErrorMessageIfCheckingOutUnavailableBook(){
            ArrayList<Book> availableBooksList = new ArrayList<Book>();
            BibliotecaView view = new BibliotecaView(null);
            ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
            Library library = new Library(availableBooksList,checkedoutBookList,view);
            Librarian librarian = new Librarian(availableBooksList,checkedoutBookList,library, view);

            availableBooksList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
            availableBooksList.add(new Book("The Hobbit", "Tolkein", "2001"));
            availableBooksList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));

            librarian.checkOutBook("Prince of Persia");


            assertThat(outContent.toString(),is("That book is not available.\n"));
        }


    }
