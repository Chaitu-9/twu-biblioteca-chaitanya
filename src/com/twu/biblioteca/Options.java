package com.twu.biblioteca;

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
        System.out.print("1. " + Messages.LIST_BOOKS + "\n" + "2. "+ Messages.CHECKOUT +"\n" +"3. " + Messages.EXIT +"\n");
    }
}