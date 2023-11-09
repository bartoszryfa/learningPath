import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Joining {
    public static void run() {

        List<String> names = new ArrayList<>();
        names.add("Natalia");
        names.add("Bartosz");
        names.add("Marcelina");
        names.add("Iza");
        names.add("Marcin");

        String joined = names.stream()
                .collect(joining(", ", "Imiona: ", " (wszystkie)"));
        System.out.println(joined);
    }
}
