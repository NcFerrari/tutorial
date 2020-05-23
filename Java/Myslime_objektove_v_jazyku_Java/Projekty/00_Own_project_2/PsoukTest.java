/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kÛdov·nÌ: P¯Ìliö ûluùouËk˝ k˘Ú ˙pÏl Ô·belskÈ Ûdy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * TestovacÌ t¯Ìda {@code PsoukTest} slouûÌ ke komplexnÌmu otestov·nÌ
 * t¯Ìdy {@link PsoukTest}.
 *
 * @author    jmÈno autora
 * @version   0.00.000
 */
public class PsoukTest
{
    //== KONSTANTNÕ ATRIBUTY TÿÕDY =============================================
    //== PROMÃNN… ATRIBUTY TÿÕDY ===============================================
    //== STATICK› INICIALIZA»NÕ BLOK - STATICK› KONSTRUKTOR ====================
    //== KONSTANTNÕ ATRIBUTY INSTANCÕ ==========================================
    //== PROMÃNN… ATRIBUTY INSTANCÕ ============================================
    //== PÿÕSTUPOV… METODY VLASTNOSTÕ TÿÕDY ====================================
    //== OSTATNÕ NESOUKROM… METODY TÿÕDY =======================================

    //##########################################################################
    //== KONSTRUKTORY A TOV¡RNÕ METODY =========================================
    //-- TestovacÌ t¯Ìda vystaËÌ s pr·zdn˝m implicitnÌm konstruktorem ----------
    //== PÿÕPRAVA A ⁄KLID PÿÕPRAVKU ============================================

    /***************************************************************************
     * Inicializace p¯edch·zejÌcÌ spuötÏnÌ kaûdÈho testu a p¯ipravujÌcÌ tzv.
     * p¯Ìpravek (fixture), coû je sada objekt˘, s nimiû budou testy pracovat.
     */
    @Before
    public void setUp()
    {
    }


    /***************************************************************************
     * ⁄klid po testu - tato metoda se spustÌ po vykon·nÌ kaûdÈho testu.
     */
    @After
    public void tearDown()
    {
    }



    //== PÿÕSTUPOV… METODY VLASTNOSTÕ INSTANCÕ =================================
    //== OSTATNÕ NESOUKROM… METODY INSTANCÕ ====================================
    //== SOUKROM… A POMOCN… METODY TÿÕDY =======================================
    //== SOUKROM… A POMOCN… METODY INSTANCÕ ====================================
    //== INTERNÕ DATOV… TYPY ===================================================
    //== VLASTNÕ TESTY =========================================================
    //
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXxx()
    //     {
    //     }

    @Test
    public void psouk()
    {
        Strom stom = new Strom(100, 100, 100, 100);
        AktivniPlatno AP = AktivniPlatno.getPlatno();
        AP.pridej(stom);
        Psouk psouk1 = new Psouk(50);
        psouk1.prifoukni(stom);
        psouk1.ufoukni(stom);
    }
    
    @Test
    public void kompresor()
    {
        Strom stom = new Strom(100, 100, 100, 100);
        AktivniPlatno AP = AktivniPlatno.getPlatno();
        AP.pridej(stom);
        Kompresor kompresor1 = new Kompresor(50);
        kompresor1.prifoukni(stom);
        kompresor1.ufoukni(stom);
    }
}

