package rup.cesky.tvary;

import rup.cesky.spolecne.P;


/*******************************************************************************
 * Trida APosuvny je spolecnou rodicovskou tridou trid implementujicich
 * rozhrani IPosuvny. 
 *
 * @author     Rudolf Pecinovsky
 * @version    2.01, duben 2004
 */
public abstract class APosuvny implements IPosuvny
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Aktivni platno, ktere dohlizi na spravne vykresleni instance. */
    protected static final AktivniPlatno AP = AktivniPlatno.getPlatno();



//== PROMENNE ATRIBUTY TRIDY ===================================================

    /** Celkovy pocet vytvorenych instanci. */
    private static int pocet = 0;
    
    
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    /** Rodne cislo instance = jako kolikata byla vytvorena. */
    protected final int poradi = ++pocet;
  
  
    
//== PROMENNE ATRIBUTY INSTANCI ================================================

    /** Nazev sestavajici z nazvu tridy a poradi instance */
    protected String nazev;

    protected int    xPos;    //Bodova x-ova souradnice pocatku
    protected int    yPos;    //Bodova y-ova souradnice pocatku



//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori na zadanych souradnicich
     * instanci sirokou 100 bodu, vysokou 150 bodu
     * s kmenem zabirajicim 1/3 vyska a 1/10 sirky stromu.
     *
     * @param x       x-ova souradnice pocatku, x>=0, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y>=0, y=0 ma horni okraj platna
     */
    public APosuvny( int x, int y )
    {
        xPos  = x;
        yPos  = y;
        nazev = P.nazevTridy(this) + "_" + ++pocet;
    }



//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================

    /***************************************************************************
     * Vrati x-ovou souradnici pozice instance.
     *
     * @return  x-ova souradnice.
     */
    public int getX()
    {
        return xPos;
    }


    /***************************************************************************
     * Vrati y-ovou souradnici pozice instance.
     *
     * @return  y-ova souradnice.
     */
    public int getY()
    {
        return yPos;
    }


    /***************************************************************************
     * Vrati instanci tridy Pozice s pozici instance.
     *
     * @return   Pozice s pozici instance.
     */
    public Pozice getPozice()
    {
        return new Pozice( getX(), getY() );
    }


    /***************************************************************************
     * Nastavi novou pozici instance.
     *
     * @param x   Nova x-ova pozice instance
     * @param y   Nova y-ova pozice instance
     */
    public void setPozice(int x, int y)
    {
        xPos = x;
        yPos = y;
        AP.prekresli();
    }


    /***************************************************************************
     * Nastavi novou pozici instance.
     *
     * @param pozice   Nova pozice instance
     */
    public void setPozice(Pozice pozice)
    {
        setPozice( pozice.x, pozice.y );
    }


    /***************************************************************************
     * Vrati nazev instance, tj. nazev jeji tridy nasledovany poradim.
     *
     * @return  Retezec s nazvem instance.
     */
     public String getNazev()
     {
        return nazev;
     }



//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================

    /***************************************************************************
     * Vraci textovou reprezentaci dane instance
     * pouzivanou predevsim k ladicim ucelum.
     *      
     * @return Nazev instance nasledovnay jejimi souradnicemi.
     */
    public String toString()
    {
        return nazev + ": x=" + getX()  + ", y=" + getY();
    }


//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Prihlasi instanci u aktivniho platna do jeho spravy.
     */
    public void nakresli()
    {
        AP.pridej( this );
    }


    /***************************************************************************
     * Odstrani obraz sve instance z platna.
     */
    public void smaz()
    {
        AP.odstran( this );
    }


    /***************************************************************************
     * Presune instanci o zadany pocet bodu vpravo,
     * pri zaporne hodnote parametru vlevo.
     *
     * @param vzdalenost Vzdalenost, o kterou se instance presune.
     */
    public void posunVpravo(int vzdalenost)
    {
        setPozice( getX()+vzdalenost, getY() );
    }


    /***************************************************************************
     * Presune instanci o krok bodu vpravo.
     */
    public void posunVpravo()
    {
        posunVpravo( AP.getKrok() );
    }


    /***************************************************************************
     * Presune instanci o krok bodu vlevo.
     */
    public void posunVlevo()
    {
        posunVpravo( -AP.getKrok() );
    }


    /***************************************************************************
     * Presune instanci o zadany pocet bodu dolu,
     * pri zaporne hodnote parametru nahoru.
     *
     * @param vzdalenost    Pocet bodu, o ktere se instance presune.
     */
    public void posunDolu(int vzdalenost)
    {
        setPozice( getX(), getY()+vzdalenost );
    }


    /***************************************************************************
     * Presune instanci o krok bodu dolu.
     */
    public void posunDolu()
    {
        posunDolu( AP.getKrok() );
    }


    /***************************************************************************
     * Presune instanci o krok bodu nahoru.
     */
    public void posunVzhuru()
    {
        posunDolu( -AP.getKrok() );
    }



//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}


