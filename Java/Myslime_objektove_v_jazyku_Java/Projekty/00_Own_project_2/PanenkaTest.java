/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Pøíliš luouèkı kùò úpìl ïábelské ódy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovací tøída {@code PanenkaTest} slouí ke komplexnímu otestování
 * tøídy {@link PanenkaTest}.
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class PanenkaTest
{
    public static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private Panenka panenka1;
    private Panenka panenka2;
    private Panenka panenka3;
    private Panenka panenka4;

    //== KONSTANTNÍ ATRIBUTY TØÍDY =============================================
    //== PROMÌNNÉ ATRIBUTY TØÍDY ===============================================
    //== STATICKİ INICIALIZAÈNÍ BLOK - STATICKİ KONSTRUKTOR ====================
    //== KONSTANTNÍ ATRIBUTY INSTANCÍ ==========================================
    //== PROMÌNNÉ ATRIBUTY INSTANCÍ ============================================
    //== PØÍSTUPOVÉ METODY VLASTNOSTÍ TØÍDY ====================================
    //== OSTATNÍ NESOUKROMÉ METODY TØÍDY =======================================

    //##########################################################################
    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    //-- Testovací tøída vystaèí s prázdnım implicitním konstruktorem ----------
    //== PØÍPRAVA A ÚKLID PØÍPRAVKU ============================================

    /***************************************************************************
     * Inicializace pøedcházející spuštìní kadého testu a pøipravující tzv.
     * pøípravek (fixture), co je sada objektù, s nimi budou testy pracovat.
     */
    @Before
    public void setUp()
    {
        panenka1 = new Panenka();
        panenka2 = new Panenka(25, 200);
        panenka3 = new Panenka(70, 100, 100, 90);
        panenka4 = new Panenka(200, 0, 100, 300);
        panenka1.nakresli();
        panenka2.nakresli();
        panenka3.nakresli();
        panenka4.nakresli();
    }


    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání kadého testu.
     */
    @After
    public void tearDown()
    {
        AP.setKrokRozmer(50, 6, 6);
        AP.odstranVse();
        AP.setMrizka(true);
    }



    //== PØÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ =================================
    //== OSTATNÍ NESOUKROMÉ METODY INSTANCÍ ====================================
    //== SOUKROMÉ A POMOCNÉ METODY TØÍDY =======================================
    //== SOUKROMÉ A POMOCNÉ METODY INSTANCÍ ====================================
    //== INTERNÍ DATOVÉ TYPY ===================================================
    //== VLASTNÍ TESTY =========================================================
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
        panenka1.smaz();
        panenka2.smaz();
        panenka3.smaz();
        panenka4.smaz();
        assertEquals(true, P.souhlas("Byly panenky smazány?"));
        panenka1.nakresli();
        panenka2.nakresli();
        panenka3.nakresli();
        panenka4.nakresli();
        assertEquals(true, P.souhlas("Byly panenky opìt nakresleny?"));
    }
    
    @Test
    public void Posuny()
    {
        P.zprava("Následuje posun vpravo");
        panenka4.posunVpravo();
        panenka3.posunVpravo();
        panenka2.posunVpravo();
        panenka1.posunVpravo();
        assertEquals(true, P.souhlas("Posun vpravo v poøádku?\n\nNásleduje posun vlevo."));
        panenka1.posunVlevo();
        panenka2.posunVlevo();
        panenka3.posunVlevo();
        panenka4.posunVlevo();
        assertEquals(true, P.souhlas("Posun vlevo vpoøádku?\n\nNásleduje posun vzhùru."));
        panenka4.posunVzhuru();
        panenka3.posunVzhuru();
        panenka2.posunVzhuru();
        panenka1.posunVzhuru();
        assertEquals(true, P.souhlas("Posun vzhùru vpoøádku?\n\nNásleduje posun dolù."));
        panenka1.posunDolu();
        panenka2.posunDolu();
        panenka3.posunDolu();
        panenka4.posunDolu();
        assertEquals(true, P.souhlas("Posun dolù vpoøádku?"));
    }
    
    @Test
    public void zaramovani()
    {
        panenka1.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        panenka2.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        panenka3.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        panenka4.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
    }
    
    @Test
    public void testStatickeZaramuj()
    {
        AP.odstranVse();
        Panenka.zaramuj( 200, 300 );
        assertTrue(P.souhlas("Panenka zaramovana?"));
    }
}
