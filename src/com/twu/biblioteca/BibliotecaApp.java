package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        ArrayList<Book> availableBooksList = new ArrayList<Book>();
        ArrayList<Book> checkedoutBooksList = new ArrayList<Book>();
        availableBooksList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
        availableBooksList.add(new Book("The Hobbit", "Tolkein", "2001"));
        availableBooksList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));

        ArrayList<Movie> availableMoviesList = new ArrayList<Movie>();
        ArrayList<Book> checkedoutMoviesList = new ArrayList<Book>();
        availableMoviesList.add(new Movie("Inception",2010,"Nolan", 8.8));
        availableMoviesList.add(new Movie("Matrix",1990, "Andy", 8.7));
        availableMoviesList.add(new Movie("Dark Knight",2008 , "Nolan", 9.0));

        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = new Library(availableBooksList, checkedoutBooksList, bibliotecaView);
        Librarian librarian = new Librarian(availableBooksList, checkedoutBooksList, library, bibliotecaView, null, null);
        Options options = new Options(library, bibliotecaView, librarian);
        options.start();
        options.selectOption();
    }
}
