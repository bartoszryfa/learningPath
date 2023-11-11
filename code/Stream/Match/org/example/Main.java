package org.example;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<User> users = prepareData();


        boolean anyMath = users.stream()
                .anyMatch(user -> user.skills().contains("Java"));
        System.out.println(anyMath);

        boolean nonMath = users.stream()
                .noneMatch(user -> user.skills().contains("Java"));
        System.out.println(nonMath);

        boolean allMatch = users.stream()
                .allMatch(user -> user.skills().contains("Java"));
        System.out.println(allMatch);

        Optional<User> findFirst = users.stream()
                .filter(user -> user.age() > 24)
                .findFirst();
        System.out.println(findFirst.get());

        Optional<User> findAny = users.stream()
                .filter(user -> user.age() >= 28)
                .findAny();
        System.out.println(findAny.get());

        OptionalInt any = IntStream.range(0, 100).parallel().findAny();
        System.out.println(any.getAsInt());
}

    private static List<User> prepareData() {
        List<User> users = new ArrayList<>();

        users.add(new User("Michał", 20, List.of("Java", "C++", "Python", "C#"), true));
        users.add(new User("Agnieszka", 31, List.of("Scala", "Ruby", "C", "C#"), true));
        users.add(new User("Emilka", 18, List.of("Swift", "C++", "Kotlin", "Java"), true));
        users.add(new User("Krzysiek", 42, List.of("PHP", "JS", "HTML", "CSS"), true));
        users.add(new User("Basia", 27, List.of("JS", "C++", "HTML", "SAP"), true));
        users.add(new User("Janek", 35, List.of("Java", "Ruby", "Scala", "Angular"), true));
        users.add(new User("Bartek", 16, List.of("Java", "C#", "Kotlin", "NODE JS"), true));

        return users;
    }
}

