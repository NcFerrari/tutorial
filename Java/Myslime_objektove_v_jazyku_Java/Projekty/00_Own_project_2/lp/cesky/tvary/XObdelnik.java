package lp.cesky.tvary;



public class XObdelnik extends Obdelnik {
    
    private final Cara e;
    private final Cara f;
    
    public XObdelnik() {
        this(0, 0, 100, 50);
    }
    
    public XObdelnik(int x, int y, int sirka, int vyska) {
        super(x - sirka / 2, y - vyska / 2, sirka, vyska);
        e = new Cara();
        f = new Cara();
        AP.pridej(this);
        setRozmer(sirka, vyska);
        setPozice(x, y);
    }
    
    @Override
    public void setPozice(int x, int y) {
        super.setPozice(x, y);
        e.setPozice(x, y);
        f.setPozice(x, y + getVyska());
    }
    
    @Override
    public void setRozmer(int sirka, int vyska) {
        super.setRozmer(sirka, vyska);
        e.setKPozice(getX() + sirka, getY() + getVyska());
        f.setKPozice(getX() + sirka, getY());
    }
    
    @Override
    public void nakresli(Kreslitko kreslitko) {
        super.nakresli(kreslitko);
        e.nakresli(kreslitko);
        f.nakresli(kreslitko);
    }
    
}
