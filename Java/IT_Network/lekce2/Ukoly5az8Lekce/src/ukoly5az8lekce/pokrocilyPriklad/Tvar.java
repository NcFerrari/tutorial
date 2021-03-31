package ukoly5az8lekce.pokrocilyPriklad;

public abstract class Tvar {

    protected String barva;

    public Tvar(String barva) {
        this.barva = barva;
    }

    public abstract double obsah();
}
