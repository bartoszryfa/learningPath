package org.example;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws IOException {
        Random randomNumber = new Random();
        List<Integer> numbers = new ArrayList<>();

        Instant beforLoop = Instant.now();

        for(int i = 0; i < 100_000_000; i++) {
            int number = randomNumber.nextInt(100_000_000) + 1;
            numbers.add(number);

        }

        Instant afterLoop = Instant.now();

        Duration betweenBeforAndAfter = Duration.between(beforLoop, afterLoop);
        System.out.println(betweenBeforAndAfter.toMillis());
    }
}