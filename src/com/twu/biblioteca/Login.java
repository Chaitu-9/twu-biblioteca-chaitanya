package com.twu.biblioteca;

import java.util.HashMap;

public class Login {
    HashMap<String,String> validation;
    public Login(HashMap<String, String> validation) {
        this.validation = validation;
    }

    public boolean validate(String userId, String password) {
        String actualPassword =validation.get(userId);
        if (actualPassword != null)
            return actualPassword.equals(password);
        return false;
    }
}
