package com.twu.biblioteca;

import java.util.ArrayList;

public class BiblotecaApp {
    public static void main(String args[]){
        ArrayList<Book> booksList = new ArrayList<Book>();
        booksList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
        booksList.add(new Book("The Hobbit", "Tolkein", "2001"));
        booksList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));
        Library library = new Library(booksList);

        Options options = new Options(library);
        options.start();
    }
}
