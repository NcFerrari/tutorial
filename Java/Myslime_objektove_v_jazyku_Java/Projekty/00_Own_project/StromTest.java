/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Pøíliš luouèkı kùò úpìl ïábelské ódy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovací tøída {@code StromTest} slouí ke komplexnímu otestování
 * tøídy {@link StromTest}.
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class StromTest
{
    private Strom strom1;
    private Strom strom2;
    private Strom strom3;
    private Strom strom4;

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
        strom1 = new Strom();
        strom2 = new Strom(25, 150);
        strom3 = new Strom(100, 100, 100, 90);
        strom4 = new Strom(200, 0, 100, 300);
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
        strom1.smaz();
        strom2.smaz();
        strom3.smaz();
        strom4.smaz();
        assertEquals(true, P.souhlas("Stromy smazány?"));
        strom1.nakresli();
        strom2.nakresli();
        strom3.nakresli();
        strom4.nakresli();
        assertEquals(true, P.souhlas("Stromy opìt nakresleny?"));
    }

    @Test
    public void Posuny()
    {
        P.zprava("Následuje posun vpravo");
        strom4.posunVpravo();
        strom3.posunVpravo();
        strom2.posunVpravo();
        strom1.posunVpravo();
        assertEquals(true, P.souhlas("Posun vpravo v poøádku?\n\nNásleduje posun vlevo."));
        strom1.posunVlevo();
        strom2.posunVlevo();
        strom3.posunVlevo();
        strom4.posunVlevo();
        assertEquals(true, P.souhlas("Posun vlevo vpoøádku?\n\nNásleduje posun vzhùru."));
        strom1.posunVzhuru();
        strom3.posunVzhuru();
        strom2.posunVzhuru();
        strom4.posunVzhuru();
        assertEquals(true, P.souhlas("Posun vzhùru vpoøádku?\n\nNásleduje posun dolù."));
        strom4.posunDolu();
        strom2.posunDolu();
        strom3.posunDolu();
        strom1.posunDolu();
        assertEquals(true, P.souhlas("Posun dolù vpoøádku?"));
    }

    @Test
    public void zaramovani()
    {
        strom1.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        strom2.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        strom3.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        strom4.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
    }
}



