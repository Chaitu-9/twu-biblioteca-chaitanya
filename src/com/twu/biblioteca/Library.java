package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    ArrayList<Book> availableBooksList;
    ArrayList<Book> checkedoutBooksList;
    BibliotecaView bibliotecaView;
    Scanner bookName;

    public Library(ArrayList availableBooksList, ArrayList checkedoutBooksList, BibliotecaView bibliotecaView) {
        this.availableBooksList = availableBooksList;
        this.checkedoutBooksList = checkedoutBooksList;
        this.bibliotecaView = bibliotecaView;
    }

    public void displayAvailableBooks(){
        for (int x = 0; x < availableBooksList.size(); x++)
            bibliotecaView.display((x + 1 + " " + availableBooksList.get(x)));
    }

    public int availableBooksCount() {
        return availableBooksList.size();
    }


    public boolean checkOutBook(String bookName) {
        for (int x = 0; x < availableBooksList.size(); x++)
            if (availableBooksList.get(x).hashCode() == bookName.hashCode()) {
                Book book = availableBooksList.remove(x);
                checkedoutBooksList.add(book);
                bibliotecaView.display(Messages.SUCCESSFUL_CHECKOUT);
                return true;
            }
        bibliotecaView.display(Messages.UNSUCCESSFUL_CHECKOUT);
        return false;
    }

    public boolean returnBook(String bookName) {
        for (int x = 0; x < checkedoutBooksList.size(); x++)
            if (checkedoutBooksList.get(x).hashCode() == bookName.hashCode()) {
                Book book = checkedoutBooksList.remove(x);
                availableBooksList.add(book);
                bibliotecaView.display(Messages.SUCCESSFUL_RETURN);
                return true;
            }
        bibliotecaView.display(Messages.UNSUCCESSFUL_RETURN);
        return false;
    }
}
