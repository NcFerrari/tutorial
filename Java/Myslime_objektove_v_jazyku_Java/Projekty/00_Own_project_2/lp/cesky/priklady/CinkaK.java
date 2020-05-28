package lp.cesky.priklady;

import lp.cesky.tvary.*;

public class CinkaK implements IHybaci {
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private static int vytvorenychInstanci = 0;
    
    private final int poradi = ++vytvorenychInstanci;
    private final String nazev = getClass().getName() + "_" + poradi;
    private final Elipsa leveZavazi;
    private final Obdelnik tycka;
    private final Elipsa praveZavazi;
    
    private int x;
    private int y;
    private int sirka;
    private int vyska;
        
    public static void zaramuj(int sirka, int vyska) {
        AP.setKrokRozmer(1, sirka, vyska);
        new CinkaK(0, 0, sirka, vyska).nakresli();
    }
    
    public CinkaK() {
        this(0, 0);
    }
    
    public CinkaK(int x, int y) {
        this(x, y, 100, 30);
    }
    
    public CinkaK(int x, int y, int sirka, int vyska) {
        this(x, y, sirka, vyska, Barva.HNEDA);
    }
    
    public CinkaK(int x, int y, int sirka, int vyska, Barva barva) {
        leveZavazi = new Elipsa(0, 0, 0, 0);
        tycka = new Obdelnik(0, 0, 0, 0);
        praveZavazi = new Elipsa(0, 0, 0, 0);
        setPozice(x, y);
        setRozmer(sirka, vyska);
        setBarva(barva);
        AP.pridej(this);
    }
    
    public CinkaK(Pozice pozice) {
        this(pozice.getX(), pozice.getY());
    }
    
    public CinkaK(Rozmer rozmer) {
        this(0, 0, rozmer.getSirka(), rozmer.getVyska());
    }
    
    public CinkaK(Pozice pozice, Rozmer rozmer) {
        this(new Oblast(pozice, rozmer));
    }
    
    public CinkaK(Oblast oblast) {
        this(oblast.getX(), oblast.getY(), oblast.getSirka(), oblast.getVyska());
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
    
    public Barva getBarva() {
        return leveZavazi.getBarva();
    }
    
    public String getNazev() {
        return nazev;
    }
    
    public void setOblast(Oblast oblast) {
        setPozice(oblast.getPozice());
        setRozmer(oblast.getRozmer());
    }
    
    public Oblast getOblast() {
        return new Oblast(getPozice(), getRozmer());
    }
    
    public void setPozice(Pozice pozice) {
        setPozice(pozice.getX(), pozice.getY());
    }
    
    public Pozice getPozice() {
        return new Pozice(getX(), getY());
    }
    
    public void setRozmer(Rozmer rozmer) {
        setRozmer(rozmer.getSirka(), rozmer.getVyska());
    }
    
    public Rozmer getRozmer() {
        return new Rozmer(getSirka(), getVyska());
    }
    
    
    public void nakresli() {
        AP.pridej(this);
    }
    
    public void nakresli(Kreslitko kreslitko) {
        leveZavazi.nakresli(kreslitko);
        tycka.nakresli(kreslitko);
        praveZavazi.nakresli(kreslitko);
    }
    
    public void smaz() {
        AP.odstran(this);
    }
    
    public void posunDolu(int vzdalenost) {
        setPozice(getX(), getY() + vzdalenost);
    }
    
    public void posunVpravo(int vzdalenost) {
        setPozice(getX() + vzdalenost, getY());
    }
    
    public void posunDolu() {
        posunDolu(AP.getKrok());
    }
    
    public void posunVpravo() {
        posunVpravo(AP.getKrok());
    }
    
    public void posunVzhuru() {
        posunDolu(-AP.getKrok());
    }
    
    public void posunVlevo() {
        posunVpravo(-AP.getKrok());
    }
    
    public void setPozice(int x, int y) {
        this.x = x;
        this.y = y;
        leveZavazi.setPozice(x, y);
        tycka.setPozice(x + 3 * sirka / 10, y + 2 * vyska / 5);
        praveZavazi.setPozice(x + 7 * sirka / 10, y);
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        leveZavazi.setRozmer(3 * sirka / 10, vyska);
        tycka.setRozmer((2 * sirka / 5) + 2, vyska / 5);
        praveZavazi.setRozmer(3 * sirka / 10, vyska);
        setPozice(getX(), getY());
    }
    
    public void setBarva(Barva barva) {
        leveZavazi.setBarva(barva);
        tycka.setBarva(barva);
        praveZavazi.setBarva(barva);
    }
    
    public void zaramuj() {
        AP.odstranVse();
        AP.setKrokRozmer(1, getSirka(), getVyska());
        setPozice(0, 0);
        AP.pridej(this);
    }
    
    @Override
    public String toString() {
        return String.format("%s: x=%d, y=%d, šíøka=%d, výška=%d",
                            getNazev(), getX(), getY(), getSirka(), getVyska());
    }
}
