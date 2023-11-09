package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        NamesReader namesReader = new NamesReader("main/java/resources/file.txt");

        try {
            namesReader.readAllNames();
        } catch (IOException e) {
            System.out.println("File not found");
        }

    }
}