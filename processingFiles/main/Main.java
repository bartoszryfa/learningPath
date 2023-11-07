package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) {
        Path inputPath = Paths.get(RESOURCES + args[0]);
        Path outputPath = Paths.get(RESOURCES + args[1]);
        List<String> namesStartingWithA = new ArrayList<>();

        try {
            List<String> inputPathList = Files.readAllLines(inputPath);

            for(String file : inputPathList) {
                System.out.println(file);
                    if(file.startsWith("A")) {
                        namesStartingWithA.add(file);
                    }
            }
        } catch (IOException e) {
            System.out.println("Wrong processing input file.");
            throw new RuntimeException(e);
        }

        try {
            Files.write(outputPath, namesStartingWithA);
        } catch (IOException e) {
            System.out.println("Wrong while processing output file.");
            throw new RuntimeException(e);
        }


    }



    }