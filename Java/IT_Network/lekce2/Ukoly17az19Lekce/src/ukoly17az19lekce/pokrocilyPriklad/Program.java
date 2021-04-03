package ukoly17az19lekce.pokrocilyPriklad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("d.M.y");

    public static void main(String[] args) {
        List<Clovek> lide = new ArrayList<>();
        Clovek alfaSamec = new Muz("Karel", "Novák", LocalDate.parse("5.2.1988", FORMAT));
        lide.add(alfaSamec);
        lide.add(new Muz("Josef", "Nový", LocalDate.parse("19.3.1978", FORMAT)));
        lide.add(new Muz("Jan", "Marek", LocalDate.parse("28.4.1968", FORMAT)));
        lide.add(new Muz("Karel", "Novák", LocalDate.parse("25.6.1958", FORMAT)));
        Clovek alfaSamice = new Zena("Marie", "Nová", LocalDate.parse("15.8.1988", FORMAT));
        lide.add(alfaSamice);
        lide.add(new Zena("Věra", "Nováková", LocalDate.parse("2.10.1978", FORMAT)));
        lide.add(new Zena("Simona", "Mladá", LocalDate.parse("8.1.1968", FORMAT)));
        lide.add(new Zena("Michaela", "Marná", LocalDate.parse("6.12.1958", FORMAT)));
        Collections.sort(lide);
        lide.forEach(clovek -> System.out.println(clovek));
        System.out.printf("\n%s a %s spolu mají dítě %s\n", alfaSamec, alfaSamice, alfaSamice.plus(alfaSamec));
    }
}