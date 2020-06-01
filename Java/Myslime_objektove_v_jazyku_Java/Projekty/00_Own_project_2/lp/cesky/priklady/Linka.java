package lp.cesky.priklady;

import lp.cesky.tvary.*;
import java.util.List;
import java.util.ArrayList;

public class Linka {
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private final int velikostZastavky = 20;
    private final int v2 = velikostZastavky / 2;
    
    private IZastavka prvniZastavka;
    private Barva barvaLinky;
    
    public Linka(Barva barva, int x1, int y1, int x2, int y2) {
        this(barva, new int[]{x1, y1, x2, y2});
    }
    
    public Linka(Barva barva, int...args) {
        if(args.length > 3 && args.length % 2 == 0) {
            AP.setRozmer(7, 7);
            AP.setMrizka(false);
            barvaLinky = barva;
            prvniZastavka = new Zastavka(args[0], args[1], velikostZastavky, barvaLinky, this);
            ((Zastavka)prvniZastavka).setDalsiZastavka(prvniZastavka);
            
            IZastavka zastavka = prvniZastavka;
            for(int i = 2; i < args.length; i += 2) {
                zastavka = pridejZa(zastavka, args[i], args[i+1]);
            }
        }
        
    }
    
    public IZastavka pridejZa(IZastavka zastavka, int x, int y) {
        Zastavka novaZastavka = new Zastavka(x, y, velikostZastavky, barvaLinky, this);
        novaZastavka.setPredchoziZastavka(zastavka);
        novaZastavka.setDalsiZastavka(zastavka.getDalsiZastavka());
        ((Zastavka)zastavka).setDalsiZastavka(novaZastavka);
        ((Zastavka)novaZastavka.getDalsiZastavka()).setPredchoziZastavka(novaZastavka);
        return novaZastavka;
    }
    
    public void odstran(IZastavka zastavka) {
        if(zastavka == prvniZastavka) {
            prvniZastavka = zastavka.getDalsiZastavka();
        }
        ((Zastavka)zastavka).odstran();
    }
    
    public IZastavka getPrvni() {
        return prvniZastavka;
    }
    
    public IZastavka getPosledni() {
        return prvniZastavka.getPredchoziZastavka();
    }
    
    public void zrus() {
        IZastavka zastavka = prvniZastavka;
        do {
            ((Zastavka)zastavka).odstran();
            zastavka = zastavka.getDalsiZastavka();
        } while(zastavka != prvniZastavka);
    }
    
    private class Zastavka implements IKresleny, IZastavka {
        private final Elipsa elipsa;
        private final Linka linka;
        private final Cara caraKPredchoziZastavce;
        private int s2;
        
        private IZastavka predchoziZastavka;
        private IZastavka dalsiZastavka;
        
        public Zastavka(int x, int y, int size, Barva barva, Linka linka) {
            elipsa = new Elipsa(x, y, size, size, barva);
            this.linka = linka;
            s2 = size / 2;
            caraKPredchoziZastavce = new Cara(0, 0, 0, 0, barva);
            AP.pridej(this);
        }
        
        public Linka getLinka() {
            return linka;
        }
         
        public int getX() {
            return elipsa.getX();
        }
        
        public int getY() {
            return elipsa.getY();
        }
        
        public void setDalsiZastavka(IZastavka dalsiZastavka) {
            this.dalsiZastavka = dalsiZastavka;
        }
        
        public IZastavka getDalsiZastavka() {
            return dalsiZastavka;
        }
        
        public void setPredchoziZastavka(IZastavka predchoziZastavka) {
            this.predchoziZastavka = predchoziZastavka;
            caraKPredchoziZastavce.spoj(predchoziZastavka.getX() + s2, predchoziZastavka.getY() + s2, getX() + s2, getY() + s2);
        }
        
        public IZastavka getPredchoziZastavka() {
            return predchoziZastavka;
        }
        
        public void nakresli(Kreslitko kreslitko) {
            elipsa.nakresli(kreslitko);
            caraKPredchoziZastavce.nakresli(kreslitko);
        }
        
        public void odstran() {
            ((Zastavka)getDalsiZastavka()).setPredchoziZastavka(getPredchoziZastavka());
            ((Zastavka)getPredchoziZastavka()).setDalsiZastavka(getDalsiZastavka());
            AP.odstran(this);
        }
    }
}