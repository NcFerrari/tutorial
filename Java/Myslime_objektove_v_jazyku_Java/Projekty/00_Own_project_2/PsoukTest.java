/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovac� t��da {@code PsoukTest} slou�� ke komplexn�mu otestov�n�
 * t��dy {@link PsoukTest}.
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public class PsoukTest
{
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
    public void psouk()
    {
        Strom stom = new Strom(100, 100, 100, 100);
        AktivniPlatno AP = AktivniPlatno.getPlatno();
        AP.pridej(stom);
        Psouk psouk1 = new Psouk(50);
        psouk1.prifoukni(stom);
        psouk1.ufoukni(stom);
    }
    
    @Test
    public void kompresor()
    {
        Strom stom = new Strom(100, 100, 100, 100);
        AktivniPlatno AP = AktivniPlatno.getPlatno();
        AP.pridej(stom);
        Kompresor kompresor1 = new Kompresor(50);
        kompresor1.prifoukni(stom);
        kompresor1.ufoukni(stom);
    }
}

