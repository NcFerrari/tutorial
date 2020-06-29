package lp.cesky.priklady;

import lp.cesky.tvary.*;

public class SipkaSever extends ASipka {
    
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
        super(x, y, sirka, vyska, barva, presouvacHodnota);
        smer.setSmer(Smer8.SEVER);
    }
    
    public void setPozice(int x, int y) {
        super.setPozice(x, y);
        telo.setPozice(x + getSirka() / 2 - telo.getSirka() / 2, y + getVyska() / 3);
        smer.setPozice(x, y);
    }
    
    public void setRozmer(int sirka, int vyska) {
        super.setRozmer(sirka, vyska);
        telo.setRozmer(sirka / 2, 2 * vyska / 3);
        smer.setRozmer(sirka, vyska / 3);
        setPozice(getX(), getY());
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
