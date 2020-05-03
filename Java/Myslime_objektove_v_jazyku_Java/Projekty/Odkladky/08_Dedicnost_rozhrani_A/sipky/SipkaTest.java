package sipky;

import rup.cesky.spolecne.P;

import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.Barva;


/*******************************************************************************
 * Testovaci trida SipkaTest slouzi ke komplexnimu otestovani
 * tridy ...
 *
 * @author    jmeno autora
 * @version   0.00.000,  0.0.2003
 */
public class SipkaTest extends junit.framework.TestCase
{

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori test se zadanym nazvem.
     *  
     * @param nazev  Nazev konstruovaneho testu
     */
    public SipkaTest(String nazev)
    {
        super( nazev );
    }



//== PRIPRAVA A UKLID PRIPRAVKU ================================================

    /***************************************************************************
     * Vytvoreni pripravku (fixture), tj. sady objektu, s nimiz budou vsechny
     * testy pracovat a ktera se proto vytvori pred spustenim kazdeho testu.         
     */
    protected void setUp()
    {
    }


    /***************************************************************************
     * Uklid po testu - tato metoda se spusti po vykonani kazdeho testu.
     */
    protected void tearDown()
    {
    }


//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== VLASTNI TESTY =============================================================

    /***************************************************************************
     * 
     * /
    public void testXXX()
    {
    }
    
/**/ 

    /***************************************************************************
     * 
     */
    public void testOkolo()
    {
        AktivniPlatno ap = AktivniPlatno.getPlatno();
        Sipka s = new Sipka( 2,  3,  Barva.CERNA );
        ap.pridej( s );
        for( int i=4;   i-- > 0;  )
        {
            s.vpred();      P.cekej( 250 );
            s.vlevoVbok();  P.cekej( 250 );
        }
    }
    

}


