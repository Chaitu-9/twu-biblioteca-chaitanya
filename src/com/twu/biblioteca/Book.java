package com.twu.biblioteca;

public class Book {
    String bookName, author, yearOfPublication;

    public Book(String bookName, String author, String yearOfPublication) {
        this.bookName = bookName;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }


    @Override
    public String toString() {
        return "Book Name : " + bookName + " Author : " + author + " yearOfPublication : " + yearOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return !(bookName != null ? !bookName.equals(book.bookName) : book.bookName != null);

    }

    @Override
    public int hashCode() {
        return bookName != null ? bookName.hashCode() : 0;
    }
}
