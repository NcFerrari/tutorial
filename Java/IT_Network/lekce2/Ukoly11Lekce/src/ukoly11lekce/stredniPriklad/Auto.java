package ukoly11lekce.stredniPriklad;

public class Auto {

    private final String znacka;
    private String sPZ;
    private int cena;

    public Auto(String znacka, String sPZ, int cena) {
        this.znacka = znacka;
        this.sPZ = sPZ;
        this.cena = cena;
    }

    public String getZnacka() {
        return znacka;
    }

    public String getSPZ() {
        return sPZ;
    }

    public int getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return String.format("%s, SPZ: %s, Cena: %d Kč", getZnacka(), getSPZ(), getCena());
    }
}
