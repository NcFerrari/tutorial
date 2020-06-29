package lp.cesky.priklady;

import lp.cesky.tvary.*;

public class SipkaZapad extends ASipka  {
        
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
        super(x, y, sirka, vyska, barva, presouvacHodnota);
        smer.setSmer(Smer8.ZAPAD);
    }
    
    public void setPozice(int x, int y) {
        super.setPozice(x, y);
        telo.setPozice(x + getSirka() / 3, y + getVyska() / 2 - telo.getVyska() / 2);
        smer.setPozice(x, y);
    }
    
    public void setRozmer(int sirka, int vyska) {
        super.setRozmer(sirka, vyska);
        telo.setRozmer(2 * sirka / 3, vyska / 2);
        smer.setRozmer(sirka / 3, vyska);
        setPozice(getX(), getY());
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
