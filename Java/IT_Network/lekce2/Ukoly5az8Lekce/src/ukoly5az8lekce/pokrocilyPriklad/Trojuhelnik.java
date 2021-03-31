package ukoly5az8lekce.pokrocilyPriklad;

public class Trojuhelnik extends Tvar {

    private double a;
    private double b;
    private double c;

    public Trojuhelnik(double a, double b, double c, String barva) {
        super(barva);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double obsah() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

}
