

public class Psouk {
    
    private final int delay = 500;
    
    private int sila;
    
    public Psouk() {
        this(1);
    }
    
    public Psouk(int sila) {
        setSila(sila);
    }
    
    
    public void setSila(int sila) {
        this.sila = sila;
    }
    
    public int getSila() {
        return sila;
    }
    
    
    public void prifoukni(INafukovaci objekt) {
        prifuk(objekt);
        prifuk(objekt);
        prifuk(objekt);
    }
    
    public void ufoukni(INafukovaci objekt) {
        odfuk(objekt);
        odfuk(objekt);
        odfuk(objekt);
    }
    
    private void prifuk(INafukovaci objekt) {
        objekt.setRozmer(objekt.getSirka() + getSila(), objekt.getVyska() + getSila());
        objekt.setPozice(objekt.getX() - getSila() / 2, objekt.getY() - getSila() / 2);
        P.cekej(delay);
    }
    
    private void odfuk(INafukovaci objekt) {
        objekt.setRozmer(objekt.getSirka() - getSila(), objekt.getVyska() - getSila());
        objekt.setPozice(objekt.getX() + getSila() / 2, objekt.getY() + getSila() / 2);
        P.cekej(delay);
    }
}
