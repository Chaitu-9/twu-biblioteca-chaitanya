package com.twu.biblioteca;

import com.twu.biblioteca.Book;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldPrintFirstBookDetails(){
        Book book = new Book("Harry Potter","Rowling","1990");

        String actualString = "Book Name : Harry Potter Author : Rowling yearOfPublication : 1990";

        assertThat(actualString,is(book.toString()));
    }

}