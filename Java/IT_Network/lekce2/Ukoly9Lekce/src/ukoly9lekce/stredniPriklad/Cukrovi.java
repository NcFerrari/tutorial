package ukoly9lekce.stredniPriklad;

public class Cukrovi {

    private String barva;
    private String tvar;
    private int vaha;

    public Cukrovi(String barva, String tvar, int vaha) {
        this.barva = barva;
        this.tvar = tvar;
        this.vaha = vaha;
    }

    public String getBarva() {
        return barva;
    }

    public String getTvar() {
        return tvar;
    }

    public int getVaha() {
        return vaha;
    }

    @Override
    public String toString() {
        return String.format("Cukroví barvy %s, tvaru %s a váhy %dg", getBarva(), getTvar(), getVaha());
    }

}
