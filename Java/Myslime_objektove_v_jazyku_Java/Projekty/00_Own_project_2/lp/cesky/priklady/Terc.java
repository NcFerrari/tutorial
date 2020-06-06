package lp.cesky.priklady;

import lp.cesky.tvary.*;

public class Terc extends Kruh {
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private final Kruh stredni = new Kruh();
    private final Kruh vnitrni = new Kruh();
    private final Cara horizontalniCara = new Cara();
    private final Cara vertikalniCara = new Cara();
    
    public Terc() {
//         this(5 * AP.getKrok() / 2, 5 * AP.getKrok() / 2, AP.getKrok());
        this(AP.getKrok()/2, AP.getKrok()/2, AP.getKrok());
    }
    
    public Terc(int x, int y, int rozmer) {
        this(x, y, rozmer, Barva.ZLUTA, Barva.MODRA, Barva.CERVENA);
    }
    
    public Terc(int x, int y, int rozmer, Barva vnejsiBarva, Barva stredniBarva, Barva vnitrniBarva) {
        super();
        setBarva(vnejsiBarva);
        stredni.setBarva(stredniBarva);
        vnitrni.setBarva(vnitrniBarva);
        
        setRozmer(rozmer);
        setPozice(x, y);
//         AP.setRozmer(5, 5);
        AP.pridej(this);
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
    public void setRozmer(int rozmer) {
        int x = getX();
        int y = getY();
        super.setRozmer(rozmer);
        stredni.setRozmer(5 * rozmer / 8);
        vnitrni.setRozmer(rozmer / 4);
        setPozice(x, y);
    }
    
    @Override
    public void setPozice(int x, int y) {
        super.setPozice(x - getSirka() / 2, y - getVyska() / 2);
        stredni.setPozice(x - stredni.getSirka() / 2, y - stredni.getVyska() / 2);
        vnitrni.setPozice(x - vnitrni.getSirka() / 2, y - vnitrni.getVyska() / 2);
        horizontalniCara.spoj(x - getSirka() / 2, y, x + getSirka() / 2, y);
        vertikalniCara.spoj(x, y - getVyska() / 2, x, y + getVyska() / 2);
    }
    
    @Override
    public void nakresli(Kreslitko kreslitko) {
        super.nakresli(kreslitko);
        stredni.nakresli(kreslitko);
        vnitrni.nakresli(kreslitko);
        horizontalniCara.nakresli(kreslitko);
        vertikalniCara.nakresli(kreslitko);
    }
}
