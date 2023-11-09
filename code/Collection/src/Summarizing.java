import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingInt;

public class Summarizing {
    public static void run() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Kamil", 19, 1.75));
        people.add(new Person("Bartosz", 21, 1.81));
        people.add(new Person("Dominika", 24, 1.71));

        IntSummaryStatistics collect = people.stream()
                .collect(Collectors.summarizingInt(Person::getAge));
            System.out.println(collect.getMax());
            System.out.println(collect.getAverage());
            System.out.println(collect.getCount());
            System.out.println(collect.getSum());
            System.out.println(collect.getMin());

    }
}
