package com.twu.biblioteca;

import java.util.Scanner;

//Display options for user
public class Options {
    Library library;
    Scanner input;
    private BibliotecaView bibliotecaView;
    private Librarian librarian;

    public Options(Library library, BibliotecaView bibliotecaView, Librarian librarian){
        this.library = library;
        this.bibliotecaView = bibliotecaView;
        this.librarian = librarian;
    }

    public void start(){
        welcome();
        displayOptions();
    }
    public void welcome(){
        System.out.print(Messages.WELCOME_MESSAGE);
    }

    public void displayOptions(){
        System.out.print("\n1. " + Messages.LIST_BOOKS + "\n" +
                "2. " + Messages.CHECKOUT_BOOK +"\n" +
                "3. " + Messages.RETURN +"\n"+
                "4. " + Messages.CHECKOUT_MOVIE +"\n"+
                "6. " + Messages.EXIT + "\n");
    }

    public void selectOption(){
        int option;
        String name;

        do {
            option = bibliotecaView.getIntegerInput();
            switch (option) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    bibliotecaView.getStringInput();
                    name = bibliotecaView.getStringInput();
                    librarian.checkOutBook(name);
                    break;
                case 3:
                    bibliotecaView.getStringInput();
                    name = bibliotecaView.getStringInput();
                    librarian.returnBook(name);
                    break;
                case 4:
                    bibliotecaView.getStringInput();
                    name = bibliotecaView.getStringInput();
                    librarian.checkOutMovie(name);
                case 6:
                    return;
                default:
                    System.out.println("Invalid Option. Enter again : ");
                    break;
            }
        }while (option != -1);
    }
}