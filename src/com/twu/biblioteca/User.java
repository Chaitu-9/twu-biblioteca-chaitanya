package com.twu.biblioteca;

public class User {
    String name,emailAddress,phoneNumber;
    public User(String name, String emailAddress, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "name : " + name + " emailAddress : " + emailAddress + " phoneNumber : " + phoneNumber ;
    }
}
