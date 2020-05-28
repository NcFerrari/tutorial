package lp.cesky.priklady;

import lp.cesky.tvary.*;

public class Panenka implements IHybaci {
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private static int vytvorenychInstanci = 0;
    
    private final int poradi = ++vytvorenychInstanci;
    private final String nazev = getClass().getName() + "_" + poradi;
    private final Elipsa hlava;
    private final Trojuhelnik telo;
    private final Obdelnik levaNoha;
    private final Obdelnik pravaNoha;
    
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    
    public static void zaramuj(int sirka, int vyska) {
        AP.setKrokRozmer(1, sirka, vyska);
        new Panenka(0, 0, sirka, vyska).nakresli();
    }
    
    public Panenka() {
        this(0, 0);
    }
    
    public Panenka(int x, int y) {
        this(x, y, 40, 80);
    }
    
    public Panenka(int x, int y, int sirka, int vyska) {
        this(x, y, sirka, vyska, Barva.RUZOVA);
    }
    
    public Panenka(int x, int y, int sirka, int vyska, Barva barva) {
        hlava = new Elipsa(0, 0, 0, 0);
        telo = new Trojuhelnik(0, 0, 0, 0, Smer8.SEVER);
        levaNoha = new Obdelnik(0, 0, 0, 0);
        pravaNoha = new Obdelnik(0, 0, 0, 0);
        setPozice(x, y);
        setRozmer(sirka, vyska);
        setBarva(barva);
        AP.pridej(this);
    }
    
    public Panenka(Pozice pozice) {
        this(pozice.getX(), pozice.getY());
    }
    
    public Panenka(Rozmer rozmer) {
        this(0, 0, rozmer.getSirka(), rozmer.getVyska());
    }
    
    public Panenka(Pozice pozice, Rozmer rozmer) {
        this(new Oblast(pozice, rozmer));
    }
    
    public Panenka(Oblast oblast) {
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
        return hlava.getBarva();
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
        hlava.nakresli(kreslitko);
        telo.nakresli(kreslitko);
        levaNoha.nakresli(kreslitko);
        pravaNoha.nakresli(kreslitko);
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
        hlava.setPozice(x + 7 * sirka / 40, y);
        telo.setPozice(x, y + vyska / 4);
        levaNoha.setPozice(x + sirka / 5, y + 13 * vyska / 16);
        pravaNoha.setPozice(x + 13 * sirka / 20, y + 13 * vyska / 16);
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        hlava.setRozmer(13 * sirka / 20, 13 * vyska / 40);
        telo.setRozmer(sirka, (9 * vyska / 16) + 2);
        levaNoha.setRozmer(sirka / 5, 3 * vyska / 16);
        pravaNoha.setRozmer(sirka / 5, 3 * vyska / 16);
        setPozice(getX(), getY());
    }
    
    public void setBarva(Barva barva) {
        hlava.setBarva(barva);
        telo.setBarva(barva);
        levaNoha.setBarva(barva);
        pravaNoha.setBarva(barva);
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
