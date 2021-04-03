package rozhrani;

public class Delfin extends Zvire {

    public Delfin(int vaha) {
        super(vaha);
    }

    public void vyskoc() {
        System.out.println("Vyskočil jsem nad hladinu...");
    }

    @Override
    public void presunSe() {
        System.out.println("Plavu si, ani nevím jak");
    }

}
