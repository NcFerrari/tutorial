package lp.cesky.priklady;

import lp.cesky.tvary.*;

public class XObdelnik extends AHybaci {
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private final Obdelnik obdelnik;
    private final Cara e;
    private final Cara f;
    
    public XObdelnik() {
        this(AP.getKrok(), AP.getKrok() / 2, AP.getKrok() * 2, AP.getKrok());
    }
    
    public XObdelnik(int x, int y, int sirka, int vyska) {
        this(x, y, sirka, vyska, Barva.FIALOVA);
    }
    
    public XObdelnik(int x, int y, int sirka, int vyska, Barva barva) {
        super(x, y, sirka, vyska, barva);
        obdelnik = new Obdelnik();
        obdelnik.setBarva(barva);
        e = new Cara();
        f = new Cara();
        setRozmer(sirka, vyska);
        setPozice(x, y);
        AP.pridej(this);
        nazev = XObdelnik.class.getName();
    }
    
    @Override
    public int getX() {
        return super.getX() + getSirka() / 2;
    }
    
    @Override
    public int getY() {
        return super.getY() + getVyska() / 2;
    }
    
    @Override
    public void setPozice(int x, int y) {
        super.setPozice(x - getSirka() / 2, y - getVyska() / 2);
        obdelnik.setPozice(x - getSirka() / 2, y - getVyska() / 2);
        e.setPozice(x - getSirka() / 2, y - getVyska() / 2);
        f.setPozice(x - getSirka() / 2, y + getVyska() / 2);
    }
    
    @Override
    public void setRozmer(int sirka, int vyska) {
        int x = getX();
        int y = getY();
        super.setRozmer(sirka, vyska);
        obdelnik.setRozmer(sirka, vyska);
        e.spoj(e.getX(), e.getY(), e.getX() + sirka, e.getY() + getVyska());
        f.spoj(f.getX(), f.getY() + getVyska(), f.getX() + sirka, f.getY());
        setPozice(x, y);
    }
    
    @Override
    public void setBarva(Barva barva) {
        obdelnik.setBarva(barva);
    }
    
    @Override
    public void nakresli(Kreslitko kreslitko) {
        obdelnik.nakresli(kreslitko);
        e.nakresli(kreslitko);
        f.nakresli(kreslitko);
    }
    
}
