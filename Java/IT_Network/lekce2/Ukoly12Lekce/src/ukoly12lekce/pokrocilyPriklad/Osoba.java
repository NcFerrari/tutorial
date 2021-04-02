package ukoly12lekce.pokrocilyPriklad;

import java.time.LocalDate;
import java.time.Period;

public class Osoba {

    private final LocalDate birth;

    public Osoba(LocalDate date) {
        birth = date;
    }

    public int getVek() {
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public LocalDate getBirth() {
        return birth;
    }

}
