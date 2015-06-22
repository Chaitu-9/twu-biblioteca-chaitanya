package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckoutRegister {
    private ArrayList<String> register = new ArrayList<String>();

    public void entercheckedOutDetails(String userId ,String bookName){
       register.add(userId + " " + bookName);
    }

    @Override
    public String toString() {
        String description = "";
        for (String str : register)
            description += str + "\n";
        return description;
    }
}
