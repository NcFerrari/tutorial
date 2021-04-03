package ukoly17az19lekce.pokrocilyPriklad;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public abstract class Clovek implements Comparable<Clovek> {

    private final Random random = new Random();
    private String jmeno;
    private String prijmeni;
    private LocalDate datumNarozeni;

    public Clovek(String jmeno, String prijmeni, LocalDate datumNarozeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    public int getVek() {
        return Period.between(getDatumNarozeni(), LocalDate.now()).getYears();
    }

    @Override
    public int compareTo(Clovek dalsiClovek) {
        if (this.jmeno.compareTo(dalsiClovek.jmeno) == 0) {
            if (datumNarozeni.isBefore(dalsiClovek.datumNarozeni)) {
                return -1;
            }
            if (datumNarozeni.isAfter(dalsiClovek.datumNarozeni)) {
                return 1;
            }
        }
        return this.jmeno.compareTo(dalsiClovek.jmeno);
    }

    public Clovek plus(Clovek other) {
        if (!other.getClass().getSimpleName().equals(getClass().getSimpleName())) {
            if (random.nextBoolean()) {
                return new Zena("Eva", getPrijmeni(), LocalDate.now());
            } else {
                return new Muz("Adam", getPrijmeni(), LocalDate.now());
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getJmeno(), getPrijmeni(), getDatumNarozeni().format(DateTimeFormatter.ofPattern("yy")));
    }

}
