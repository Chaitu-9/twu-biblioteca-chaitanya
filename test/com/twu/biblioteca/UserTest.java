package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldBeAbleToReturnUserDetails() {
     User user = new User("ravi","ravichandra","9876543210");

     String expectedValue = "name : ravi\n emailAddress : ravichandra\n phoneNumber : 9876543210";

     assertThat(user.toString(),is(expectedValue));
    }
}