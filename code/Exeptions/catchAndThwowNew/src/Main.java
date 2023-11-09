import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(10);
        BigDecimal b = new BigDecimal(0);

        try {
            a = a.divide(b);
            System.out.println(a);
        } catch(ArithmeticException e) {
            if(b.intValue() == 0) {
                throw new DivisionByZeroExeption("Don't devide by 0!!");
            }
            e.printStackTrace();
        }
    }
}