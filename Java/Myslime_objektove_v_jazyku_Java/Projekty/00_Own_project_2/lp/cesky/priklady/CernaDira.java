package lp.cesky.priklady;

import lp.cesky.tvary.*;
import lp.cesky.spolecne.P;

public class CernaDira {
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    private static CernaDira cernaDira = new CernaDira();
    
    private final Pozice poziceStredu = new Pozice(150, 150);
    private final int prodleva = 500;
    private final Presouvac presouvac = new Presouvac(5);
    private final Kompresor kompresor = new Kompresor(5);
    
    private Elipsa dira;
    
    private CernaDira() {
        dira = new Elipsa(poziceStredu.getX() - 50, poziceStredu.getY() - 50, 100, 100, Barva.CERNA);
        AP.pridej(dira);
    }
    
    public static CernaDira getInstance() {
        return cernaDira;
    }
    
    public void spolkni(IHybaci object) {
        AP.pridejNad(dira, object);
        presouvac.presunNa(object, poziceStredu.getX() - object.getSirka() / 2, poziceStredu.getY() - object.getVyska() / 2);
        kompresor.nafoukniNa(object, 0, 0, null);
    }
    
    private void posun(Elipsa elipsa, int x, int y) {
        P.cekej(prodleva);
        elipsa.setPozice(x, y);
    }
    
    private void zmensi(Elipsa elipsa, int sirka, int vyska) {
        P.cekej(prodleva);
        elipsa.setRozmer(sirka, vyska);
        elipsa.setPozice(poziceStredu.getX() - sirka / 2, poziceStredu.getY() - vyska / 2);
    }
}
