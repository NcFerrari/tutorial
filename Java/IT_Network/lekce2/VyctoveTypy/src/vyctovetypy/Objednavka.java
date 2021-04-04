package vyctovetypy;

import java.util.EnumSet;

public class Objednavka {

    public StavObjednavky stav;

    public Objednavka() {
        stav = StavObjednavky.NOVA;
        EnumSet prava = EnumSet.of(StavObjednavky.PRIJATA);
        prava.add(StavObjednavky.PRIJATA);
//        prava.remove(StavObjednavky.NOVA);
        if (prava.contains(StavObjednavky.PRIJATA)) {
            System.out.println("PŘIJATO");
        }
    }
    
    public static void main(String[] args) {
        new Objednavka();
    }
}
