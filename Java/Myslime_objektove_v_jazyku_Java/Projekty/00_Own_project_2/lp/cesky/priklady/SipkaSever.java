package lp.cesky.priklady;

import lp.cesky.tvary.*;

public class SipkaSever implements ISipka {
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private final Obdelnik telo = new Obdelnik();
    private final Trojuhelnik smer = new Trojuhelnik();
    private final Presouvac presouvac;
    private final Barva barva;
    
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    
    public SipkaSever() {
        this(0, 0, AP.getKrok(), AP.getKrok(), Barva.CERNA);
    }
    
    public SipkaSever(int x, int y, int sirka, int vyska, int presouvacHodnota) {
        this(x, y, sirka, vyska, Barva.CERNA, presouvacHodnota);
    }
    
    public SipkaSever(int x, int y, int sirka, int vyska, Barva barva) {
        this(x, y, sirka, vyska, barva, 4);
    }
    
    public SipkaSever(int x, int y, int sirka, int vyska, Barva barva, int presouvacHodnota) {
        setRozmer(sirka, vyska);
        setPozice(x, y);
        AP.pridej(this);
        telo.setBarva(barva);
        smer.setBarva(barva);
        smer.setSmer(Smer8.SEVER);
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
        telo.setPozice(x + getSirka() / 2 - telo.getSirka() / 2, y + getVyska() / 3);
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
        telo.setRozmer(sirka / 2, 2 * vyska / 3);
        smer.setRozmer(sirka, vyska / 3);
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
        presouvac.presunO(this, 0, -AP.getKrok());
    }
    
    public SipkaZapad vlevoVbok() {
        AP.odstran(this);
        return new SipkaZapad(getX(), getY(), getSirka(), getVyska(), getBarva());
    }
    
    public SipkaVychod vpravoVbok() {
        AP.odstran(this);
        return new SipkaVychod(getX(), getY(), getSirka(), getVyska(), getBarva());
    }
}
