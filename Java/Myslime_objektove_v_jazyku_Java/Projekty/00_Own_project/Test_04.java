/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kÛdov·nÌ: P¯Ìliö ûluùouËk˝ k˘Ú ˙pÏl Ô·belskÈ Ûdy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * TestovacÌ t¯Ìda {@code Test_04} slouûÌ ke komplexnÌmu otestov·nÌ
 * t¯Ìdy {@link Test_04}.
 *
 * @author    jmÈno autora
 * @version   0.00.000
 */
public class Test_04
{
    private Platno platno1;
    private Obdelnik obdelnik1;
    private Elipsa elipsa1;
    private Trojuhelnik trojuhel1;
    private Strom strom1;

    
    
    
    

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
        platno1 = Platno.getPlatno();
        obdelnik1 = new Obdelnik(0, 0, 50, 100);
        elipsa1 = new Elipsa(50, 0, 50, 100);
        trojuhel1 = new Trojuhelnik(0, 50, 50, 50);
        strom1 = new Strom(100, 50, 100, 200);
    }


    /***************************************************************************
     * ⁄klid po testu - tato metoda se spustÌ po vykon·nÌ kaûdÈho testu.
     */
    @After
    public void tearDown()
    {
        assertTrue(P.souhlas("V po¯·dku?"));
        platno1.setRozmer(300, 300);
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
    public void testZmenaVelikostPlatna()
    {
        platno1.setRozmer(200, 200);
        obdelnik1.nakresli();
        trojuhel1.nakresli();
        elipsa1.nakresli();
        strom1.nakresli();
    }
    
    @Test
    public void testPrehozeni() {
        obdelnik1.setPozice(250, 0);
        trojuhel1.setPozice(250, 50);
        elipsa1.setPozice(200, 0);
        strom1.setPozice(100, 50);
    }
}

