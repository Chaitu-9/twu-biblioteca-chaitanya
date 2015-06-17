package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BibliotecaViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void shouldGetInputFromUser(){
    Scanner input = new Scanner(inContent);
    BibliotecaView view = new BibliotecaView(input);
    String actualValue = view.getIntegerInput() + "";
    String expectedValue = "1";

    assertThat(actualValue, is(expectedValue));
    }
    @After
    public void cleanUp(){
        System.setOut(null);
    }
}
