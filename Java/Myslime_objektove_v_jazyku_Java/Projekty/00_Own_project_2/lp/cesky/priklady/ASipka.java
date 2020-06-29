/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Pøíliš luouèkı kùò úpìl ïábelské ódy. */
package lp.cesky.priklady;

import lp.cesky.tvary.*;



/*******************************************************************************
 * Instance rozhraní {@code ISipka} pøedstavují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public abstract class ASipka extends AHybaci
{
    protected static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    protected final Obdelnik telo = new Obdelnik();
    protected final Trojuhelnik smer = new Trojuhelnik();
    protected final Presouvac presouvac;
    
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    
    public ASipka() {
        this(0, 0, AP.getKrok(), AP.getKrok(), Barva.CERNA);
    }
    
    public ASipka(int x, int y, int sirka, int vyska, int presouvacHodnota) {
        this(x, y, sirka, vyska, Barva.CERNA, presouvacHodnota);
    }
    
    public ASipka(int x, int y, int sirka, int vyska, Barva barva) {
        this(x, y, sirka, vyska, barva, 4);
    }
    
    public ASipka(int x, int y, int sirka, int vyska, Barva barva, int presouvacHodnota) {
        super(x, y, sirka, vyska, barva);
        setRozmer(sirka, vyska);
        setPozice(x, y);
        telo.setBarva(barva);
        smer.setBarva(barva);
        this.presouvac = new Presouvac(presouvacHodnota);
        AP.pridej(this);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getSirka() {
        return sirka;
    }
    
    public int getVyska() {
        return vyska;
    }
    
    public void setPozice(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
    }
    
    public void nakresli(Kreslitko kreslitko) {
        telo.nakresli(kreslitko);
        smer.nakresli(kreslitko);
    }
    
    public abstract void vpred();
    
    public abstract ASipka vlevoVbok();
    
    public abstract ASipka vpravoVbok();
}
