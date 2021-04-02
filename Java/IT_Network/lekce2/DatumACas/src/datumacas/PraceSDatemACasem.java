package datumacas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class PraceSDatemACasem {

    public static void main(String[] args) {
        // čtení hodnoty
        LocalDate today = LocalDate.now();
        System.out.printf("Rok: %d, měsíc: %d, den: %d\n", today.getYear(), today.getMonthValue(), today.getDayOfMonth());

        //parsování
        String datum = "2020-12-12";
        String cas = "12:34";
        LocalDateTime datumCas = LocalDateTime.parse(datum + cas, DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm"));
        LocalDate datum2 = LocalDate.parse(datum);
        LocalTime cas2 = LocalTime.parse(cas);

        System.out.println(datumCas.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(datum.formatted(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(cas.formatted(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        
        ZonedDateTime lokalniDatumCas = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(lokalniDatumCas);
    }
}
