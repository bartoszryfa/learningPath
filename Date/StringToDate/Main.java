import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        LocalDate now = LocalDate.now();

        // date to String
        DateTimeFormatter parseDateFormat = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        DateTimeFormatter parseDateFormat1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d'th' MMMM");

        String formatDateString = now.format(formatter);
        System.out.println(formatDateString);

        // String to date
        String dataString = "10.02.2023";
        LocalDate parsed = LocalDate.parse(dataString, parseDateFormat1);
        System.out.println(parsed);
    }
}