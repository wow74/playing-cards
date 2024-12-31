package org.example;

import org.example.game.DoubleUp;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {
  public static void main(String[] args) throws UnsupportedEncodingException {
    System.out.println("Hello world!");
    System.setOut(new PrintStream(System.out, true, "UTF-8"));

    final DoubleUp doubleUp = new DoubleUp();
    doubleUp.game();

  }
}