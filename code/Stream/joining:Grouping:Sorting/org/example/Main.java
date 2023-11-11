package org.example;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<User> users = prepareData();




        //concat
        List<String> names = List.of("Bartek", "Karol", "Harry", "David");
        List<String> names2 = List.of("Kacper", "Natalia", "Iza", "Wiktoria");

        Stream.concat(names.stream(), names2.stream())
            .filter(name -> name.startsWith("K"))
            .forEach(System.out::println);




//partitioningBy

        Map<Boolean, List<User>> collect = users.stream()
            .collect(Collectors.partitioningBy(User::isActive));
        System.out.println(collect);

//gropingBy

        Map<Integer, List<String>> groupingByNameLength = users.stream()
            .map(User::name)
            .collect(Collectors.groupingBy(String::length));
        System.out.println(groupingByNameLength);


//joining

        String joining = users.stream()
            .map(User::skills)
            .flatMap(Collection::stream)
            .collect(Collectors.joining(", "));

        System.out.println(joining);

//sorting

        List<User> maleSortedByAge = users.stream()
            .filter(user -> !user.name().endsWith("a"))
            .sorted(Comparator.comparing(User::age))
            .toList();
        maleSortedByAge.forEach(System.out::println);
}
    
        users.stream()
            .filter(user -> !user.name().endsWith("a"))
            .sorted(Comparator.comparing(User::age))
            .takeWhile(user -> user.age() < 25)
            .dropWhile(user -> user.age() == 16)
            .forEach(user -> System.out.println(user.name() + " wiek: " + user.age()));

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

