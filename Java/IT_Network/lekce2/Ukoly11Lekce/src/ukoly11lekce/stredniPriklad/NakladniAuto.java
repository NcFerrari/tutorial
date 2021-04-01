package ukoly11lekce.stredniPriklad;

public class NakladniAuto extends Auto {

    private int nosnost;

    public NakladniAuto(String znacka, String sPZ, int nosnost, int cena) {
        super(znacka, sPZ, cena);
        this.nosnost = nosnost;
    }

    public int getNosnost() {
        return nosnost;
    }

    @Override
    public String toString() {
        return String.format("%s, SPZ: %s, Nosnost: %d tun, Cena: %d Kč", getZnacka(), getSPZ(), getNosnost(), getCena());
    }
}
