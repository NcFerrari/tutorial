package ukoly4lekce.jednoduchyPriklad;

public class Pes {

    private String jmeno;
    private int vek;

    public Pes(String jmeno, int vek) {
        this.jmeno = jmeno;
        this.vek = vek;
    }

    public int getVek() {
        return vek;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void zestarni() {
        vek++;
    }

    @Override
    public String toString() {
        return String.format("%s (%d let)", getJmeno(), getVek());
    }
}
