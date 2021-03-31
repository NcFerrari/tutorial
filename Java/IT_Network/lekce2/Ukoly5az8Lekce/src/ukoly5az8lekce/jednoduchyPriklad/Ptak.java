package ukoly5az8lekce.jednoduchyPriklad;

public class Ptak {

    private int hlad = 100;
    private int vaha = 50;

    public void snez(int kiloPotravy) {
        vaha += kiloPotravy;
        hlad -= kiloPotravy;
        if (vaha < 0) {
            vaha = 0;
        }
        if (hlad < 0) {
            hlad = 0;
        }
    }

    public int getVaha() {
        return vaha;
    }

    public int getHlad() {
        return hlad;
    }

    @Override
    public String toString() {
        return String.format("Jsem pták s váhou %d a hladem %d.", getVaha(), getHlad());
    }
}
