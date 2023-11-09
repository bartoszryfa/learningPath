public class NumberNotPositiveExeption extends RuntimeException{
    public NumberNotPositiveExeption() {
    }

    public NumberNotPositiveExeption(String message) {
        super(message);
    }
}
