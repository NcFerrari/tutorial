/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Pøíliš luouèkı kùò úpìl ïábelské ódy. */
package lp.cesky.priklady;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovací tøída {@code CernaDiraTest} slouí ke komplexnímu otestování
 * tøídy {@link CernaDiraTest}.
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class CernaDiraTest
{
    private lp.cesky.priklady.CernaDira CD;
    private lp.cesky.priklady.Strom strom1;
    private lp.cesky.priklady.CinkaK cinkaK1;
    private lp.cesky.priklady.Hvezda hvezda1;
    private lp.cesky.priklady.Panacek panacek1;
    private lp.cesky.priklady.Panenka panenka1;

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
        CD = lp.cesky.priklady.CernaDira.getInstance();
        strom1 = new lp.cesky.priklady.Strom();
        cinkaK1 = new lp.cesky.priklady.CinkaK(200, 0);
        hvezda1 = new lp.cesky.priklady.Hvezda(0, 200);
        panacek1 = new lp.cesky.priklady.Panacek(200, 200);
        panenka1 = new lp.cesky.priklady.Panenka(250, 200);
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
    public void testSpolkniVse()
    {
        CD.spolkni(cinkaK1);
        CD.spolkni(panacek1);
        CD.spolkni(strom1);
        CD.spolkni(hvezda1);
        CD.spolkni(panenka1);
    }
}

