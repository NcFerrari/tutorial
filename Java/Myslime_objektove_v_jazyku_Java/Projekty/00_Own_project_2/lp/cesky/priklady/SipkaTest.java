/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kÛdov·nÌ: P¯Ìliö ûluùouËk˝ k˘Ú ˙pÏl Ô·belskÈ Ûdy. */
package lp.cesky.priklady;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

import lp.cesky.spolecne.P;

/*******************************************************************************
 * TestovacÌ t¯Ìda {@code SipkaTest} slouûÌ ke komplexnÌmu otestov·nÌ
 * t¯Ìdy {@link SipkaTest}.
 *
 * @author    jmÈno autora
 * @version   0.00.000
 */
public class SipkaTest
{
    private lp.cesky.priklady.Sipka sipka1;

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
        sipka1 = new Sipka();
        
    }


    /***************************************************************************
     * ⁄klid po testu - tato metoda se spustÌ po vykon·nÌ kaûdÈho testu.
     */
    @After
    public void tearDown()
    {
        lp.cesky.tvary.AktivniPlatno.getPlatno().odstranVse();
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
    public void testOkolo()
    {
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vpravoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vpravoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vpravoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vpravoVbok();
        
        P.cekej(1000);
        
        sipka1.vpravoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vlevoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vlevoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vlevoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vlevoVbok();
        sipka1.vlevoVbok();
    }
}

