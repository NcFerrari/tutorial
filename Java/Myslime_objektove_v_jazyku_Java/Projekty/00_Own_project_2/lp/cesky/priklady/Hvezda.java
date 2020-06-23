package lp.cesky.priklady;

import lp.cesky.tvary.*;

public class Hvezda implements IHybaci {
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private static int vytvorenychInstanci = 0;
    
    private final int poradi = ++vytvorenychInstanci;
    private final String nazev = getClass().getName() + "_" + poradi;
    private final Trojuhelnik severniTrojuhelnik;
    private final Trojuhelnik jizniTrojuhelnik;
    
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    
    public static void zaramuj(int sirka, int vyska) {
        AP.setKrokRozmer(1, sirka, vyska);
        new Hvezda(0, 0, sirka, vyska).nakresli();
    }
    
    public Hvezda() {
        this(0, 0);
    }
    
    public Hvezda(int x, int y) {
        this(x, y, 60, 80);
    }
    
    public Hvezda(int x, int y, int sirka, int vyska) {
        this(x, y, sirka, vyska, Barva.ZLATA);
    }
    
    public Hvezda(int x, int y, int sirka, int vyska, Barva barva) {
        severniTrojuhelnik = new Trojuhelnik(0, 0, 0, 0, Smer8.SEVER);
        jizniTrojuhelnik = new Trojuhelnik(0, 0, 0, 0, Smer8.JIH);
        setPozice(x, y);
        setRozmer(sirka, vyska);
        setBarva(barva);
        AP.pridej(this);
    }
    
    public Hvezda(Pozice pozice) {
        this(pozice.getX(), pozice.getY());
    }
    
    public Hvezda(Rozmer rozmer) {
        this(0, 0, rozmer.getSirka(), rozmer.getVyska());
    }
    
    public Hvezda(Pozice pozice, Rozmer rozmer) {
        this(new Oblast(pozice, rozmer));
    }
    
    public Hvezda(Oblast oblast) {
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
        return severniTrojuhelnik.getBarva();
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
        severniTrojuhelnik.nakresli(kreslitko);
        jizniTrojuhelnik.nakresli(kreslitko);
    }
    
    public void smaz() {
        AP.odstran(this);
        AP.odstran(severniTrojuhelnik);
        AP.odstran(jizniTrojuhelnik);
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
        severniTrojuhelnik.setPozice(x, y);
        jizniTrojuhelnik.setPozice(x, y + vyska / 4);
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        severniTrojuhelnik.setRozmer(sirka, 3 * vyska / 4);
        jizniTrojuhelnik.setRozmer(sirka, 3 * vyska / 4);
        setPozice(getX(), getY());
    }
    
    public void setBarva(Barva barva) {
        severniTrojuhelnik.setBarva(barva);
        jizniTrojuhelnik.setBarva(barva);
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
