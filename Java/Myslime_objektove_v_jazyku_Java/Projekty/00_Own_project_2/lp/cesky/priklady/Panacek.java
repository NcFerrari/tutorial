package lp.cesky.priklady;

import lp.cesky.tvary.*;

public class Panacek implements IKresleny, IPosuvny, INafukovaci {
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private static int vytvorenychInstanci = 0;
    
    private final int poradi = ++vytvorenychInstanci;
    private final String nazev = getClass().getName() + "_" + poradi;
    private final Elipsa hlava;
    private final Obdelnik telo;
    private final Obdelnik levaNoha;
    private final Obdelnik pravaNoha;
    
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    
    public static void zaramuj(int sirka, int vyska) {
        AP.setKrokRozmer(1, sirka, vyska);
        new Panacek(0, 0, sirka, vyska).nakresli();
    }
    
    public Panacek() {
        this(0, 0);
    }
    
    public Panacek(int x, int y) {
        this(x, y, 30, 80);
    }
    
    public Panacek(int x, int y, int sirka, int vyska) {
        this(x, y, sirka, vyska, Barva.MODRA);
    }
    
    public Panacek(int x, int y, int sirka, int vyska, Barva barva) {
        hlava = new Elipsa(0, 0, 0, 0);
        telo = new Obdelnik(0, 0, 0, 0);
        levaNoha = new Obdelnik(0, 0, 0, 0);
        pravaNoha = new Obdelnik(0, 0, 0, 0);
        setPozice(x, y);
        setRozmer(sirka, vyska);
        setBarva(barva);
    }
    
    public Panacek(Pozice pozice) {
        this(pozice.getX(), pozice.getY());
    }
    
    public Panacek(Rozmer rozmer) {
        this(0, 0, rozmer.getSirka(), rozmer.getVyska());
    }
    
    public Panacek(Pozice pozice, Rozmer rozmer) {
        this(new Oblast(pozice, rozmer));
    }
    
    public Panacek(Oblast oblast) {
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
        hlava.setPozice(x + sirka / 6, y);
        telo.setPozice(x, y + vyska / 4);
        levaNoha.setPozice(x + sirka / 5, y + 3 * vyska / 4);
        pravaNoha.setPozice(x + 3 * sirka / 5, y + 3 * vyska / 4);
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        hlava.setRozmer(2 * sirka / 3, vyska / 4);
        telo.setRozmer(sirka, vyska / 2);
        levaNoha.setRozmer(sirka / 5, vyska / 4);
        pravaNoha.setRozmer(sirka / 5, vyska / 4);
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
