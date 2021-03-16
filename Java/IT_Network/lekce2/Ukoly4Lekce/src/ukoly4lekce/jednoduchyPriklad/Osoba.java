package ukoly4lekce.jednoduchyPriklad;

public class Osoba {

    private String jmeno;
    private Pes pes;

    public Osoba(String jmeno) {
        this.jmeno = jmeno;
    }

    public void pridejPsa(Pes pes) {
        this.pes = pes;
    }

    public Pes getPes() {
        return pes;
    }

}
