/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Pøíliš luouèkı kùò úpìl ïábelské ódy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovací tøída {@code CinkaOTest} slouí ke komplexnímu otestování
 * tøídy {@link CinkaOTest}.
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class CinkaOTest
{
    public static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private CinkaO cinkaO1;
    private CinkaO cinkaO2;
    private CinkaO cinkaO3;
    private CinkaO cinkaO4;

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
        cinkaO1 = new CinkaO();
        cinkaO2 = new CinkaO(25, 200);
        cinkaO3 = new CinkaO(70, 100, 100, 90);
        cinkaO4 = new CinkaO(200, 0, 100, 300);
        cinkaO1.nakresli();
        cinkaO2.nakresli();
        cinkaO3.nakresli();
        cinkaO4.nakresli();
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
        cinkaO1.smaz();
        cinkaO2.smaz();
        cinkaO3.smaz();
        cinkaO4.smaz();
        assertEquals(true, P.souhlas("Byly èinky smazány?"));
        cinkaO1.nakresli();
        cinkaO2.nakresli();
        cinkaO3.nakresli();
        cinkaO4.nakresli();
        assertEquals(true, P.souhlas("Byly èinky opìt nakresleny?"));
    }
    
    @Test
    public void Posuny()
    {
        P.zprava("Následuje posun vpravo");
        cinkaO4.posunVpravo();
        cinkaO3.posunVpravo();
        cinkaO2.posunVpravo();
        cinkaO1.posunVpravo();
        assertEquals(true, P.souhlas("Posun vpravo v poøádku?\n\nNásleduje posun vlevo."));
        cinkaO1.posunVlevo();
        cinkaO2.posunVlevo();
        cinkaO3.posunVlevo();
        cinkaO4.posunVlevo();
        assertEquals(true, P.souhlas("Posun vlevo vpoøádku?\n\nNásleduje posun vzhùru."));
        cinkaO1.posunVzhuru();
        cinkaO3.posunVzhuru();
        cinkaO2.posunVzhuru();
        cinkaO4.posunVzhuru();
        assertEquals(true, P.souhlas("Posun vzhùru vpoøádku?\n\nNásleduje posun dolù."));
        cinkaO4.posunDolu();
        cinkaO2.posunDolu();
        cinkaO3.posunDolu();
        cinkaO1.posunDolu();
        assertEquals(true, P.souhlas("Posun dolù vpoøádku?"));
    }
    
    @Test
    public void zaramovani()
    {
        cinkaO1.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        cinkaO2.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        cinkaO3.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        cinkaO4.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
    }
    
    @Test
    public void testStatickeZaramuj()
    {
        AP.odstranVse();
        CinkaO.zaramuj( 200, 300 );
        assertTrue(P.souhlas("Cinka zaramovana?"));
    }
}

