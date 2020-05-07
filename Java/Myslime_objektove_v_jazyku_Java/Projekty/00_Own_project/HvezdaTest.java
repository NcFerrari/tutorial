/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kÛdov·nÌ: P¯Ìliö ûluùouËk˝ k˘Ú ˙pÏl Ô·belskÈ Ûdy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * TestovacÌ t¯Ìda {@code HvezdaTest} slouûÌ ke komplexnÌmu otestov·nÌ
 * t¯Ìdy {@link HvezdaTest}.
 *
 * @author    jmÈno autora
 * @version   0.00.000
 */
public class HvezdaTest
{
    private Hvezda hvezda1;
    private Hvezda hvezda2;
    private Hvezda hvezda3;
    private Hvezda hvezda4;

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
        hvezda1 = new Hvezda();
        hvezda2 = new Hvezda(25, 200);
        hvezda3 = new Hvezda(70, 100, 100, 90);
        hvezda4 = new Hvezda(200, 0, 100, 300);
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
    public void NakresliSmaz()
    {
        hvezda1.smaz();
        hvezda2.smaz();
        hvezda3.smaz();
        hvezda4.smaz();
        assertEquals(true, P.souhlas("Byly hvÏzdy smaz·ny?"));
        hvezda1.nakresli();
        hvezda2.nakresli();
        hvezda3.nakresli();
        hvezda4.nakresli();
        assertEquals(true, P.souhlas("Byly hvÏzdy opÏt nakresleny?"));
    }
    
    @Test
    public void Posuny()
    {
        P.zprava("N·sleduje posun vpravo");
        hvezda4.posunVpravo();
        hvezda3.posunVpravo();
        hvezda2.posunVpravo();
        hvezda1.posunVpravo();
        assertEquals(true, P.souhlas("Posun vpravo v po¯·dku?\n\nN·sleduje posun vlevo."));
        hvezda1.posunVlevo();
        hvezda2.posunVlevo();
        hvezda3.posunVlevo();
        hvezda4.posunVlevo();
        assertEquals(true, P.souhlas("Posun vlevo vpo¯·dku?\n\nN·sleduje posun vzh˘ru."));
        hvezda4.posunVzhuru();
        hvezda3.posunVzhuru();
        hvezda2.posunVzhuru();
        hvezda1.posunVzhuru();
        assertEquals(true, P.souhlas("Posun vzh˘ru vpo¯·dku?\n\nN·sleduje posun dol˘."));
        hvezda1.posunDolu();
        hvezda2.posunDolu();
        hvezda3.posunDolu();
        hvezda4.posunDolu();
        assertEquals(true, P.souhlas("Posun dol˘ vpo¯·dku?"));
    }
    
    @Test
    public void zaramovani()
    {
        hvezda1.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        hvezda2.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        hvezda3.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        hvezda4.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
    }
}
