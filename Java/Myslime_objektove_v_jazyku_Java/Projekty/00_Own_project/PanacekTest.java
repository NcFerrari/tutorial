/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Pøíliš luouèkı kùò úpìl ïábelské ódy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovací tøída {@code PanacekTest} slouí ke komplexnímu otestování
 * tøídy {@link PanacekTest}.
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class PanacekTest
{
    private Panacek panacek1;
    private Panacek panacek2;
    private Panacek panacek3;
    private Panacek panacek4;

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
        panacek1 = new Panacek();
        panacek2 = new Panacek(25, 200);
        panacek3 = new Panacek(70, 100, 100, 90);
        panacek4 = new Panacek(200, 0, 100, 300);
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
        panacek1.smaz();
        panacek2.smaz();
        panacek3.smaz();
        panacek4.smaz();
        assertEquals(true, P.souhlas("Byli panáèci smazáni?"));
        panacek1.nakresli();
        panacek2.nakresli();
        panacek3.nakresli();
        panacek4.nakresli();
        assertEquals(true, P.souhlas("Byli panáèci opìt nakresleni?"));
    }
    
    @Test
    public void Posuny()
    {
        P.zprava("Následuje posun vpravo");
        panacek4.posunVpravo();
        panacek3.posunVpravo();
        panacek2.posunVpravo();
        panacek1.posunVpravo();
        assertEquals(true, P.souhlas("Posun vpravo v poøádku?\n\nNásleduje posun vlevo."));
        panacek1.posunVlevo();
        panacek2.posunVlevo();
        panacek3.posunVlevo();
        panacek4.posunVlevo();
        assertEquals(true, P.souhlas("Posun vlevo vpoøádku?\n\nNásleduje posun vzhùru."));
        panacek4.posunVzhuru();
        panacek3.posunVzhuru();
        panacek2.posunVzhuru();
        panacek1.posunVzhuru();
        assertEquals(true, P.souhlas("Posun vzhùru vpoøádku?\n\nNásleduje posun dolù."));
        panacek1.posunDolu();
        panacek2.posunDolu();
        panacek3.posunDolu();
        panacek4.posunDolu();
        assertEquals(true, P.souhlas("Posun dolù vpoøádku?"));
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
}
