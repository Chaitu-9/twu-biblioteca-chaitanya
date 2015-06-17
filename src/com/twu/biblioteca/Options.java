package com.twu.biblioteca;

import java.util.Scanner;

//Display options for user
public class Options {
    Library library;
    Scanner input;
    private BibliotecaView bibliotecaView;

    public Options(Library library, BibliotecaView bibliotecaView){
        this.library = library;
        this.bibliotecaView = bibliotecaView;
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
                "2. " + Messages.CHECKOUT +"\n" +
                "3. " + Messages.RETURN +"\n"+
                "4. " + Messages.EXIT + "\n");
    }

    public void selectOption(){
        int option;
        String bookName;

        do {
            option = bibliotecaView.getIntegerInput();
            switch (option) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    bibliotecaView.getStringInput();
                    bookName = bibliotecaView.getStringInput();
                    library.checkOutBook(bookName);
                    break;
                case 3:
                    bibliotecaView.getStringInput();
                    bookName = bibliotecaView.getStringInput();
                    library.returnBook(bookName);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Option. Enter again : ");
                    break;
            }
        }while (option != -1);
    }
}