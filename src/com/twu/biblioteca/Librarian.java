package com.twu.biblioteca;

import java.util.ArrayList;

public class Librarian {
    ArrayList availableBooksList,checkedoutBooksList,availableMoviesList;
    Library library;
    BibliotecaView bibliotecaView;
    Movie movie;
    public Librarian(ArrayList<Book> availableBooksList, ArrayList<Book> checkedoutBookList, Library library, BibliotecaView bibliotecaView, ArrayList<Movie> availableMoviesList, Movie movie) {
        this.availableBooksList = availableBooksList;
        this.checkedoutBooksList = checkedoutBookList;
        this.library = library;
        this.bibliotecaView = bibliotecaView;
        this.movie = movie;
        this.availableMoviesList = availableMoviesList;
    }

    public boolean checkOutBook(String bookName) {
        for (int bookNumber = 0; bookNumber < availableBooksList.size(); bookNumber++)
            if (availableBooksList.get(bookNumber).hashCode() == bookName.hashCode()) {
                Book book =library.removeBook(availableBooksList, bookNumber);
                library.addBook(checkedoutBooksList,book);
                bibliotecaView.display(Messages.SUCCESSFUL_CHECKOUT_BOOK);
                return true;
            }
        bibliotecaView.display(Messages.UNSUCCESSFUL_CHECKOUT_BOOK);
        return false;
    }

    public boolean returnBook(String bookName) {
        for (int bookNumber = 0; bookNumber < checkedoutBooksList.size(); bookNumber++)
            if (checkedoutBooksList.get(bookNumber).hashCode() == bookName.hashCode()) {
                Book book = library.removeBook(checkedoutBooksList, bookNumber);
                library.addBook(availableBooksList,book);
                bibliotecaView.display(Messages.SUCCESSFUL_RETURN);
                return true;
            }
        bibliotecaView.display(Messages.UNSUCCESSFUL_RETURN);
        return false;
    }

    public boolean checkOutMovie(String movieName) {
        for (int movieNumber = 0; movieNumber < availableMoviesList.size(); movieNumber++)
            if (availableMoviesList.get(movieNumber).hashCode() == movieName.hashCode()) {
                library.removeMovie(availableMoviesList, movieNumber);
                bibliotecaView.display(Messages.SUCCESSFUL_CHECKOUT_MOVIE);
                return true;
            }
        bibliotecaView.display(Messages.UNSUCCESSFUL_CHECKOUT_MOVIE);
        return false;
    }
}
