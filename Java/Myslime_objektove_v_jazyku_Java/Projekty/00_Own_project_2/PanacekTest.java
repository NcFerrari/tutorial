/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kÛdov·nÌ: P¯Ìliö ûluùouËk˝ k˘Ú ˙pÏl Ô·belskÈ Ûdy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * TestovacÌ t¯Ìda {@code PanacekTest} slouûÌ ke komplexnÌmu otestov·nÌ
 * t¯Ìdy {@link PanacekTest}.
 *
 * @author    jmÈno autora
 * @version   0.00.000
 */
public class PanacekTest
{
    public static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private Panacek panacek1;
    private Panacek panacek2;
    private Panacek panacek3;
    private Panacek panacek4;

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
        panacek1 = new Panacek();
        panacek2 = new Panacek(25, 200);
        panacek3 = new Panacek(70, 100, 100, 90);
        panacek4 = new Panacek(200, 0, 100, 300);
        panacek1.nakresli();
        panacek2.nakresli();
        panacek3.nakresli();
        panacek4.nakresli();
    }


    /***************************************************************************
     * ⁄klid po testu - tato metoda se spustÌ po vykon·nÌ kaûdÈho testu.
     */
    @After
    public void tearDown()
    {
        AP.setKrokRozmer(50, 6, 6);
        AP.odstranVse();
        AP.setMrizka(true);
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
        panacek1.smaz();
        panacek2.smaz();
        panacek3.smaz();
        panacek4.smaz();
        assertEquals(true, P.souhlas("Byli pan·Ëci smaz·ni?"));
        panacek1.nakresli();
        panacek2.nakresli();
        panacek3.nakresli();
        panacek4.nakresli();
        assertEquals(true, P.souhlas("Byli pan·Ëci opÏt nakresleni?"));
    }
    
    @Test
    public void Posuny()
    {
        P.zprava("N·sleduje posun vpravo");
        panacek4.posunVpravo();
        panacek3.posunVpravo();
        panacek2.posunVpravo();
        panacek1.posunVpravo();
        assertEquals(true, P.souhlas("Posun vpravo v po¯·dku?\n\nN·sleduje posun vlevo."));
        panacek1.posunVlevo();
        panacek2.posunVlevo();
        panacek3.posunVlevo();
        panacek4.posunVlevo();
        assertEquals(true, P.souhlas("Posun vlevo vpo¯·dku?\n\nN·sleduje posun vzh˘ru."));
        panacek4.posunVzhuru();
        panacek3.posunVzhuru();
        panacek2.posunVzhuru();
        panacek1.posunVzhuru();
        assertEquals(true, P.souhlas("Posun vzh˘ru vpo¯·dku?\n\nN·sleduje posun dol˘."));
        panacek1.posunDolu();
        panacek2.posunDolu();
        panacek3.posunDolu();
        panacek4.posunDolu();
        assertEquals(true, P.souhlas("Posun dol˘ vpo¯·dku?"));
    }
    
    @Test
    public void zaramovani()
    {
        panacek1.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        panacek2.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        panacek3.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        panacek4.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
    }
    
    @Test
    public void testStatickeZaramuj()
    {
        AP.odstranVse();
        Panacek.zaramuj( 200, 300 );
        assertTrue(P.souhlas("Panacek zaramovan?"));
    }
    
    @Test
    public void plynulePresun()
    {
        AP.odstranVse();
        Presouvac pres1 = new Presouvac();
        assertEquals(true, AP.pridej(panacek1));
        pres1.presunO(panacek1, 100, 100);
        Presouvac pres5 = new Presouvac(5);
        pres5.presunO(panacek1, -100, -100);
        pres5.presunNa(panacek1, 200, 150);
    }
}
