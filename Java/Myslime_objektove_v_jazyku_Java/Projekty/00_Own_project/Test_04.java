/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovac� t��da {@code Test_04} slou�� ke komplexn�mu otestov�n�
 * t��dy {@link Test_04}.
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public class Test_04
{
    private Platno platno1;
    private Obdelnik obdelnik1;
    private Elipsa elipsa1;
    private Trojuhelnik trojuhel1;
    private Strom strom1;

    
    
    
    

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
        platno1 = Platno.getPlatno();
        obdelnik1 = new Obdelnik(0, 0, 50, 100);
        elipsa1 = new Elipsa(50, 0, 50, 100);
        trojuhel1 = new Trojuhelnik(0, 50, 50, 50);
        strom1 = new Strom(100, 50, 100, 200);
    }


    /***************************************************************************
     * �klid po testu - tato metoda se spust� po vykon�n� ka�d�ho testu.
     */
    @After
    public void tearDown()
    {
        assertTrue(P.souhlas("V po��dku?"));
        platno1.setRozmer(300, 300);
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
    public void testZmenaVelikostPlatna()
    {
        platno1.setRozmer(200, 200);
        obdelnik1.nakresli();
        trojuhel1.nakresli();
        elipsa1.nakresli();
        strom1.nakresli();
    }
    
    @Test
    public void testPrehozeni() {
        obdelnik1.setPozice(250, 0);
        trojuhel1.setPozice(250, 50);
        elipsa1.setPozice(200, 0);
        strom1.setPozice(100, 50);
    }
}

