package org.example;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<User> users = prepareData();


//counting elements
        Long numOfElements = users.stream()
                .count();
        System.out.println(numOfElements);

//summing age
        Integer summingAgeValue = users.stream()
                .mapToInt(User::age).sum();
        System.out.println(summingAgeValue);

// aveaging age
        Double ageAvg = users.stream()
                .collect(Collectors.averagingDouble(User::age));
        System.out.println(ageAvg);

// min
        Optional<Integer> minAge = users.stream()
                .map(User::age)
                .min(Comparator.naturalOrder());

        System.out.println(minAge.get());
// max
        Optional<Integer> maxAge = users.stream()
                .map(User::age)
                .max(Comparator.naturalOrder());

        System.out.println(maxAge.get());

 //summarizing
        IntSummaryStatistics statistic = users.stream()
                .collect(Collectors.summarizingInt(User::age));
        System.out.println(statistic.getCount());
        System.out.println(statistic.getSum());
        System.out.println(statistic.getMin());
        System.out.println(statistic.getMax());
        System.out.println(statistic.getAverage());




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

