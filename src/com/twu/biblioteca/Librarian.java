package com.twu.biblioteca;

import java.util.ArrayList;

public class Librarian {
    ArrayList availableBooksList,checkedoutBooksList;
    Library library;
    BibliotecaView bibliotecaView;
    public Librarian(ArrayList<Book> availableBooksList, ArrayList<Book> checkedoutBookList, Library library, BibliotecaView bibliotecaView) {
        this.availableBooksList = availableBooksList;
        this.checkedoutBooksList = checkedoutBookList;
        this.library = library;
        this.bibliotecaView = bibliotecaView;
    }

    public boolean checkOutBook(String bookName) {
        for (int bookNumber = 0; bookNumber < availableBooksList.size(); bookNumber++)
            if (availableBooksList.get(bookNumber).hashCode() == bookName.hashCode()) {
                Book book =library.removeBook(availableBooksList,bookNumber);
                library.addBook(checkedoutBooksList,book);
                bibliotecaView.display(Messages.SUCCESSFUL_CHECKOUT);
                return true;
            }
        bibliotecaView.display(Messages.UNSUCCESSFUL_CHECKOUT);
        return false;
    }

    public boolean returnBook(String bookName) {
        for (int bookNumber = 0; bookNumber < checkedoutBooksList.size(); bookNumber++)
            if (checkedoutBooksList.get(bookNumber).hashCode() == bookName.hashCode()) {
                Book book = library.removeBook(checkedoutBooksList,bookNumber);
                library.addBook(availableBooksList,book);
                bibliotecaView.display(Messages.SUCCESSFUL_RETURN);
                return true;
            }
        bibliotecaView.display(Messages.UNSUCCESSFUL_RETURN);
        return false;
    }


}
