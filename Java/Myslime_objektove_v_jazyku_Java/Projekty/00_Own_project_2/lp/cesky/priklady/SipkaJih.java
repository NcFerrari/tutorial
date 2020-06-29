package lp.cesky.priklady;

import lp.cesky.tvary.*;

public class SipkaJih extends ASipka {
    
    public SipkaJih() {
        this(0, 0, AP.getKrok(), AP.getKrok(), Barva.CERNA);
    }
    
    public SipkaJih(int x, int y, int sirka, int vyska, int presouvacHodnota) {
        this(x, y, sirka, vyska, Barva.CERNA, presouvacHodnota);
    }
    
    public SipkaJih(int x, int y, int sirka, int vyska, Barva barva) {
        this(x, y, sirka, vyska, barva, 4);
    }
    
    public SipkaJih(int x, int y, int sirka, int vyska, Barva barva, int presouvacHodnota) {
        super(x, y, sirka, vyska, barva, presouvacHodnota);
        smer.setSmer(Smer8.JIH);
    }
    
    public void setPozice(int x, int y) {
        super.setPozice(x, y);
        telo.setPozice(x + getSirka() / 2 - telo.getSirka() / 2, y);
        smer.setPozice(x, y + 2 * getVyska() / 3);
    }
    
    public void setRozmer(int sirka, int vyska) {
        super.setRozmer(sirka, vyska);
        telo.setRozmer(sirka / 2, 2 * vyska / 3);
        smer.setRozmer(sirka, vyska / 3);
        setPozice(getX(), getY());
    }
        
    public void vpred() {
        presouvac.presunO(this, 0, AP.getKrok());
    }
    
    public SipkaVychod vlevoVbok() {
        AP.odstran(this);
        return new SipkaVychod(getX(), getY(), getSirka(), getVyska(), getBarva());
    }
    
    public SipkaZapad vpravoVbok() {
        AP.odstran(this);
        return new SipkaZapad(getX(), getY(), getSirka(), getVyska(), getBarva());
    }
}
