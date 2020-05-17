

public class CernaDira {
    
    private static CernaDira cernaDira = new CernaDira();
    private Pozice poziceStredu = new Pozice(150, 150);
    private final int prodleva = 500;
    private Elipsa dira;
    
    private CernaDira() {
        dira = new Elipsa(poziceStredu.getX() - 50, poziceStredu.getY() - 50, 100, 100, Barva.CERNA);
    }
    
    public static CernaDira getInstance() {
        return cernaDira;
    }
    
    public void spolkni(Elipsa elipsa) {
        int posunX = (poziceStredu.getX() - (elipsa.getX() + elipsa.getSirka() / 2)) / 3;
        int posunY = (poziceStredu.getY() - (elipsa.getY() + elipsa.getVyska() / 2)) / 3;
        int zmenseniSirky = elipsa.getSirka() / 3;
        int zmenseniVysky = elipsa.getVyska() / 3;
        posun(elipsa, elipsa.getX() + posunX, elipsa.getY() + posunY);
        posun(elipsa, elipsa.getX() + posunX, elipsa.getY() + posunY);
        posun(elipsa, poziceStredu.getX() - elipsa.getSirka() / 2, poziceStredu.getY() - elipsa.getVyska() / 2);
        zmensi(elipsa, elipsa.getSirka() - zmenseniSirky, elipsa.getVyska() - zmenseniVysky);
        zmensi(elipsa, elipsa.getSirka() - zmenseniSirky, elipsa.getVyska() - zmenseniVysky);
        zmensi(elipsa, 0, 0);
        P.cekej(prodleva);
        elipsa.smaz();
        dira.nakresli();
    }
    
    private void posun(Elipsa elipsa, int x, int y) {
        P.cekej(prodleva);
        elipsa.setPozice(x, y);
        dira.nakresli();
        elipsa.nakresli();
    }
    
    private void zmensi(Elipsa elipsa, int sirka, int vyska) {
        P.cekej(prodleva);
        elipsa.setRozmer(sirka, vyska);
        elipsa.setPozice(poziceStredu.getX() - sirka / 2, poziceStredu.getY() - vyska / 2);
        dira.nakresli();
        elipsa.nakresli();
    }
}
