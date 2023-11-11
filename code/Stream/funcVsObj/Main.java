import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Janusz", "Janina", "Alicja", "Bartek");

//       int femaleCounter = 0;
//       for(String name : names) {
//           if(name.endsWith("a")) femaleCounter++;
//       }

        long femaleCounter = names.stream()
                .filter(name -> name.endsWith("a"))
                .count();

        System.out.println(femaleCounter);

        names.forEach(System.out::println);

        names.stream()
                .filter(name -> name.endsWith("a"))
                .forEach(System.out::println);



    }
}