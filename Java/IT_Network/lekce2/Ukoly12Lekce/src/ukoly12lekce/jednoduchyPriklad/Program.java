package ukoly12lekce.jednoduchyPriklad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Program {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter ownFormat = DateTimeFormatter.ofPattern("d.M.y");
        System.out.println("Vypisuji součty cifer v datu pro následujících 7 dní");
        int dayPlus = 0;
        for (int i = 0; i < 7; i++) {
            date = date.plusDays(dayPlus);
            int sum = date.getYear() + date.getMonthValue() + date.getDayOfMonth();
            System.out.printf("%s - %d\n", date.format(ownFormat), sum);
            dayPlus = 1;
        }
    }
}
