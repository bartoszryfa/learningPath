import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            int a = 2;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("You cannot divide by 0");
        }


// -------------------------------------------------------

        try {

            List<String> names = new ArrayList<>();
            names.add("Mathias");
            System.out.println(names.get(1));

            String name = "Bartosz";
            System.out.println(name.toLowerCase());

        } catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Mistake");
        }

// -------------------------------------------------------

        try {
            int c = 2;
            int d = 0;
            System.out.println(c / d);


            List<String> surnames = new ArrayList<>();
            surnames.add("Mathias");
            System.out.println(surnames.get(1));

            String surname = "Bartosz";
            System.out.println(surname.toLowerCase());

        } catch(RuntimeException e) {
            System.out.println("unchecked exeption");
        }
    }
}