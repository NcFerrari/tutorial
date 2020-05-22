/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovac� t��da {@code PanacekTest} slou�� ke komplexn�mu otestov�n�
 * t��dy {@link PanacekTest}.
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public class PanacekTest
{
    public static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private Panacek panacek1;
    private Panacek panacek2;
    private Panacek panacek3;
    private Panacek panacek4;

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
        panacek1 = new Panacek();
        panacek2 = new Panacek(25, 200);
        panacek3 = new Panacek(70, 100, 100, 90);
        panacek4 = new Panacek(200, 0, 100, 300);
        panacek1.nakresli();
        panacek2.nakresli();
        panacek3.nakresli();
        panacek4.nakresli();
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
        panacek1.smaz();
        panacek2.smaz();
        panacek3.smaz();
        panacek4.smaz();
        assertEquals(true, P.souhlas("Byli pan��ci smaz�ni?"));
        panacek1.nakresli();
        panacek2.nakresli();
        panacek3.nakresli();
        panacek4.nakresli();
        assertEquals(true, P.souhlas("Byli pan��ci op�t nakresleni?"));
    }
    
    @Test
    public void Posuny()
    {
        P.zprava("N�sleduje posun vpravo");
        panacek4.posunVpravo();
        panacek3.posunVpravo();
        panacek2.posunVpravo();
        panacek1.posunVpravo();
        assertEquals(true, P.souhlas("Posun vpravo v po��dku?\n\nN�sleduje posun vlevo."));
        panacek1.posunVlevo();
        panacek2.posunVlevo();
        panacek3.posunVlevo();
        panacek4.posunVlevo();
        assertEquals(true, P.souhlas("Posun vlevo vpo��dku?\n\nN�sleduje posun vzh�ru."));
        panacek4.posunVzhuru();
        panacek3.posunVzhuru();
        panacek2.posunVzhuru();
        panacek1.posunVzhuru();
        assertEquals(true, P.souhlas("Posun vzh�ru vpo��dku?\n\nN�sleduje posun dol�."));
        panacek1.posunDolu();
        panacek2.posunDolu();
        panacek3.posunDolu();
        panacek4.posunDolu();
        assertEquals(true, P.souhlas("Posun dol� vpo��dku?"));
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
    
    @Test
    public void testStatickeZaramuj()
    {
        AP.odstranVse();
        Panacek.zaramuj( 200, 300 );
        assertTrue(P.souhlas("Panacek zaramovan?"));
    }
    
    @Test
    public void plynulePresun()
    {
        AP.odstranVse();
        Presouvac pres1 = new Presouvac();
        assertEquals(true, AP.pridej(panacek1));
        pres1.presunO(panacek1, 100, 100);
        Presouvac pres5 = new Presouvac(5);
        pres5.presunO(panacek1, -100, -100);
        pres5.presunNa(panacek1, 200, 150);
    }
}
