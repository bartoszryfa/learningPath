import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CountingSummingAveraging {
    public static void run() {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Kamil", 19, 1.75));
        people.add(new Person("Bartosz", 21, 1.81));
        people.add(new Person("Dominika", 24, 1.71));


        Long collect = people.stream()
                .collect(counting());

        System.out.println(collect);

        Integer summingAge = people.stream()
                .collect(summingInt(Person::getAge));

        System.out.println(summingAge);

        Double AvearingHeight = people.stream()
                .collect(averagingDouble(Person::getHeight));

        System.out.println(AvearingHeight);

        Optional<Integer> sortByMinAge = people.stream()
                .map(Person::getAge)
                .collect(minBy(Comparator.naturalOrder()));

        System.out.println(sortByMinAge.get());
    }
}
