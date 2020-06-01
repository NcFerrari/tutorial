/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kÛdov·nÌ: P¯Ìliö ûluùouËk˝ k˘Ú ˙pÏl Ô·belskÈ Ûdy. */
package lp.cesky.priklady;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

import lp.cesky.tvary.*;

/*******************************************************************************
 * TestovacÌ t¯Ìda {@code LinkaTest} slouûÌ ke komplexnÌmu otestov·nÌ
 * t¯Ìdy {@link LinkaTest}.
 *
 * @author    jmÈno autora
 * @version   0.00.000
 */
public class LinkaTest
{
    //== KONSTANTNÕ ATRIBUTY TÿÕDY =============================================
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    //== PROMÃNN… ATRIBUTY TÿÕDY ===============================================
    //== STATICK› INICIALIZA»NÕ BLOK - STATICK› KONSTRUKTOR ====================
    //== KONSTANTNÕ ATRIBUTY INSTANCÕ ==========================================
    //== PROMÃNN… ATRIBUTY INSTANCÕ ============================================
    private Linka linka;
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
        linka = new Linka(Barva.CERVENA, 20, 20, 20, 250, 165, 300, 310, 250, 310, 20);
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
}
