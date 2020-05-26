package lp.cesky.priklady;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

import lp.cesky.tvary.AktivniPlatno;
import lp.cesky.tvary.Presouvac;
import lp.cesky.tvary.Elipsa;
import lp.cesky.tvary.Trojuhelnik;
import lp.cesky.tvary.Barva;
import lp.cesky.spolecne.P;

/*******************************************************************************
 * Testovac� t��da {@code VytahTest} slou�� ke komplexn�mu otestov�n�
 * t��dy {@link VytahTest}.
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public class VytahTest
{
    public static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private Elipsa elipsa1;
    private Trojuhelnik trojuhel1;
    private Vytah vytah1;
    private Vytah vytah2;

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
        AP.odstranVse();
        AP.setKrokRozmer(50, 5, 5);
        elipsa1 = new Elipsa(0, 150, 50, 50, Barva.CERVENA);
        trojuhel1 = new Trojuhelnik(100, 0, 50, 50, Barva.CERVENA);
        AP.pridej(elipsa1);
        AP.pridej(trojuhel1);
        vytah1 = new Vytah(1);
        vytah2 = new Vytah(3, 4, Barva.MODRA);
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
    public void testPrazdnyVytahDoPatra()
    {
        vytah1.presunDoPatra(3);
        vytah2.presunDoPatra(3);
        vytah1.presunDoPatra(0);
        vytah2.presunDoPatra(0);
    }
    
    @Test
    public void testPrevozPasazera() {
        vytah1.presunDoPatra(1);
        vytah1.nastup(elipsa1);
        vytah1.presunDoPatra(4);
        vytah1.vystupVlevo(elipsa1);
        vytah2.presunDoPatra(4);
        vytah2.nastup(trojuhel1);
        vytah2.presunDoPatra(0);
        vytah2.vystupVpravo(trojuhel1);
    }
    
    @Test
    public void testNastupVystup() {
        vytah1.presunDoPatra(1);
        vytah1.nastup(elipsa1);
        vytah2.presunDoPatra(4);
        vytah2.nastup(trojuhel1);
        vytah1.vystupVlevo(elipsa1);
        vytah2.vystupVpravo(trojuhel1);
    }
    
    @Test
    public void testPrijedK() {
        vytah1.prijedK(elipsa1);
        vytah2.prijedK(trojuhel1);
    }
    
    @Test
    public void testOdvez() {
        vytah1.odvezAVystupVpravo(elipsa1, 3);
        vytah2.odvezAVystupVlevo(trojuhel1, 1);
        vytah2.odvezAVystupVpravo(elipsa1, 0);
    }
}

