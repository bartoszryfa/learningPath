import java.util.*;

public class Main {
    public static void main(String[] args) {
       List<String> list1 = new ArrayList<>();
       list1.add("Adam");
       list1.add("Jan");
       list1.add("Andrew");

       List<String> list2 = new ArrayList<>();
       Collections.addAll(list2, "Adam ", "Jan", "Andrew");

       // ---------------------------- unmutable list

       List<String> list3 = Arrays.asList("Adam ", "Jan", "Andrew");
       //list3.add("Alex");   -> mistake


        // ---------------------------  mutable list

        List<String> list4 = new ArrayList<>(list3);
        list3.add("Alex");
        System.out.println(list4.size());

    }
}