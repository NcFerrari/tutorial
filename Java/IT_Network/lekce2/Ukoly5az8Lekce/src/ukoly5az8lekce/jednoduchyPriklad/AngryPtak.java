package ukoly5az8lekce.jednoduchyPriklad;

public class AngryPtak extends Ptak {

    private int vztek = 50;

    public void provokuj(int miraProvokace) {
        if (getHlad() > 0) {
            vztek += (2 * miraProvokace);
        } else {
            vztek += miraProvokace;
        }
        if (vztek < 0) {
            vztek = 0;
        }
    }

    public int getVztek() {
        return vztek;
    }

    @Override
    public String toString() {
        return String.format("Jsem angry-pták s váhou %d a hladem %d, míra mého vzteku je %d.", getVaha(), getHlad(), getVztek());
    }
}
