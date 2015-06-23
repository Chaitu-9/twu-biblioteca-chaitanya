package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckoutRegister {
    private ArrayList<String> register = new ArrayList<String>();

    public void checkedOutDetails(String userId, String name){
        register.add(userId + " " + name);
    }

    public boolean validateReturn(String userId, String name){
        return register.contains(userId +" "+ name);
    }

    public void removeBook(String userId, String name) {
        register.remove(userId + " " + name);
    }

    @Override
    public String toString() {
        String description = "";
        for (String str : register)
            description += str + "\n";
        return description;
    }
}
