package rozhrani;

public class Ptak extends Zvire implements PtakInterface {

    public Ptak(int vaha) {
        super(vaha);
    }

    @Override
    public void pipni() {
        System.out.println("Píp");
    }

    @Override
    public void presunSe() {
        System.out.println("LETÍM");
    }

}
