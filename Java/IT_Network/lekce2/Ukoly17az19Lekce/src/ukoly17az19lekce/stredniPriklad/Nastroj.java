package ukoly17az19lekce.stredniPriklad;

import java.util.Scanner;

public abstract class Nastroj {

    private int vaha;
    private String nazev;

    public Nastroj(int vaha, String nazev) {
        this.vaha = vaha;
        this.nazev = nazev;
    }

    public int getVaha() {
        return vaha;
    }

    public String getNazev() {
        return nazev;
    }

    public abstract String pracuj();
}
