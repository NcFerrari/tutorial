package ukoly17az19lekce.stredniPriklad;

import java.util.Scanner;

public class ElektrickySroubovak extends Sroubovak {

    private int kapacitaBatarie;

    public ElektrickySroubovak(int vaha, String nazev, int kapacitaBaterie) {
        super(vaha, nazev);
        this.kapacitaBatarie = kapacitaBaterie;
    }

    public int getKapacitaBatarie() {
        return kapacitaBatarie;
    }

    @Override
    public String pracuj() {
        return "Šroubuji elektricky";
    }

}
