package com.twu.biblioteca;

import java.util.HashMap;
//Display options for user
public class Options {
    private Library library;
    public Options(Library library){
        this.library = library;
    }
    public void start(){
        welcome();
        displayOptions();
    }
    public void welcome(){
        System.out.print(Messages.WELCOME_MESSAGE);
    }
    public void displayOptions(){
        HashMap<Integer ,Library> options = new HashMap<Integer , Library>();
        library = options.get(1);
        library.availableListOfBooks();
    }
}