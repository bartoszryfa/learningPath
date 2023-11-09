import java.util.InputMismatchException;

public class PositiveNumbersCalculator {
    public static int sum(int firstNumber, int secondNumber) {
        if(firstNumber < 0 || secondNumber < 0) {
            throw new NumberNotPositiveExeption("Number isn't positive");
        }
        return firstNumber + secondNumber;
    }
}
