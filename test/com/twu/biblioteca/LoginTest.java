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
        HashMap<String,User> userRegister = new HashMap<String, User>();
        userRegister.put("ravi",new User("ravi","ravi123@gmail.com","9876543210"));
        Login login = new Login(validation, userRegister);
        boolean foo =login.validate("ravi","qwerty");

        assertThat(foo, is(true));
    }

    @Test
     public void shouldReturnFalseWhenWrongLoginIdAnsPasswordIsEntered(){
        HashMap<String, String> validation= new HashMap<String, String>();
        validation.put("ravi","qwerty");
        validation.put("surya","asdfgh");
        validation.put("admin","zxcvbn");
        Login login = new Login(validation, null);
        boolean foo =login.validate("ravi","qweoss");

        assertThat(foo, is(false));
    }
}
