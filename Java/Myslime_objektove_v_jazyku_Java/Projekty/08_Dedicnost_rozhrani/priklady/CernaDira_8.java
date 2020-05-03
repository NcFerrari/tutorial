package priklady;

import rup.cesky.tvary.Barva;
import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.IHybaci;
import rup.cesky.tvary.Kompresor;
import rup.cesky.tvary.Pozice;
import rup.cesky.tvary.Presouvac;
import rup.cesky.tvary.Elipsa;


/*******************************************************************************
 * Instance tridy CernaDira7 simuluje cernou diru, ktera pritahne oznacene
 * objekty a vcucne je. Objekty musi byt typu IHybaci.
 *
 * @author    Rudolf Pecinovsky
 * @version   1.00.000,  05.2003
 */
public class CernaDira_8
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    private static final AktivniPlatno AP     = AktivniPlatno.getPlatno();

    private static final CernaDira_8 JEDINACEK = new CernaDira_8();
    private static final int        PRUMER    = 50;
    
    private static final Presouvac presouvac = new Presouvac( 5 );
    private static final Kompresor kompresor = new Kompresor( 3 );
    
    
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    private final Elipsa kruh;
    
    
    
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

    /***************************************************************************
     * Bezparametricky konstruktor ...
     */
    public static CernaDira_8 getInstance()
    {
        return JEDINACEK;
    }
    
    

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Bezparametricky konstruktor ...
     */
    private CernaDira_8()
    {
        Pozice p = stred( PRUMER, PRUMER );
        kruh = new Elipsa ( p.x, p.y, PRUMER, PRUMER, Barva.CERNA );
        AP.pridej( kruh );
    }



//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================

    /***************************************************************************
     * Vraci textovou reprezentaci dane instance
     * pouzivanou predevsim k ladicim ucelum.
     *      
     * @return Nazev tridy nasledovnay podtrzitkem a "rodnym cislem" instance. 
     */
    public String toString()
    {
        return "CernaDira";
    }


//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Presune zadany objekt nad cernou diru, zmensi jej a nakonec odstrani.
     *      
     * @param obet    Polykany objekt.
     */
    public void spolkni( IHybaci ih )
    {
        AP.pridejPod( ih, kruh );
        presouvac.presunNa  ( ih, stred( ih.getSirka(), ih.getVyska() ) );
        kompresor.nafoukniNa( ih, PRUMER/4, PRUMER/4, null );
        AP.odstran( ih );
    }


    
//== SOUKROME A POMOCNE METODY TRIDY ===========================================


    /***************************************************************************
     * Vrati souradnice.
     *      
     * @param obet    Polykany objekt.
     */
    private static Pozice stred( int sirka, int vyska )
    {
        int kp = AP.getKrok();
        int sp = AP.getSirka() * AP.getKrok();
        int vp = AP.getVyska() * AP.getKrok();
        return new Pozice( (sp-sirka)/2, (vp-vyska)/2 );
    }
    
    
    
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

