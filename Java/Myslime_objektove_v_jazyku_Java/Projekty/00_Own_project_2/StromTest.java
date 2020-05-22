/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kÛdov·nÌ: P¯Ìliö ûluùouËk˝ k˘Ú ˙pÏl Ô·belskÈ Ûdy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * TestovacÌ t¯Ìda {@code StromTest} slouûÌ ke komplexnÌmu otestov·nÌ
 * t¯Ìdy {@link StromTest}.
 *
 * @author    jmÈno autora
 * @version   0.00.000
 */
public class StromTest extends Strom
{
    public static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private Strom strom1;
    private Strom strom2;
    private Strom strom3;
    private Strom strom4;

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
        strom1 = new Strom();
        strom2 = new Strom(25, 150);
        strom3 = new Strom(100, 100, 100, 90);
        strom4 = new Strom(200, 0, 100, 300);
        strom1.nakresli();
        strom2.nakresli();
        strom3.nakresli();
        strom4.nakresli();
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
        strom1.smaz();
        strom2.smaz();
        strom3.smaz();
        strom4.smaz();
        assertEquals(true, AP.seznamKreslenych().size() == 0);
        strom1.nakresli();
        strom2.nakresli();
        strom3.nakresli();
        strom4.nakresli();
        assertEquals(true, AP.seznamKreslenych().size() == 4);
    }

    @Test
    public void Posuny()
    {
        int x1 = strom1.getX(), x2 = strom2.getX(), x3 = strom3.getX(), x4 = strom4.getX();
        int y1 = strom1.getY(), y2 = strom2.getY(), y3 = strom3.getY(), y4 = strom4.getY();
        strom4.posunVpravo();
        strom3.posunVpravo();
        strom2.posunVpravo();
        strom1.posunVpravo();
        assertEquals(true, x1 + AP.getKrok() == strom1.getX() && x2 + AP.getKrok() == strom2.getX() && x3 + AP.getKrok() == strom3.getX() && x4 + AP.getKrok() == strom4.getX());
        x1 = strom1.getX();
        x2 = strom2.getX();
        x3 = strom3.getX();
        x4 = strom4.getX();
        strom1.posunVlevo();
        strom2.posunVlevo();
        strom3.posunVlevo();
        strom4.posunVlevo();
        assertEquals(true, x1 - AP.getKrok() == strom1.getX() && x2 - AP.getKrok() == strom2.getX() && x3 - AP.getKrok() == strom3.getX() && x4 - AP.getKrok() == strom4.getX());
        strom1.posunVzhuru();
        strom3.posunVzhuru();
        strom2.posunVzhuru();
        strom4.posunVzhuru();
        assertEquals(true, y1 - AP.getKrok() == strom1.getY() && y2 - AP.getKrok() == strom2.getY() && y3 - AP.getKrok() == strom3.getY() && y4 - AP.getKrok() == strom4.getY());
        y1 = strom1.getY();
        y2 = strom2.getY();
        y3 = strom3.getY();
        y4 = strom4.getY();
        strom4.posunDolu();
        strom2.posunDolu();
        strom3.posunDolu();
        strom1.posunDolu();
        assertEquals(true, y1 + AP.getKrok() == strom1.getY() && y2 + AP.getKrok() == strom2.getY() && y3 + AP.getKrok() == strom3.getY() && y4 + AP.getKrok() == strom4.getY());
    }

    @Test
    public void zaramovani()
    {
        strom1.zaramuj();
        assertEquals(true, AP.getSirka() == strom1.getSirka() && AP.getVyska() == strom1.getVyska());
        strom1.smaz();
        strom2.zaramuj();
        assertEquals(true, AP.getSirka() == strom2.getSirka() && AP.getVyska() == strom2.getVyska());
        strom2.smaz();
        strom3.zaramuj();
        assertEquals(true, AP.getSirka() == strom3.getSirka() && AP.getVyska() == strom3.getVyska());
        strom3.smaz();
        strom4.zaramuj();
        assertEquals(true, AP.getSirka() == strom4.getSirka() && AP.getVyska() == strom4.getVyska());
    }
    
    @Test
    public void testAlej()
    {
        AP.odstranVse();
        Strom.alej();
        assertTrue(P.souhlas("Alej nakreslena?"));
    }

    @Test
    public void testStatickeZaramuj()
    {
        AP.odstranVse();
        Strom.zaramuj( 200, 300 );
        assertTrue(P.souhlas("Strom zaramovan?"));
    }

    @Test
    public void plynulePresun()
    {
        AP.odstranVse();
        Presouvac pres1 = new Presouvac();
        assertEquals(true, AP.pridej(strom1));
        pres1.presunO(strom1, 100, 100);
        Presouvac pres5 = new Presouvac(5);
        pres5.presunO(strom1, -100, -100);
        pres5.presunNa(strom1, 200, 150);
    }
}




