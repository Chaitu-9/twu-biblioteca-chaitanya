package com.twu.biblioteca;

import com.twu.biblioteca.Book;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldPrintFirstBookDetails(){
        Book book = new Book("Harry Potter","Rowling","1990");

        String actualString = "Book Name : Harry Potter Author : Rowling yearOfPublication : 1990";

        assertThat(actualString,is(book.toString()));
    }
    @Test
    public void testForReflexivity() {
        Book firstObject= new Book(null,null,null);

        assertEquals(firstObject, firstObject);
    }

    @Test
    public void testForComparingNullObjectsWithABook() {
        Book firstObject= new Book(null,null,null);


        assertThat(firstObject, not(equalTo(null)));
    }

    @Test
    public void testForEquality() {
        Book firstObject = new Book(null,null,null);
        Book secondObject = new Book(null,null,null);

        assertEquals(firstObject, secondObject);
    }

    @Test
    public void testForDifferentObjects() {
        Book firstObject= new Book(null,null,null);
        Object one = new Integer(1);

        assertThat(firstObject, not(equalTo(one)));
    }

    @Test
    public void testForTransitivity() {
        Book firstObject= new Book(null,null,null);
        Book secondObject= new Book(null,null,null);
        Book thirdObject= new Book(null,null,null);

        assertEquals(firstObject, secondObject);
        assertEquals(secondObject, firstObject);
        assertEquals(firstObject, thirdObject);
    }

    @Test
    public void testForSymmetry() {
        Book firstObject= new Book(null,null,null);
        Book secondObject= new Book(null,null,null);

        assertEquals(firstObject, secondObject);
        assertEquals(secondObject, firstObject);
    }

    @Test
    public void equalityTestForHashCode() {
        Book firstObject= new Book(null,null,null);
        Book secondObject= new Book(null,null,null);

        assertEquals(firstObject.hashCode(), secondObject.hashCode());
    }


}