package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<User> users = prepareDate();

    // 1. print users who know Java

        users.stream()
            .filter(user -> user.skills().contains("Java"))
            .map(User::name)
            .forEach(System.out::println);

    // 2. print names and ages users who are active

        users.stream().filter(user -> !user.isActive())
            .map(user -> user.name() + ", " + user.age())
            .forEach(System.out::println);

    // 3. find users who know at least 3 programming language, print their names and programming language

        users.stream().filter(user -> user.skills().size() >= 3)
            .map(user -> user.name() + ": " + String.join(", ", user.skills()))
            .forEach(System.out::println);

    // 4. find user who knows the most technologies, print her/his name and skills

        Optional<User> mostSkillUsed = users.stream()
            .max(Comparator.comparing(user -> user.skills().size()));
        System.out.println(mostSkillUsed.get().name() + ": " + String.join(", ", mostSkillUsed.get().skills()));

    // 5. print average age active users

        OptionalDouble averageActiveUsers = users.stream()
            .filter(User::isActive)
            .mapToInt(User::age)
            .average();
        System.out.println(averageActiveUsers.getAsDouble());

    // 6. print average age aren't active users

        OptionalDouble averageDontActiveUsers = users.stream()
            .filter(user -> !user.isActive())
            .mapToInt((User::age))
            .average();
        System.out.println(averageDontActiveUsers.getAsDouble());

    // 7. print average how many technologies users know

        OptionalDouble skillsAverage = users.stream()
            .mapToInt(user -> user.skills().size())
            .average();
        System.out.println(skillsAverage.getAsDouble());

    // 8. split users into those who know Java and those who don't
        // print names and technologies of users in both groups

        Map<Boolean, List<User>> usersMap = users.stream()
            .collect(Collectors.partitioningBy(user -> user.skills().contains("Java")));

        usersMap.get(true).stream()
            .map(user -> user.name() + ": " + String.join(", ", user.skills()))
            .forEach(System.out::println);

        System.out.println();

        usersMap.get(false).stream()
            .map(user -> user.name() + ": " + String.join(", ", user.skills()))
            .forEach(System.out::println);

    // 9. check that all users are > 18

        boolean isAllUsersAreOver18 = users.stream()
                .allMatch(user -> user.age() > 18);
        System.out.println(isAllUsersAreOver18);

    //10. check if there is a user who is older than 40

        boolean isAnyUserOver40 = users.stream().anyMatch(user -> user.age() > 40);
        System.out.println(isAnyUserOver40);

    // 11. find the oldest user who knows Java

        Optional<User> oldestPersonWhoKnowsJava = users.stream()
            .filter(user -> user.skills().contains("Java"))
            .max(Comparator.comparing(User::age));
        System.out.println("name: " + oldestPersonWhoKnowsJava.get().name() + ", age: " + oldestPersonWhoKnowsJava.get().age());

    // 12. find users who know programing language start with "C",
        // print names and skills

         users.stream()
            .filter(user -> user.skills().stream().anyMatch(skill -> skill.startsWith("C")))
            .map(user -> user.name() + ": " + String.join(",", user.skills()))
            .forEach(System.out::println);

    // 13. create a map that takes the users name as a key
        // and the number of technologies user knows as a value

        Map<String, Integer> usersAndNumberOfSkills = users.stream()
                .collect(Collectors.toMap(
                        User::name,
                        user -> user.skills().size()
                ));
        System.out.println(usersAndNumberOfSkills.get("Bartek"));
        System.out.println(usersAndNumberOfSkills.get("Emilka"));

    // 14. check palindromes and print
        List<String> words = List.of("kajak", "anakonda", "oko", "ala", "zakaz", "java", "programowanie");

        words.stream().filter(word -> word.contentEquals(
                new StringBuilder(word)
                        .reverse()))
                .forEach(System.out::println);

    // 15. print all words from list

        List<String> fewWords = List.of("Aniela", "anakonda", "kamien", "pies", "ban", "c", "ux");

        String allWords = fewWords.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println(allWords);

    // 16. given two lists of integers, find the smallest even number

        List<Integer> list1 = List.of(62, 322, 43, 4322, 1);
        List<Integer> list2 = List.of(1221, 3212, 2, 21, 2321);

        Integer smallestNum = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .filter(num -> num % 2 == 0)
                .findFirst()
                .get();
        System.out.println(smallestNum);
    }
    private static List<User> prepareDate() {
        List<User> users = new ArrayList<>();

        users.add(new User("Michał", 20, List.of("Java", "C++", "C#"), false));
        users.add(new User("Agnieszka", 31, List.of("Scala", "Ruby", "C", "C#"), true));
        users.add(new User("Emilka", 18, List.of("Swift", "C++", "Kotlin", "Java", "Python"), false));
        users.add(new User("Krzysiek", 42, List.of("PHP", "JS", "HTML", "CSS"), true));
        users.add(new User("Basia", 27, List.of("HTML", "SAP"), true));
        users.add(new User("Janek", 35, List.of("Java", "Ruby", "Scala", "Angular"), false));
        users.add(new User("Bartek", 16, List.of("Java", "NODE JS"), true));

        return users;
    }
}