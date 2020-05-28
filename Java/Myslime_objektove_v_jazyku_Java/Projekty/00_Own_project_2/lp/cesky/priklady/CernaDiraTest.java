/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */
package lp.cesky.priklady;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovac� t��da {@code CernaDiraTest} slou�� ke komplexn�mu otestov�n�
 * t��dy {@link CernaDiraTest}.
 *
 * @author    jm�no autora
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

    //== KONSTANTN� ATRIBUTY T��DY =============================================
    //== PROM�NN� ATRIBUTY T��DY ===============================================
    //== STATICK� INICIALIZA�N� BLOK - STATICK� KONSTRUKTOR ====================
    //== KONSTANTN� ATRIBUTY INSTANC� ==========================================
    //== PROM�NN� ATRIBUTY INSTANC� ============================================
    //== P��STUPOV� METODY VLASTNOST� T��DY ====================================
    //== OSTATN� NESOUKROM� METODY T��DY =======================================

    //##########################################################################
    //== KONSTRUKTORY A TOV�RN� METODY =========================================
    //-- Testovac� t��da vysta�� s pr�zdn�m implicitn�m konstruktorem ----------
    //== P��PRAVA A �KLID P��PRAVKU ============================================

    /***************************************************************************
     * Inicializace p�edch�zej�c� spu�t�n� ka�d�ho testu a p�ipravuj�c� tzv.
     * p��pravek (fixture), co� je sada objekt�, s nimi� budou testy pracovat.
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
     * �klid po testu - tato metoda se spust� po vykon�n� ka�d�ho testu.
     */
    @After
    public void tearDown()
    {
    }



    //== P��STUPOV� METODY VLASTNOST� INSTANC� =================================
    //== OSTATN� NESOUKROM� METODY INSTANC� ====================================
    //== SOUKROM� A POMOCN� METODY T��DY =======================================
    //== SOUKROM� A POMOCN� METODY INSTANC� ====================================
    //== INTERN� DATOV� TYPY ===================================================
    //== VLASTN� TESTY =========================================================
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

