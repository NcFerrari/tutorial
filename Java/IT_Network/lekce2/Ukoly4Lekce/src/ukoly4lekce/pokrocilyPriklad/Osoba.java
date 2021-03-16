package ukoly4lekce.pokrocilyPriklad;

public class Osoba {

    private String jmeno;
    private Osoba otec;
    private Osoba matka;

    public Osoba(String jmeno, Osoba otec, Osoba matka) {
        this.jmeno = jmeno;
        this.otec = otec;
        this.matka = matka;
    }

    public String getJmeno() {
        return jmeno;
    }

    public Osoba getMatka() {
        return matka;
    }

    public Osoba getOtec() {
        return otec;
    }

    @Override
    public String toString() {
        return getJmeno();
    }
}
