package rozhrani;

import java.util.ArrayList;
import java.util.Collections;

public class Rozhrani {

    public static void main(String[] args) {
        PtakInterface ptak = new PtakoJester(5);
        ptak.pipni();
        ((JesterInterface) ptak).plazitSe();

        ArrayList<Zvire> zvirata = new ArrayList<>();
        zvirata.add(new Ptak(1));
        zvirata.add(new Delfin(8));
        zvirata.add(new Delfin(9));
        zvirata.add(new PtakoJester(3));
        zvirata.add(new PtakoJester(2));
        zvirata.add(new Zvire(0) {
            @Override
            public void presunSe() {
                System.out.println("hua hua ju?");
            }
        });
        Collections.sort(zvirata);
        for (Zvire zvire : zvirata) {
            zvire.presunSe();
        }

    }
}
