package org.example;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<User> users = prepareData();




// save to map --------------------------

        Country pol = new Country("Poland", "Warsaw");
        Country swd = new Country("Sweden", "Stockholm");
        Country swiss = new Country("Swiss", "Zurich");
        Country esp = new Country("Espania", "Madrid");
        Country fra = new Country("France", "Paris");

        List<Country> countries = List.of(pol, swd, swiss, esp, fra);

        Map<String, String> countriesAndCapitals = countries.stream()
                .collect(Collectors.toMap(Country::country, Country::capital, (oldValue, newValue) -> newValue));
        System.out.println(countriesAndCapitals.get("Poland"));

//toSet ---------------------------------
        Set<String> saveToSet = users.stream()
            .map(User::skills)
            .flatMap(Collection::stream)
            .collect(Collectors.toSet());


        List<String> skills = users.stream()
            .map(User::skills)
            .flatMap(Collection::stream)
            .distinct()
            .sorted()
            .toList();
        skills.forEach(System.out::println);



//flatMap -------------------------------

        List<String> skills = users.stream()
            .map(User::skills)
            .flatMap(Collection::stream)
            .toList();
        skills.forEach(System.out::println);

}

//map    ---------------------------------

        List<String> names = users.stream()
                .filter(user -> !user.name().endsWith("a"))
                .sorted(Comparator.comparing(User::age))
                .map(User::name)
                .toList();
        names.forEach(System.out::println);
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

