package ukoly17az19lekce.stredniPriklad;

import java.util.Scanner;

public class Sroubovak extends Nastroj {

    public Sroubovak(int vaha, String nazev) {
        super(vaha, nazev);
    }

    @Override
    public String pracuj() {
        return "Šroubuji";
    }

}
