package ukoly17az19lekce.stredniPriklad;

import java.util.Scanner;

public class Pila extends Nastroj {

    public Pila(int vaha, String nazev) {
        super(vaha, nazev);
    }

    @Override
    public String pracuj() {
        return "Piluji";
    }

}
