package com.twu.biblioteca;


import java.util.ArrayList;
public class Library {

    ArrayList<Book> availableBooksList;
    ArrayList<Movie> availableMoviesList;
    BibliotecaView bibliotecaView;

    public Library(ArrayList availableBooksList, ArrayList<Movie> availableMoviesList, BibliotecaView bibliotecaView) {
        this.availableBooksList = availableBooksList;
        this.availableMoviesList = availableMoviesList;
        this.bibliotecaView = bibliotecaView;
    }

    public void displayAvailableBooks(){
        for (int x = 0; x < availableBooksList.size(); x++)
            bibliotecaView.display((x + 1 + " " + availableBooksList.get(x)));
    }

    public int availableBooksCount() {
        return availableBooksList.size();
    }

    public void addBook(ArrayList<Book> bookList, Book book ){
        bookList.add(book);
    }
    public Book removeBook(ArrayList<Book> bookList, int bookNumber){
        return bookList.remove(bookNumber);
    }

    public void addMovie(ArrayList<Movie> movieList, Movie movie ){
        movieList.add(movie);
    }

    public Movie removeMovie(ArrayList<Movie> movieList, int movieNumber){
        return movieList.remove(movieNumber);
    }

    public void displayAvailableMovies() {
        for (int x = 0; x < availableMoviesList.size(); x++)
            bibliotecaView.display((x + 1 + " " + availableMoviesList.get(x)));
    }
}
