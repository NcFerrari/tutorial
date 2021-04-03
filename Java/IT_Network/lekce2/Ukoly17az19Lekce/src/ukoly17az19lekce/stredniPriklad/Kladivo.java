package ukoly17az19lekce.stredniPriklad;

import java.util.Scanner;

public class Kladivo extends Nastroj {

    private boolean obourucni;

    public Kladivo(int vaha, String nazev, boolean jeObourucni) {
        super(vaha, nazev);
        obourucni = jeObourucni;
    }

    @Override
    public String pracuj() {
        return "Zatloukám";
    }

    public boolean isObourucni() {
        return obourucni;
    }

}
