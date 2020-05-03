/*******************************************************************************
 * Trida CernaDira slouzi k ukazce definice tridy, 
 * jejiz instance ma zustat jedinackem.
 *
 * @author     Rudolf Pecinovsky
 * @version    2.01, duben 2004
 */
public class CernaDira
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Prumer kruhu tvoriciho cernou diru. */
    private static final int PRUMER  = 10;
    private static final int POLOMER = PRUMER / 2;

    /** Definuje jedinacka jako konstnatni atribut tridy a hned mu take
     *  prirazuje pocatecni hodnotu. */        
    private static final CernaDira jedinacek = new CernaDira( PRUMER );
    
    
    
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    /** Odkaz na kruh, ktery na platne predstavuje danou diru. */
    private final Elipsa dira;
    
    
    
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Metoda vracejici odkaz na jedinacka.
     */
    public static CernaDira getInstance()
    {
        return jedinacek;
    }


    /***************************************************************************
     * Implicitni konstruktor tridy CernaDira
     */
    private CernaDira( int prumer )
    {
        Platno platno = Platno.getPlatno();
        int x  = platno.getSirka() / 2 - POLOMER;
        int y  = platno.getVyska() / 2 - POLOMER;
        dira = new Elipsa( x, y, PRUMER, PRUMER, Barva.CERNA );
    }


//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================

    /***************************************************************************
     * Prevede instanci na retezec. Pouziva se predevsim pri ladeni.
     *
     * @return Retezcova reprezentace dane instance.
     */
    public String toString()
    {
        return "CernaDira";
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Presune zadanou instanci nad sebe a vcucne ji, tj. zmensi ji postupne
     * az na nulovou velikost. Presun i spolknuti provede vzdy ve trech krocich.
     *
     * @param elipsa  Polykana elipsa.
     */
    public void spolkni( Elipsa elipsa )
    {
        int xe = elipsa.getX();
        int ye = elipsa.getY();
        int se = elipsa.getSirka();
        int ve = elipsa.getVyska();
        int xd = dira.getX() + POLOMER;
        int yd = dira.getY() + POLOMER;
        
        int dx = (xd - (xe + se/2)) / 3; 
        int dy = (yd - (ye + ve/2)) / 3; 
        
        elipsa.setPozice( xe = xe + dx, ye = ye + dy );
        P.cekej( 500 );
        elipsa.setPozice( xe = xe + dx, ye = ye + dy );
        P.cekej( 500 );
        elipsa.setPozice( xe = xe + dx, ye = ye + dy );
        P.cekej( 500 );
        
        dx = se / 6;
        dy = ve / 6;
        elipsa.setPozice( xe += dx, ye += dy );
        elipsa.setRozmer( se -= 2*dx,  ve -= 2*dy );
        P.cekej( 500 );
        elipsa.setPozice( xe += dx, ye += dy );
        elipsa.setRozmer( se -= 2*dx,  ve -= 2*dy );
        P.cekej( 500 );
        elipsa.setPozice( xe += dx, ye += dy );
        elipsa.setRozmer( se -= 2*dx,  ve -= 2*dy );
        dira.nakresli();
        P.cekej( 500 );

        elipsa.smaz();
        dira.nakresli();
    }



//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}


