package lp.cesky.priklady;

import lp.cesky.tvary.*;

public class Kabina implements IHybaci, IMultiposuvny {
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    private static int pocet = 0;
    
    private final int id = ++pocet;
    private final IHybaci kabina;
    private final Text cislo;
    private final int velikostKabiny;
    private final Multipresouvac mp = Multipresouvac.getInstance();
    
    private Linka linka;
    private IZastavka zastavka;
    private int x, y, sirka, vyska;
    
    public Kabina(Linka linka) {
        this.linka = linka;
        zastavka = linka.getPrvni();
        velikostKabiny = linka.getVelikostZastavky();
        kabina = new Elipsa(zastavka.getX(), zastavka.getY(), velikostKabiny, velikostKabiny, Barva.ZLUTA);
        cislo = new Text("" + id, zastavka.getX() + velikostKabiny / 2 - 4, zastavka.getY() + velikostKabiny / 2 - 6);
        setPozice(zastavka.getX(), zastavka.getY());
        AP.pridej(this);
        posun();
    }
    
    public void posun() {
        if(linka != null) {
            zastavka = zastavka.getNasledujici();
            mp.presun(this, zastavka.getX(), zastavka.getY(), linka.getRychlost());
        }
    }
    
    public void nakresli(Kreslitko kreslitko) {
        kabina.nakresli(kreslitko);
        cislo.nakresli(kreslitko);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getSirka() {
        return sirka;
    }
    
    public int getVyska() {
        return vyska;
    }
    
    public void setPozice(int x, int y) {
        this.x = x;
        this.y = y;
        kabina.setPozice(x, y);
        cislo.setPozice(x + velikostKabiny / 2 - 4, y + velikostKabiny / 2 - 6);
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        kabina.setRozmer(sirka, vyska);
        setPozice(getX() - getSirka() / 2, getY() - getVyska());
    }
    
    public void presunuto() {
        posun();
    }
    
    public void skonci() {
        mp.zastav(this);
        AP.odstran(this);
        linka = null;
    }
}
