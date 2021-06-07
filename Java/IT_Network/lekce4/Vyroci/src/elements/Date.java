package elements;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {

    private static DateTimeFormatter formatData = DateTimeFormatter.ofPattern("d'.'M'.'y");

    public static String zformatuj(LocalDate datum) {
        return datum.format(formatData);
    }

    public static LocalDate naparsuj(String datumText) {
        return LocalDate.parse(datumText, formatData);
    }
}
