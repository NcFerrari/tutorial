/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovac� t��da {@code CinkaKTest} slou�� ke komplexn�mu otestov�n�
 * t��dy {@link CinkaKTest}.
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public class CinkaKTest
{
    private CinkaK cinkaK1;
    private CinkaK cinkaK2;
    private CinkaK cinkaK3;
    private CinkaK cinkaK4;

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
        cinkaK1 = new CinkaK();
        cinkaK2 = new CinkaK(25, 200);
        cinkaK3 = new CinkaK(70, 100, 100, 90);
        cinkaK4 = new CinkaK(200, 0, 100, 300);
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
    public void NakresliSmaz()
    {
        cinkaK1.smaz();
        cinkaK2.smaz();
        cinkaK3.smaz();
        cinkaK4.smaz();
        assertEquals(true, P.souhlas("Byly �inky smaz�ny?"));
        cinkaK1.nakresli();
        cinkaK2.nakresli();
        cinkaK3.nakresli();
        cinkaK4.nakresli();
        assertEquals(true, P.souhlas("Byly �inky op�t nakresleny?"));
    }
    
    @Test
    public void Posuny()
    {
        P.zprava("N�sleduje posun vpravo");
        cinkaK4.posunVpravo();
        cinkaK3.posunVpravo();
        cinkaK2.posunVpravo();
        cinkaK1.posunVpravo();
        assertEquals(true, P.souhlas("Posun vpravo v po��dku?\n\nN�sleduje posun vlevo."));
        cinkaK1.posunVlevo();
        cinkaK2.posunVlevo();
        cinkaK3.posunVlevo();
        cinkaK4.posunVlevo();
        assertEquals(true, P.souhlas("Posun vlevo vpo��dku?\n\nN�sleduje posun vzh�ru."));
        cinkaK1.posunVzhuru();
        cinkaK3.posunVzhuru();
        cinkaK2.posunVzhuru();
        cinkaK4.posunVzhuru();
        assertEquals(true, P.souhlas("Posun vzh�ru vpo��dku?\n\nN�sleduje posun dol�."));
        cinkaK4.posunDolu();
        cinkaK2.posunDolu();
        cinkaK3.posunDolu();
        cinkaK1.posunDolu();
        assertEquals(true, P.souhlas("Posun dol� vpo��dku?"));
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
