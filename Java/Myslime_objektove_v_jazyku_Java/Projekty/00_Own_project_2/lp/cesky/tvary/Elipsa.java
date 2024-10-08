package lp.cesky.tvary;

import lp.cesky.spolecne.P;


/*******************************************************************************
 * Trida pro praci s elipsou komunikujici s aktivnim platnem.
 *  
 * Oproti stejnojmenne tride z projektu 
 * 06_Rozhrani se zmenilo pouze implementovane rozhrani.   
 *   
 * @author     Rudolf Pecinovsky
 * @version    2.01, duben 2004
 */
public class Elipsa extends AHybaci 
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Pocatecni barva nakreslene instance v pripade,
     *  kdy uzivatel zadnou pozadovanou barvu nezada -
     *  pro elipsu Barva.MODRA. */
    public static final Barva IMPLICITNI_BARVA = Barva.MODRA;

    /** Aktivni platno, ktere dohlizi na spravne vykresleni instance. */
    protected static final AktivniPlatno AP = AktivniPlatno.getPlatno();



//== PROMENNE ATRIBUTY TRIDY ===================================================

    /** Pocet vytvorenych instanci */
    private static int pocet = 0;



//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori novou instanci s implicitnimi rozmery, umistenim a barvou.
     * Instance bude umistena v levem hornim rohu platna 
     * a bude mit implicitni barvu, 
     * vysku 1 pole a sirku 2 pole.
     */
    public Elipsa()
    {
        this( 0, 0, 2*AP.getKrok(), AP.getKrok() );
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
    public Elipsa( int x, int y, int sirka, int vyska )
    {
        this( x, y, sirka, vyska, IMPLICITNI_BARVA );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanou polohou, rozmery 
     * a barvou.
     *
     * @param pozice    Pozice vytvarene instance
     * @param rozmer    Rozmer vytvarene instance
     * @param barva     Barva vytvarene instance
     */
    public Elipsa(Pozice pozice, Rozmer rozmer, Barva barva)
    {
        this( pozice.x, pozice.y, rozmer.sirka, rozmer.vyska, barva );
    }


    /***************************************************************************
     * Vytvori novou instanci vyplnujici zadanou oblast 
     * a majici zadanou barvu.
     *
     * @param oblast   Oblast definujici pozici a rozmer vytvarene instance
     * @param barva    Barva vytvarene instance
     */
    public Elipsa(Oblast oblast, Barva barva)
    {
        this( oblast.x, oblast.y, oblast.sirka, oblast.vyska, barva );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanymi rozmery, polohou a barvou.
     *
     * @param x       x-ova souradnice pocatku, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y=0 ma horni okraj platna
     * @param sirka   Sirka vytvarene instance
     * @param vyska   Vyska vytvarene instance
     * @param barva  Barva vytvarene instance
     */
    public Elipsa( int x, int y, int sirka, int vyska, Barva barva )
    {
        super(x, y,sirka, vyska, barva);
        this.nazev = P.nazevTridy(this) + "_" + ++pocet;
    }



//== PRISTUPOVE METODY ATRIBUTU INSTANCI =======================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================

    /***************************************************************************
     * Za pomoci dodaneho kreslitka vykresli obraz sve instance
     * na animacni platno.
     *  
     * @param kreslitko   Kreslitko, kterym se instance nakresli na platno.     
     */
    public void nakresli( Kreslitko kreslitko )
    {
        kreslitko.vyplnOval( getX(), getY(), getSirka(), getVyska(), getBarva() );
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
        return nazev + ": x=" + getX() + ", y=" + getY() + 
               ", sirka=" + getSirka() + ", vyska=" + getVyska() +
               ", barva=" + getBarva();
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

