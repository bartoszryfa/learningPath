package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NamesReader {

    private final String filePath;
    public NamesReader(String filePath) {
        this.filePath = filePath;
    }

     public void readAllNames() throws IOException {
         Path path = Paths.get(filePath);
         List<String> names = Files.readAllLines(path);

         for(String name : names) {
             System.out.println(name);
         }
     }
}
