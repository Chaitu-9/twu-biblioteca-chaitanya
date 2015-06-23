package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckoutRegisterTest {
    @Test
    public void shouldStoreUserIdAndHisCheckedoutBooks(){
        CheckoutRegister checkoutRegister = new CheckoutRegister();

        checkoutRegister.checkedOutDetails("ravi", "Harry Potter");
        String actualValue = checkoutRegister.toString();

        assertThat(actualValue,is("ravi Harry Potter\n"));
    }

    @Test
    public void shouldremoveReturnedBooksOrMoviesFromRegister(){
        CheckoutRegister cr = new CheckoutRegister();

        cr.checkedOutDetails("surya", "Hound of baskervilles");
        cr.checkedOutDetails("hari", "Harry Potter");
        cr.validateReturn("hari", "Harry Potter");
        cr.removeBook("hari","Harry Potter");
        String actualValue = cr.toString();

        assertThat(actualValue, is("surya Hound of baskervilles\n"));
    }

}