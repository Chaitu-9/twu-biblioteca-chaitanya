package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckoutRegisterTest {
    @Test
    public void shouldStoreUserIdAndHisCheckedoutBooks(){
        CheckoutRegister checkoutRegister = new CheckoutRegister();

        checkoutRegister.entercheckedOutDetails("ravi", "Harry Potter");
        String actualValue = checkoutRegister.toString();

        assertThat(actualValue,is("ravi Harry Potter\n"));
    }

}