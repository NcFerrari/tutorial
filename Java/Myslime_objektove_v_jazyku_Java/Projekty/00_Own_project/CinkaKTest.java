/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Pøíliš luouèkı kùò úpìl ïábelské ódy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovací tøída {@code CinkaKTest} slouí ke komplexnímu otestování
 * tøídy {@link CinkaKTest}.
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class CinkaKTest
{
    private CinkaK cinkaK1;
    private CinkaK cinkaK2;
    private CinkaK cinkaK3;
    private CinkaK cinkaK4;

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
        cinkaK1 = new CinkaK();
        cinkaK2 = new CinkaK(25, 200);
        cinkaK3 = new CinkaK(70, 100, 100, 90);
        cinkaK4 = new CinkaK(200, 0, 100, 300);
    }


    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání kadého testu.
     */
    @After
    public void tearDown()
    {
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
        cinkaK1.smaz();
        cinkaK2.smaz();
        cinkaK3.smaz();
        cinkaK4.smaz();
        assertEquals(true, P.souhlas("Byly èinky smazány?"));
        cinkaK1.nakresli();
        cinkaK2.nakresli();
        cinkaK3.nakresli();
        cinkaK4.nakresli();
        assertEquals(true, P.souhlas("Byly èinky opìt nakresleny?"));
    }
    
    @Test
    public void Posuny()
    {
        P.zprava("Následuje posun vpravo");
        cinkaK4.posunVpravo();
        cinkaK3.posunVpravo();
        cinkaK2.posunVpravo();
        cinkaK1.posunVpravo();
        assertEquals(true, P.souhlas("Posun vpravo v poøádku?\n\nNásleduje posun vlevo."));
        cinkaK1.posunVlevo();
        cinkaK2.posunVlevo();
        cinkaK3.posunVlevo();
        cinkaK4.posunVlevo();
        assertEquals(true, P.souhlas("Posun vlevo vpoøádku?\n\nNásleduje posun vzhùru."));
        cinkaK1.posunVzhuru();
        cinkaK3.posunVzhuru();
        cinkaK2.posunVzhuru();
        cinkaK4.posunVzhuru();
        assertEquals(true, P.souhlas("Posun vzhùru vpoøádku?\n\nNásleduje posun dolù."));
        cinkaK4.posunDolu();
        cinkaK2.posunDolu();
        cinkaK3.posunDolu();
        cinkaK1.posunDolu();
        assertEquals(true, P.souhlas("Posun dolù vpoøádku?"));
    }
    
    @Test
    public void zaramovani()
    {
        cinkaK1.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        cinkaK2.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        cinkaK3.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        cinkaK4.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
    }
}
