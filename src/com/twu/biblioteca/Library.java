package com.twu.biblioteca;


import java.util.ArrayList;

public class Library {

    ArrayList<Book> booksList;

    public Library(ArrayList booksList){
        this.booksList = booksList;
    }

    public ArrayList<Book> availableListOfBooks() {
        return booksList;
    }


    public int availableBooksCount() {
        return booksList.size();
    }

}
