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
import java.util.HashMap;
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
        Options options = new Options(library, null, null, null, null, null);

        options.start();

        String actualMessage = Messages.WELCOME_MESSAGE + "\n1. " + Messages.LIST_BOOKS + "\n" +
                "2. "+ Messages.CHECKOUT_BOOK +"\n" +
                "3. " + Messages.RETURN_BOOK +"\n"+
                "4. " + Messages.LIST_MOVIES +"\n"+
                "5. " + Messages.CHECKOUT_MOVIE +"\n"+
                "6. " + Messages.RETURN_MOVIE +"\n"+
                "7. " + Messages.USER_DETAILS +"\n"+
                "8. " + Messages.CHECKOUT_HISTORY +"\n"+
                "10. " + Messages.EXIT + "\n";
        String expectedMessage = outContent.toString();

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        ArrayList<Book> booksList = new ArrayList<Book>();
        Library library = new Library(booksList, null, null);
        Options options = new Options(library, null, null, null, null, null);

        String actualMessage = Messages.WELCOME_MESSAGE;
        options.welcome();
        String expectedMessage = outContent.toString();

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldPrintAvailableOptions(){
        ArrayList<Book> booksList = new ArrayList<Book>();
        Library library = new Library(booksList,null, null);
        Options options = new Options(library, null, null, null, null, null);

        String actualMessage = "\n1. " + Messages.LIST_BOOKS + "\n" +
                "2. "+ Messages.CHECKOUT_BOOK +"\n" +
                "3. " + Messages.RETURN_BOOK +"\n"+
                "4. " + Messages.LIST_MOVIES +"\n"+
                "5. " + Messages.CHECKOUT_MOVIE +"\n"+
                "6. " + Messages.RETURN_MOVIE +"\n"+
                "7. " + Messages.USER_DETAILS +"\n"+
                "8. " + Messages.CHECKOUT_HISTORY +"\n"+
                "10. " + Messages.EXIT + "\n";
        options.displayOptions();
        String expectedMessage = outContent.toString();

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldDisplayAvailableBooksWhenFirstOptionIsSelected(){
        inContent = new ByteArrayInputStream("1\n10".getBytes());

        ArrayList<Book> booksList = new ArrayList<Book>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = mock(Library.class);
        Options options = new Options(library,bibliotecaView, null, null, null, null);

        options.selectOption();


        verify(library, times(1)).displayAvailableBooks();

    }

    @Test
    public void shouldCallCheckOutFunctionWhenSecondOptionIsSelected(){
        inContent = new ByteArrayInputStream("2\nravi\nqwerty\nHarry Potter\n10".getBytes());

        ArrayList<Book> availableBooksList = new ArrayList<Book>();
        ArrayList<Movie> checkedoutBooksList = new ArrayList<Movie>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = new Library(availableBooksList,checkedoutBooksList,bibliotecaView);
        Librarian librarian =mock(Librarian.class);
        HashMap<String,String> validation = new HashMap<String, String>();
        validation.put("ravi","qwerty");
        HashMap<String,User> userRegister = new HashMap<String, User>();
        userRegister.put("ravi",new User("ravi","ravi123@gmail.com","9876543210"));
        userRegister.put("surya",new User("surya","surya123@gmail.com","8971821321"));
        userRegister.put("admin",new User("admin","admin123@gmail.com","9878721827"));
        Login login = new Login(validation,userRegister);
        CheckoutRegister checkoutRegister = new CheckoutRegister();
        checkoutRegister.checkedOutDetails("ravi","Harry Potter");
        Options options = new Options(library,bibliotecaView,librarian, login, null, checkoutRegister);

        options.selectOption();
        String bookName = "Harry Potter";

        verify(librarian,times(1)).checkOutBook(bookName);
    }

    @Test
    public void shouldCallReturnBookFunctionWhenThirdOptionIsSelected(){
        inContent = new ByteArrayInputStream("3\nravi\nqwerty\nHarry Potter\n10".getBytes());

        ArrayList<Book> availableBooksList = new ArrayList<Book>();
        ArrayList<Movie> checkedoutBooksList = new ArrayList<Movie>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = new Library(availableBooksList,checkedoutBooksList,bibliotecaView);
        Librarian librarian =mock(Librarian.class);
        HashMap<String,String> validation = new HashMap<String, String>();
        validation.put("ravi","qwerty");
        HashMap<String,User> userRegister = new HashMap<String, User>();
        userRegister.put("ravi",new User("ravi","ravi123@gmail.com","9876543210"));
        userRegister.put("surya",new User("surya","surya123@gmail.com","8971821321"));
        userRegister.put("admin",new User("admin","admin123@gmail.com","9878721827"));
        Login login = new Login(validation,userRegister);
        CheckoutRegister checkoutRegister = new CheckoutRegister();
        checkoutRegister.checkedOutDetails("ravi","Harry Potter");
        Options options = new Options(library,bibliotecaView,librarian, login, null, checkoutRegister);

        options.selectOption();
        String bookName = "Harry Potter";

        verify(librarian,times(1)).returnBook(bookName);
    }

    @Test
    public void shouldDisplayAvailableMoviesWhenFourthOptionIsSelected(){
        inContent = new ByteArrayInputStream("4\n10".getBytes());

        ArrayList<Book> booksList = new ArrayList<Book>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = mock(Library.class);
        Options options = new Options(library,bibliotecaView, null, null, null, null);

        options.selectOption();


        verify(library, times(1)).displayAvailableMovies();

    }

    @Test
    public void shouldCallCheckOutMovieFunctionWhenFifthOptionIsSelected(){
        inContent = new ByteArrayInputStream("5\nravi\nqwerty\nHarry Potter\n10".getBytes());

        ArrayList<Book> availableBooksList = new ArrayList<Book>();
        ArrayList<Movie> checkedoutBooksList = new ArrayList<Movie>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = new Library(availableBooksList,checkedoutBooksList,bibliotecaView);
        Librarian librarian =mock(Librarian.class);
        HashMap<String,String> validation = new HashMap<String, String>();
        validation.put("ravi","qwerty");
        HashMap<String,User> userRegister = new HashMap<String, User>();
        userRegister.put("ravi",new User("ravi","ravi123@gmail.com","9876543210"));
        userRegister.put("surya",new User("surya","surya123@gmail.com","8971821321"));
        userRegister.put("admin",new User("admin","admin123@gmail.com","9878721827"));
        Login login = new Login(validation,userRegister);
        CheckoutRegister checkoutRegister = new CheckoutRegister();
        checkoutRegister.checkedOutDetails("ravi","Harry Potter");
        Options options = new Options(library,bibliotecaView,librarian, login, null, checkoutRegister);

        options.selectOption();
        String movieName = "Harry Potter";

        verify(librarian,times(1)).checkOutMovie(movieName);
    }

    @Test
    public void shouldCallReturnMovieFunctionWhenSixthOptionIsSelected(){
        inContent = new ByteArrayInputStream("6\nravi\nqwerty\nHarry Potter\n10".getBytes());

        ArrayList<Book> availableBooksList = new ArrayList<Book>();
        ArrayList<Movie> checkedoutBooksList = new ArrayList<Movie>();
        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = new Library(availableBooksList,checkedoutBooksList,bibliotecaView);
        Librarian librarian =mock(Librarian.class);
        HashMap<String,String> validation = new HashMap<String, String>();
        validation.put("ravi","qwerty");
        HashMap<String,User> userRegister = new HashMap<String, User>();
        userRegister.put("ravi",new User("ravi","ravi123@gmail.com","9876543210"));
        userRegister.put("surya",new User("surya","surya123@gmail.com","8971821321"));
        userRegister.put("admin",new User("admin","admin123@gmail.com","9878721827"));
        Login login = new Login(validation,userRegister);
        CheckoutRegister checkoutRegister = new CheckoutRegister();
        checkoutRegister.checkedOutDetails("ravi","Harry Potter");
        Options options = new Options(library,bibliotecaView,librarian, login, null, checkoutRegister);

        options.selectOption();
        String movieName = "Harry Potter";

        verify(librarian,times(1)).returnMovie(movieName);
    }

    @Test
    public void shouldCallUserDetailsFunctionWhenSeventhOptionIsSelected(){
        inContent = new ByteArrayInputStream("7\n10".getBytes());

        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        HashMap<String,String> validation = new HashMap<String, String>();
        validation.put("ravi","qwerty");
        validation.put("surya","asdfgh");
        validation.put("admin","zxcvbn");
        Login login = new Login(validation, null);
        User user = new User("ravi","ravi123@gmail.com","9876543210");
        Librarian librarian =new Librarian(null,null,null,bibliotecaView,null,null,null);
        Options options = new Options(null,bibliotecaView,librarian, login, user, null);
        String actualValue = user.toString();
        String expectedValue = "name : ravi\n emailAddress : ravi123@gmail.com\n phoneNumber : 9876543210";

        assertThat(actualValue, is(expectedValue));
    }

    @Test
    public void shouldExitWhenTenthOptionIsSelected() {
        inContent = new ByteArrayInputStream("10".getBytes());

        Scanner input = new Scanner(inContent);
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = mock(Library.class);
        Options options = new Options(library,bibliotecaView, null, null, null, null);

        options.selectOption();
        exit.expectSystemExitWithStatus(0);
        System.exit(0);
    }


    @After
    public void cleanUp(){
        System.setOut(null);
    }
}
