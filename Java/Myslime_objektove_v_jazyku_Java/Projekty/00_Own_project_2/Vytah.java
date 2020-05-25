import java.util.*;

public class Vytah implements IPosuvny, IKresleny {
    
    public static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private final Obdelnik vytah;
    private IPosuvny objekt;
    private final Obdelnik dvere;
    
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    private Presouvac presouvac = new Presouvac(2);
    private Kompresor kompresor = new Kompresor();
    
    public Vytah() {
        this(AP.getKrok() * 3, AP.getKrok() * AP.getVyska() - AP.getKrok());
    }
    
    public Vytah(int pozice) {
        this(pozice, 2, Barva.CERNA);
    }
    
    public Vytah(int x, int y) {
        this(x, y, AP.getKrok(), AP.getKrok());
    }
    
    public Vytah(Pozice pozice) {
        this(pozice.getX(), pozice.getY());
    }
    
    public Vytah(int pozice, int rychlost, Barva barva) {
        this(pozice * AP.getKrok(), AP.getKrok() * (AP.getVyska() - 1), AP.getKrok(), AP.getKrok(), barva);
        presouvac = new Presouvac(rychlost);
    }
    
    public Vytah(int x, int y, int sirka, int vyska) {
        this(x, y, sirka, vyska, Barva.CERNA);
    }
    
    public Vytah(Oblast oblast) {
        this(oblast.getPozice(), oblast.getRozmer());
    }
    
    public Vytah(Pozice pozice, Rozmer rozmer) {
        this(pozice.getX(), pozice.getY(), rozmer.getSirka(), rozmer.getVyska());
    }
    
    public Vytah(int x, int y, int sirka, int vyska, Barva barva) {
        vytah = new Obdelnik(getX(), getY(), getSirka(), getVyska(), barva);
        dvere = new Obdelnik(getX(), getY(), 0, getVyska(), barva);
        AP.pridej(vytah);
        AP.pridej(dvere);
        setPozice(x, y);
        setRozmer(sirka, vyska);
        dvere.setRozmer(0, getVyska());
   }
    
    public void setX(int x) {
        this.x = x;
        vytah.setPozice(getX(), getY());
        if(objekt != null) {
            objekt.setPozice(getX(), getY());
        }
        dvere.setPozice(getX(), getY());
    }
    
    public int getX() {
        return x;
    }
        
    public void setY(int y) {
        this.y = y;
        vytah.setPozice(getX(), getY());
        if(objekt != null) {
            objekt.setPozice(getX(), getY());
        }
        dvere.setPozice(getX(), getY());
    }
    
    public int getY() {
        return y;
    }
        
    public void setSirka(int sirka) {
        this.sirka = sirka;
        vytah.setRozmer(getSirka(), getVyska());
        if(objekt != null) {
            ((INafukovaci)objekt).setRozmer(getSirka(), getVyska());
        }
        dvere.setRozmer(getSirka(), getVyska());
    }
    
    public int getSirka() {
        return sirka;
    }

    public void setVyska(int vyska) {
        this.vyska = vyska;
        vytah.setRozmer(getSirka(), getVyska());
        if(objekt != null) {
            ((INafukovaci)objekt).setRozmer(getSirka(), getVyska());
        }
        dvere.setRozmer(getSirka(), getVyska());
    }
    
    public int getVyska() {
        return vyska;
    }
    
    public void setPozice(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public void setPozice(Pozice pozice) {
        setPozice(pozice.getX(), pozice.getY());
    }
    
    public Pozice getPozice() {
        return new Pozice(getX(), getY());
    }
    
    public void setRozmer(int sirka, int vyska) {
        setSirka(sirka);
        setVyska(vyska);
    }
    
    public void setRozmer(Rozmer rozmer) {
        setRozmer(rozmer.getSirka(), rozmer.getVyska());
    }
    
    public Rozmer getRozmer() {
        return new Rozmer(getSirka(), getVyska());
    }
    
    public void setOblast(Oblast oblast) {
        setPozice(oblast.getX(), oblast.getY());
        setRozmer(oblast.getSirka(), oblast.getVyska());
    }
    
    public Oblast getOblast() {
        return new Oblast(getX(), getY(), getSirka(), getVyska());
    }
    
    
    public void nakresli(Kreslitko kreslitko) {
        vytah.nakresli(kreslitko);
        dvere.nakresli(kreslitko);
    }
    
    public void presunDoPatra(int patro) {
        presouvac.presunNa(this, getX(), (AP.getVyska() - patro - 1) * AP.getKrok());
    }
    
    public void nastup(IPosuvny objekt) {
        AP.pridejNad(this, (IKresleny) objekt);
        this.objekt = objekt;
        AP.pridejNad((IKresleny) objekt, dvere);
        presouvac.presunNa(objekt, getX(), getY());
        kompresor.nafoukniNa(dvere, getSirka(), getVyska());
    }
    
    public void vystupVpravo(IPosuvny objekt) {
        vystup(AP.getKrok());
    }
    
    public void vystupVlevo(IPosuvny objekt) {
        vystup(-AP.getKrok());
    }
    
    public void prijedK(IPosuvny objekt) {
        presunDoPatra((((AP.getVyska() * AP.getKrok()) - objekt.getY()) / AP.getKrok()) - 1);
    }
    
    public void odvezAVystupVlevo(IPosuvny objekt, int doPatra) {
        vystupVeSmeru(objekt, doPatra);
        vystupVlevo(objekt);
    }
    
    public void odvezAVystupVpravo(IPosuvny objekt, int doPatra) {
        vystupVeSmeru(objekt, doPatra);
        vystupVpravo(objekt);
    }
    
    private void vystup(int vzdalenost) {
        kompresor.nafoukniNa(dvere, 0, getVyska());  
        presouvac.presunNa(objekt, getX() + vzdalenost, getY());
        this.objekt = null;
    }
    
    private void vystupVeSmeru(IPosuvny objekt, int doPatra) {
        prijedK(objekt);
        nastup(objekt);
        presunDoPatra(doPatra);
    }
}
