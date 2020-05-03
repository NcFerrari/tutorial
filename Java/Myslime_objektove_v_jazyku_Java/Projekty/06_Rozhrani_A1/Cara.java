/*******************************************************************************
 * Trida pro praci s carou komunikujici s aktivnim platnem.
 * Cara je urcena svymi krajnimi body, pricemz souradnice pocatecniho bodu
 * je soucasne povazovana za pozici cele instance.
 *
 * Jedna se o vychozi podobu tridy v souboru projektu.
 *    
 * @author     Rudolf Pecinovsky
 * @version    2.01, duben 2004
 */
public class Cara implements IKresleny
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Pocatecni barva nakreslene instance v pripade,
     *  kdy uzivatel zadnou pozadovanou barvu nezada -
     *  pro caru Barva.CERNA. */
    public static final Barva IMPLICITNI_BARVA = Barva.CERNA;

    /** Aktivni platno, ktere dohlizi na spravne vykresleni instance. */
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();



//== PROMENNE ATRIBUTY TRIDY ===================================================

    /** Pocet vytvorenych instanci */
    private static int pocet = 0;



//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    /** Nazev sestavajici z nazvu tridy a poradi instance */
    private final String nazev;



//== PROMENNE ATRIBUTY INSTANCI ================================================

    private int    xPos;    //Bodova x-ova souradnice pocatku
    private int    yPos;    //Bodova y-ova souradnice pocatku
    private int    kx;      //xBodova -ova souradnice konce 
    private int    ky;      //Bodova y-ova souradnice konce
    private Barva  barva;   //Barva instance



//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori novou instanci s implicitnimi rozmery, umistenim a barvou.
     * Instance bude umistena v levem hornim rohu platna 
     * a bude mit implicitni barvu, 
     * Koncit bude ve stredu platna.
     */
    public Cara()
    {
        this( 0, 0, AP.getKrok()*AP.getSirka()/2, 
                    AP.getKrok()*AP.getVyska()/2 );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanou polohou a rozmery 
     * a implicitni barvou.
     *
     * @param x       x-ova souradnice pocatku, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y=0 ma horni okraj platna
     * @param sirka   Sirka vytvarene instance
     * @param vyska   Vyska vytvarene instance
     */
    public Cara(int x, int y, int kx, int ky)
    {
        this( x, y, kx, ky, IMPLICITNI_BARVA );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanou polohou a rozmery 
     * a implicitni barvou.
     *
     * @param pocatek   Pozice pocatku instance
     * @param konec     Pozice koncoveho bodu instance
     */
    public Cara(Pozice pocatek, Pozice konec)
    {
        this( pocatek.x, pocatek.y, konec.x, konec.y, IMPLICITNI_BARVA );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanou polohou a rozmery 
     * a implicitni barvou.
     *
     * @param pocatek   Pozice pocatku instance
     * @param konec     Pozice koncoveho bodu instance
     * @param barva     Barva vytvarene instance
     */
    public Cara(Pozice pocatek, Pozice konec, Barva barva)
    {
        this( pocatek.x, pocatek.y, konec.x, konec.y, barva );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanymi rozmery, polohou a barvou.
     *
     * @param x       x-ova souradnice pocatku, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y=0 ma horni okraj platna
     * @param sirka   Sirka vytvarene instance
     * @param vyska   Vyska vytvarene instance
     * @param barva   Barva vytvarene instance
     */
    public Cara(int x, int y, int kx, int ky, Barva barva)
    {
        this.nazev = P.nazevTridy(this) + "_" + ++pocet;
        this.xPos = x;
        this.yPos = y;
        this.kx = kx;
        this.ky = ky;
        this.barva = barva;
    }



//== PRISTUPOVE METODY ATRIBUTU INSTANCI =======================================

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
         return new Pozice( xPos, yPos );
     }


    /***************************************************************************
     * Nastavi novou pozici instance.
     * Koncovy bod se pritom presune tak, 
     * aby zustala zachovana velikost a smer instance.
     *       
     * @param x   Nova x-ova pozice instance
     * @param y   Nova y-ova pozice instance
     */
    public void setPozice(int x, int y)
    {
        kx  += x - xPos;
        xPos = x;
        ky  += y - yPos;
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
     * Vrati x-ovou souradnici koncoveho bodu instance.
     *
     * @return  x-ova souradnice koncoveho bodu.
     */
    public int getKX()
    {
        return kx;
    }


    /***************************************************************************
     * Vrati y-ovou souradnici koncoveho bodu instance.
     *
     * @return  y-ova souradnice koncoveho bodu.
     */
     public int getKY()
     {
         return ky;
     }


    /***************************************************************************
     * Vrati pozici koncoveho bodu instance.
     *
     * @return  Pozice koncoveho bodu.
     */
     public Pozice getKPozice()
     {
         return new Pozice( getKX(), getKY() );
     }


    /***************************************************************************
     * Nastavi pozici koncoveho bodu instance.
     *
     * @param kpozice  Pozice koncoveho bodu.
     */
     public void setKPozice( int kx, int ky )
     {
         this.kx = kx;
         this.ky = ky;
         AP.prekresli();
     }


    /***************************************************************************
     * Nastavi pozici koncoveho bodu instance.
     *
     * @param kpozice  Pozice koncoveho bodu.
     */
     public void setKPozice( Pozice kpozice )
     {
         setPozice( kpozice.x, kpozice.y );
     }


    /***************************************************************************
     * Vrati barvu instance.
     *
     * @return  Instance tridy Barva definujici nastavenou barvu.
     */
    public Barva getBarva()
    {
        return barva;
    }


    /***************************************************************************
     * Nastavi novou barvu instance.
     *
     * @param nova   Pozadovana nova barva.
     */
    public void setBarva(Barva nova)
    {
        barva = nova;
        AP.prekresli();
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

    /***************************************************************************
     * Za pomoci dodaneho kreslitka vykresli obraz sve instance
     * na animacni platno.
     *  
     * @param kreslitko   Kreslitko, kterym se instance nakresli na platno.     
     */
    public void nakresli( Kreslitko kreslitko )
    {
        kreslitko.kresliCaru( xPos, yPos, kx, ky, barva );
    }



//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================

    /***************************************************************************
     * Prevede instanci na retezec. Pouziva se predevsim pri ladeni.
     *
     * @return Retezcova reprezentace dane instance.
     */
    public String toString()
    {
        return nazev + ": [" + xPos + ";" + yPos + "]-[" + kx + ";" + ky + "]";
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Spoji carou zadane body.
     *
     * @param x1      x-ova souradnice pocatku, x=0 ma levy okraj platna
     * @param y1      y-ova souradnice pocatku, y=0 ma horni okraj platna
     * @param sirka   Sirka vytvarene instance
     * @param vyska   Vyska vytvarene instance
     */
    public void spoj( int x1, int y1, int kx, int ky )
    {
        setPozice( x1, y1 );
        this.kx   = kx;
        this.ky   = ky;
        AP.prekresli();
    }
    

    /***************************************************************************
     * Presune instanci o zadany pocet bodu vpravo,
     * pri zaporne hodnote parametru vlevo.
     *
     * @param vzdalenost Vzdalenost, o kterou se instance presune.
     */
    public void posunVpravo(int vzdalenost)
    {
        setPozice( xPos+vzdalenost, yPos );
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
        setPozice( xPos, yPos+vzdalenost );
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

