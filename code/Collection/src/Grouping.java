import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import static java.util.stream.Collectors.*;

public class Grouping {
    public static void run() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Kamil", 19, 1.75));
        people.add(new Person("Bartosz", 21, 1.81));
        people.add(new Person("Dominika", 24, 1.71));

        Map<Integer, List<Person>> collect = people.stream()
                .collect(groupingBy(Person::getAge));
        System.out.println(collect);


        List<String> teams = new ArrayList<>();
        teams.add("Poland");
        teams.add("Slovakia");
        teams.add("Swiden");
        teams.add("Spain");
        teams.add("Spain");

        Map<Integer, List<String>> collect1 = teams.stream()
                .collect(groupingBy(String::length));
        System.out.println(collect1);

        Map<Boolean, List<String>> partitioning = teams.stream()
                .collect(partitioningBy(team -> team.startsWith("S")));
        System.out.println(partitioning.get(false));

        Map<Boolean, List<Person>> isAgeMoreThan = people.stream()
                .collect(partitioningBy(person -> person.getAge() > 20 ));

        System.out.println(isAgeMoreThan.get(false));
    }
}
