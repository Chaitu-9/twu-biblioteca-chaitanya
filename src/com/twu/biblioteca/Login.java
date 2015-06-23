package com.twu.biblioteca;

import java.util.HashMap;

public class Login {
    HashMap<String,String> validation;
    HashMap<String,User> userRegister;
    private User currentUser;
    public Login(HashMap<String, String> validation, HashMap<String, User> userRegister) {
        this.validation = validation;
        this.userRegister = userRegister;
    }

    public boolean validate(String userId, String password) {
        String actualPassword =validation.get(userId);
        if (actualPassword != null) {
            if (actualPassword.equals(password)) {
                currentUser = userRegister.get(userId);
                return true;
            } else
                return false;
        }
        return false;
    }

    public String currentUserDetails() {
        return currentUser.toString();
    }
}
