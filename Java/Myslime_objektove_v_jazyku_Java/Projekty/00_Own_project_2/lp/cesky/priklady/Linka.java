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
    private int rychlost = 4;
    
    public static Linka vytvorVnejsi(int rychlost) {
        Linka linka = new Linka(Barva.MODRA, new int[]{25, 25, 25, 275, 175, 325, 325, 275, 325, 25});
        linka.setRychlost(rychlost);
        return linka;
    }
    
    public static Linka vytvorStredni(int rychlost) {
        Linka linka = new Linka(Barva.CERVENA, new int[]{75, 75, 75, 225, 175, 275, 275, 225, 275, 75});
        linka.setRychlost(rychlost);
        return linka;
    }
    
    public static Linka vytvorVnitrni(int rychlost) {
        Linka linka = new Linka(Barva.ZELENA, new int[]{125, 125, 125, 175, 175, 225, 225, 175, 225, 125});
        linka.setRychlost(rychlost);
        return linka;
    }
    
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
        novaZastavka.setPredchozi(zastavka);
        novaZastavka.setDalsiZastavka(zastavka.getNasledujici());
        ((Zastavka)zastavka).setDalsiZastavka(novaZastavka);
        ((Zastavka)novaZastavka.getNasledujici()).setPredchozi(novaZastavka);
        return novaZastavka;
    }
    
    public void odstran(IZastavka zastavka) {
        if(zastavka == prvniZastavka) {
            prvniZastavka = zastavka.getNasledujici();
        }
        ((Zastavka)zastavka).odstran();
    }
    
    public IZastavka getPrvni() {
        return prvniZastavka;
    }
    
    public IZastavka getPosledni() {
        return prvniZastavka.getPredchozi();
    }
    
    public void zrus() {
        IZastavka zastavka = prvniZastavka;
        do {
            zastavka = zastavka.getNasledujici();
            odstran(zastavka);
        } while(zastavka != prvniZastavka);
    }
    
    public void setRychlost(int rychlost) {
        this.rychlost = rychlost;
    }
    
    public int getRychlost() {
        return rychlost;
    }
        
    public int getVelikostZastavky() {
        return velikostZastavky;
    }
    
    public int getCekani() {
        return rychlost;
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
        
        public Pozice getPozice() {
            return new Pozice(getX(), getY());
        }
        
        public void setDalsiZastavka(IZastavka dalsiZastavka) {
            this.dalsiZastavka = dalsiZastavka;
        }
        
        public IZastavka getNasledujici() {
            return dalsiZastavka;
        }
        
        public void setPredchozi(IZastavka predchoziZastavka) {
            this.predchoziZastavka = predchoziZastavka;
            caraKPredchoziZastavce.spoj(predchoziZastavka.getX() + s2, predchoziZastavka.getY() + s2, getX() + s2, getY() + s2);
        }
        
        public IZastavka getPredchozi() {
            return predchoziZastavka;
        }
        
        public void nakresli(Kreslitko kreslitko) {
            elipsa.nakresli(kreslitko);
            caraKPredchoziZastavce.nakresli(kreslitko);
        }
        
        public void odstran() {
            ((Zastavka)getNasledujici()).setPredchozi(getPredchozi());
            ((Zastavka)getPredchozi()).setDalsiZastavka(getNasledujici());
            AP.odstran(this);
        }
    }
}