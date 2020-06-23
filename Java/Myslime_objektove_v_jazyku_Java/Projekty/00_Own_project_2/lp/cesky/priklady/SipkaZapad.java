package lp.cesky.priklady;

import lp.cesky.tvary.*;

public class SipkaZapad implements ISipka {
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private final Obdelnik telo = new Obdelnik();
    private final Trojuhelnik smer = new Trojuhelnik();
    private final Presouvac presouvac;
    private final Barva barva;
    
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    
    public SipkaZapad() {
        this(0, 0, AP.getKrok(), AP.getKrok(), Barva.CERNA);
    }
    
    public SipkaZapad(int x, int y, int sirka, int vyska, int presouvacHodnota) {
        this(x, y, sirka, vyska, Barva.CERNA, presouvacHodnota);
    }
    
    public SipkaZapad(int x, int y, int sirka, int vyska, Barva barva) {
        this(x, y, sirka, vyska, barva, 4);
    }
    
    public SipkaZapad(int x, int y, int sirka, int vyska, Barva barva, int presouvacHodnota) {
        setRozmer(sirka, vyska);
        setPozice(x, y);
        telo.setBarva(barva);
        smer.setBarva(barva);
        smer.setSmer(Smer8.ZAPAD);
        this.barva = barva;
        this.presouvac = new Presouvac(presouvacHodnota);
    }
    
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setPozice(int x, int y) {
        this.x = x;
        this.y = y;
        telo.setPozice(x + sirka / 3, y + vyska / 2 - telo.getVyska() / 2);
        smer.setPozice(x, y);
    }
    
    public int getSirka() {
        return sirka;
    }
    
    public int getVyska() {
        return vyska;
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        telo.setRozmer(2 * sirka / 3, vyska / 2);
        smer.setRozmer(sirka / 3, vyska);
        setPozice(getX(), getY());
    }
    
    public Barva getBarva() {
        return barva;
    }
    
    
    public void nakresli(Kreslitko kreslitko) {
        telo.nakresli(kreslitko);
        smer.nakresli(kreslitko);
    }
    
    public void vpred() {
        presouvac.presunO(this, -AP.getKrok(), 0);
    }
    
    public SipkaJih vlevoVbok() {
        AP.odstran(this);
        return new SipkaJih(getX(), getY(), getSirka(), getVyska(), getBarva());
    }
    
    public SipkaSever vpravoVbok() {
        AP.odstran(this);
        return new SipkaSever(getX(), getY(), getSirka(), getVyska(), getBarva());
    }
}
