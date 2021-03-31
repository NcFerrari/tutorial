package ukoly5az8lekce.pokrocilyPriklad;

public class Obdelnik extends Tvar {

    private double sirka;
    private double vyska;

    public Obdelnik(double sirka, double vyska, String barva) {
        super(barva);
        this.sirka = sirka;
        this.vyska = vyska;
    }

    @Override
    public double obsah() {
        return sirka * vyska;
    }

}
