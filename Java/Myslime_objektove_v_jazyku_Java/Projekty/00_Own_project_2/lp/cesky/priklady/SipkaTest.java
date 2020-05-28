/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */
package lp.cesky.priklady;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

import lp.cesky.spolecne.P;

/*******************************************************************************
 * Testovac� t��da {@code SipkaTest} slou�� ke komplexn�mu otestov�n�
 * t��dy {@link SipkaTest}.
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public class SipkaTest
{
    private lp.cesky.priklady.Sipka sipka1;

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
        sipka1 = new Sipka();
        
    }


    /***************************************************************************
     * �klid po testu - tato metoda se spust� po vykon�n� ka�d�ho testu.
     */
    @After
    public void tearDown()
    {
        lp.cesky.tvary.AktivniPlatno.getPlatno().odstranVse();
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
    public void testOkolo()
    {
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vpravoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vpravoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vpravoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vpravoVbok();
        
        P.cekej(1000);
        
        sipka1.vpravoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vlevoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vlevoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vlevoVbok();
        sipka1.vpred();
        sipka1.vpred();
        sipka1.vlevoVbok();
        sipka1.vlevoVbok();
    }
}

