/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovac� t��da {@code CinkaOTest} slou�� ke komplexn�mu otestov�n�
 * t��dy {@link CinkaOTest}.
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public class CinkaOTest
{
    public static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private CinkaO cinkaO1;
    private CinkaO cinkaO2;
    private CinkaO cinkaO3;
    private CinkaO cinkaO4;

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
        cinkaO1 = new CinkaO();
        cinkaO2 = new CinkaO(25, 200);
        cinkaO3 = new CinkaO(70, 100, 100, 90);
        cinkaO4 = new CinkaO(200, 0, 100, 300);
        cinkaO1.nakresli();
        cinkaO2.nakresli();
        cinkaO3.nakresli();
        cinkaO4.nakresli();
    }


    /***************************************************************************
     * �klid po testu - tato metoda se spust� po vykon�n� ka�d�ho testu.
     */
    @After
    public void tearDown()
    {
        AP.setKrokRozmer(50, 6, 6);
        AP.odstranVse();
        AP.setMrizka(true);
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
        cinkaO1.smaz();
        cinkaO2.smaz();
        cinkaO3.smaz();
        cinkaO4.smaz();
        assertEquals(true, P.souhlas("Byly �inky smaz�ny?"));
        cinkaO1.nakresli();
        cinkaO2.nakresli();
        cinkaO3.nakresli();
        cinkaO4.nakresli();
        assertEquals(true, P.souhlas("Byly �inky op�t nakresleny?"));
    }
    
    @Test
    public void Posuny()
    {
        P.zprava("N�sleduje posun vpravo");
        cinkaO4.posunVpravo();
        cinkaO3.posunVpravo();
        cinkaO2.posunVpravo();
        cinkaO1.posunVpravo();
        assertEquals(true, P.souhlas("Posun vpravo v po��dku?\n\nN�sleduje posun vlevo."));
        cinkaO1.posunVlevo();
        cinkaO2.posunVlevo();
        cinkaO3.posunVlevo();
        cinkaO4.posunVlevo();
        assertEquals(true, P.souhlas("Posun vlevo vpo��dku?\n\nN�sleduje posun vzh�ru."));
        cinkaO1.posunVzhuru();
        cinkaO3.posunVzhuru();
        cinkaO2.posunVzhuru();
        cinkaO4.posunVzhuru();
        assertEquals(true, P.souhlas("Posun vzh�ru vpo��dku?\n\nN�sleduje posun dol�."));
        cinkaO4.posunDolu();
        cinkaO2.posunDolu();
        cinkaO3.posunDolu();
        cinkaO1.posunDolu();
        assertEquals(true, P.souhlas("Posun dol� vpo��dku?"));
    }
    
    @Test
    public void zaramovani()
    {
        cinkaO1.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        cinkaO2.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        cinkaO3.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        cinkaO4.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
    }
    
    @Test
    public void testStatickeZaramuj()
    {
        AP.odstranVse();
        CinkaO.zaramuj( 200, 300 );
        assertTrue(P.souhlas("Cinka zaramovana?"));
    }
}

