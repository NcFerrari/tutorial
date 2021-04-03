package rozhrani;

public class PtakoJester extends Zvire implements PtakInterface, JesterInterface {

    public PtakoJester(int vaha) {
        super(vaha);
    }

    @Override
    public void pipni() {
        System.out.println("♫ ♫ ♫");
    }

    public void klovni() {
        System.out.println("Klov, Klov!");
    }

    @Override
    public void plazitSe() {

    }

    @Override
    public void presunSe() {
        System.out.println("plazím se");
    }

}
