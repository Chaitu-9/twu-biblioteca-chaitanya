package com.twu.biblioteca;

import java.util.Scanner;

//for taking input and displaying output
public class BibliotecaView {
    Scanner input;

    public BibliotecaView(Scanner input) {
        this.input = input;
    }

    public int getInput(){
       return input.nextInt();
    }
}
