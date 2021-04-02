package datumacas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DatumACas {

    public static void main(String[] args) {
        LocalDateTime datumCas = LocalDateTime.of(2021, Month.APRIL, 1, 18, 52);
        System.out.println(datumCas);

        LocalDate datum = LocalDate.of(2021, Month.APRIL, 1);
        System.out.println(datum);

        LocalTime cas = LocalTime.of(18, 52);
        System.out.println(cas);

        System.out.println(LocalDateTime.now());

        // spojení
        LocalDateTime convertedLocalDateTime = LocalDateTime.of(datum, cas);

        LocalDate zacatek = LocalDate.of(1939, 9, 1);
        LocalDateTime datumCas2 = zacatek.atStartOfDay();
        LocalDateTime datumCas3 = zacatek.atTime(0, 0);
        System.out.println(datumCas2);
        System.out.println(datumCas3);

        LocalDateTime ted = LocalDateTime.now();
        System.out.println(ted);
        System.out.println(ted.withYear(2022));
        System.out.println(ted.withDayOfYear(5));

        LocalDateTime datumCas4 = LocalDateTime.now();
        datumCas4 = datumCas4.plusDays(3);
        System.out.println(datumCas4.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

        LocalDateTime datumCas5 = LocalDateTime.now();
        datumCas5 = datumCas5.plus(Period.ofDays(3));
        System.out.println(datumCas5.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        
        
    }
}
