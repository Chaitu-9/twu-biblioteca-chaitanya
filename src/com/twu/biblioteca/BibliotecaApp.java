package com.twu.biblioteca;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        ArrayList<Book> booksList = new ArrayList<Book>();
        booksList.add(new Book("Harry Potter", "J.K.Rowling", "1990"));
        booksList.add(new Book("The Hobbit", "Tolkein", "2001"));
        booksList.add(new Book("Hound of Baskervilles", "Doyle", "1902"));
        BibliotecaView bibliotecaView = new BibliotecaView(input);
        Library library = new Library(booksList, bibliotecaView);

        Options options = new Options(library);
        options.start();

        int option;

        do {
            option = bibliotecaView.getInput();
        switch (option) {
            case 1:
                library.displayAvailableBooks();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option. Enter again : ");
                break;
        }
        }while (option != -1);

    }
}
