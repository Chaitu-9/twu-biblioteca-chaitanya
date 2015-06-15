package com.twu.biblioteca;


import java.util.ArrayList;

public class Library {

    ArrayList<Book> booksList = new ArrayList<Book>();

    public Library(){
    }

    public ArrayList<Book> availableListOfBooks() {
        return booksList;
    }


    public int availableBooksCount() {
        return booksList.size();
    }

}
