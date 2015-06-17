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

        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = new Library(availableBooksList, checkedoutBooksList, bibliotecaView);

        Options options = new Options(library, bibliotecaView, null);
        options.start();
        options.selectOption();
    }
}
