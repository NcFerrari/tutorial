package ukoly11lekce.stredniPriklad;

import java.util.ArrayList;
import java.util.List;

public class Autobazar {

    private final String adresa;
    private final List<Auto> fara = new ArrayList<>();

    private int hotovostniPenize;

    public Autobazar(String adresa, int hotovostniPenize) {
        this.adresa = adresa;
        this.hotovostniPenize = hotovostniPenize;
    }

    public void koupitVozidlo(Auto auto) {
        if (hotovostniPenize >= auto.getCena()) {
            fara.add(auto);
            hotovostniPenize -= auto.getCena();
        } else {
            System.out.println("NEMÁME NA TO TY VOLE!!");
        }
    }

    public void prodejVozidlo(Auto auto) {
        hotovostniPenize += auto.getCena();
        fara.remove(auto);
    }

    public int getCenaVsechVozidel() {
        int result = 0;
        for (Auto auto : fara) {
            result += auto.getCena();
        }
        return result;
    }

    public int getPocetAutomobilu() {
        return fara.size();
    }

    public int getHotovostniPenize() {
        return hotovostniPenize;
    }

}
