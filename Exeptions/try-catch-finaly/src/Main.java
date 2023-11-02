
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        getUserAge();

    }

    private static int getUserAge() {
//        Scanner scanner = new Scanner(System.in);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("How old are you?");
            int age = scanner.nextInt();
            return age;
        } catch (InputMismatchException e) {
            System.out.println("You don't wrote number.");
//        } finally {
//            scanner.close();
//        }
        }
        return -1;
    }
}