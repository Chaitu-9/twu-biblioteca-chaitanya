package com.twu.biblioteca;


import javax.swing.text.View;
import java.util.ArrayList;

public class Library {

    ArrayList<Book> booksList;
    BibliotecaView bibliotecaView;

    public Library(ArrayList booksList, BibliotecaView bibliotecaView){
        this.booksList = booksList;
        this.bibliotecaView = bibliotecaView;
    }

    public ArrayList<Book> availableListOfBooks() {
        return booksList;
    }

    public void displayAvailableBooks(){
        for(int x =0; x<booksList.size(); x++)
            bibliotecaView.display((x + 1 + " " + booksList.get(x)));
    }

    public int availableBooksCount() {
        return booksList.size();
    }


}
