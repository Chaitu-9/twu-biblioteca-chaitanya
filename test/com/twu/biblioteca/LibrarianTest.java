package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
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
        ArrayList<Movie> availableMoviesList = new ArrayList<Movie>();
        BibliotecaView view = new BibliotecaView(null);
        ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
        Library library = new Library(availableBooksList,availableMoviesList,view);
        Librarian librarian = new Librarian(availableBooksList,checkedoutBookList,library, view, null, null, null);

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

            availableBooksList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
            availableBooksList.add(new Book("The Hobbit", "Tolkein", "2001"));
            availableBooksList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));
            ArrayList<Movie> availableMoviesList = null;
            Library library = new Library(availableBooksList,availableMoviesList,view);
            Librarian librarian = new Librarian(availableBooksList,checkedoutBookList,library, view, null, null, null);

            librarian.checkOutBook("Prince of Persia");


            assertThat(outContent.toString(),is("That book is not available.\n"));
        }

        @Test
        public void shouldreturnParticularBook(){
            ArrayList<Book> availableBooksList = new ArrayList<Book>();
            BibliotecaView view = new BibliotecaView(null);
            ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
            Library library = new Library(availableBooksList,null,view);
            Librarian librarian = new Librarian(availableBooksList,checkedoutBookList,library, view, null, null, null);
            availableBooksList.add(new Book("The Hobbit", "Tolkein", "2001"));
            availableBooksList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));
            checkedoutBookList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));

            librarian.returnBook("Harry Potter");


            assertThat(outContent.toString(),is("Thank you for returning the book.\n"));
        }


        @Test
        public void shouldreturnErrorMessageIfParticularBookIsNotValid(){
            ArrayList<Book> bookList = new ArrayList<Book>();
            bookList.add(new Book("The Hobbit", "Tolkein", "2001"));
            bookList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));
            ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
            checkedoutBookList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
            BibliotecaView view = new BibliotecaView(null);
            Library library = new Library(bookList,null,view);
            Librarian librarian = new Librarian(bookList,checkedoutBookList,library, view, null, null, null);

            librarian.returnBook("Prince of Persia");


            assertThat(outContent.toString(),is("That is not a valid book to return.\n"));
        }

        @Test
        public void shouldCheckoutParticularMovie(){
            ArrayList<Book> availableBooksList = new ArrayList<Book>();
            ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
            ArrayList<Movie> availableMoviesList = new ArrayList<Movie>();
            ArrayList<Movie> checkedoutMoviesList = new ArrayList<Movie>();
            BibliotecaView view = new BibliotecaView(null);
            Library library = new Library(availableBooksList,availableMoviesList,view);
            Librarian librarian = new Librarian(availableBooksList,checkedoutBookList,library, view, availableMoviesList, null, checkedoutMoviesList);

            availableMoviesList.add(new Movie("Inception",2010,"Nolan", 8.8));
            availableMoviesList.add(new Movie("Matrix",1990, "Andy", 8.7));
            availableMoviesList.add(new Movie("Dark Knight",2008 , "Nolan", 9.0));

            librarian.checkOutMovie("Inception");


            assertThat(outContent.toString(),is("Thank you! Enjoy the Movie\n"));
        }

        @Test
        public void shouldDisplayErrorMessageIfCheckingoutUnavailableMovie(){
            ArrayList<Book> availableBooksList = new ArrayList<Book>();
            ArrayList<Movie> availableMoviesList = new ArrayList<Movie>();
            BibliotecaView view = new BibliotecaView(null);

            availableMoviesList.add(new Movie("Inception",2010,"Nolan", 8.8));
            availableMoviesList.add(new Movie("Matrix",1990, "Andy", 8.7));
            availableMoviesList.add(new Movie("Dark Knight",2008 , "Nolan", 9.0));
            Library library = new Library(availableBooksList,availableMoviesList,view);
            Librarian librarian = new Librarian(null,null,library, view, availableMoviesList, null, null);

            librarian.checkOutMovie("Harry Potter");

            assertEquals(outContent.toString(), "That movie is not available.\n");
        }

        @Test
        public void shouldReturnParticularMovie(){
            ArrayList<Book> availableBooksList = new ArrayList<Book>();
            ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
            ArrayList<Movie> availableMoviesList = new ArrayList<Movie>();
            ArrayList<Movie> checkedoutMoviesList = new ArrayList<Movie>();
            BibliotecaView view = new BibliotecaView(null);
            Library library = new Library(availableBooksList,availableMoviesList,view);
            Librarian librarian = new Librarian(availableBooksList,checkedoutBookList,library, view, availableMoviesList, null, checkedoutMoviesList);

            availableMoviesList.add(new Movie("Inception",2010,"Nolan", 8.8));
            availableMoviesList.add(new Movie("Matrix",1990, "Andy", 8.7));
            checkedoutMoviesList.add(new Movie("Dark Knight",2008 , "Nolan", 9.0));

            librarian.returnMovie("Dark Knight");


            assertThat(outContent.toString(),is("Thank you for returning the movie.\n"));
        }

        @Test
        public void shouldDisplayErrorMessageIfMovieReturnedIsNotValid(){
            ArrayList<Book> availableBooksList = new ArrayList<Book>();
            ArrayList<Book> checkedoutBookList = new ArrayList<Book>();
            ArrayList<Movie> availableMoviesList = new ArrayList<Movie>();
            ArrayList<Movie> checkedoutMoviesList = new ArrayList<Movie>();
            BibliotecaView view = new BibliotecaView(null);
            Library library = new Library(availableBooksList,availableMoviesList,view);
            Librarian librarian = new Librarian(availableBooksList,checkedoutBookList,library, view, availableMoviesList, null, checkedoutMoviesList);

            availableMoviesList.add(new Movie("Inception",2010,"Nolan", 8.8));
            availableMoviesList.add(new Movie("Matrix",1990, "Andy", 8.7));
            checkedoutMoviesList.add(new Movie("Dark Knight",2008 , "Nolan", 9.0));

            librarian.returnMovie("Jurassic Park");


            assertThat(outContent.toString(),is("That is not a valid movie to return.\n"));
        }

    }
