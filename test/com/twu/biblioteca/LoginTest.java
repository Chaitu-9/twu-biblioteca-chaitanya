package com.twu.biblioteca;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoginTest {
    @Test
    public void shouldReturnTrueWhenCorrectLoginIdAnsPasswordIsEntered(){
        HashMap<String, String> validation= new HashMap<String, String>();
        validation.put("ravi","qwerty");
        validation.put("surya","asdfgh");
        validation.put("admin","zxcvbn");
        Login login = new Login(validation);
        boolean foo =login.validate("ravi","qwerty");

        assertThat(foo, is(true));
    }
}
