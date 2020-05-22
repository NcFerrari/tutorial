/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testovac� t��da {@code PanenkaTest} slou�� ke komplexn�mu otestov�n�
 * t��dy {@link PanenkaTest}.
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public class PanenkaTest
{
    public static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private Panenka panenka1;
    private Panenka panenka2;
    private Panenka panenka3;
    private Panenka panenka4;

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
        panenka1 = new Panenka();
        panenka2 = new Panenka(25, 200);
        panenka3 = new Panenka(70, 100, 100, 90);
        panenka4 = new Panenka(200, 0, 100, 300);
        panenka1.nakresli();
        panenka2.nakresli();
        panenka3.nakresli();
        panenka4.nakresli();
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
        panenka1.smaz();
        panenka2.smaz();
        panenka3.smaz();
        panenka4.smaz();
        assertEquals(true, P.souhlas("Byly panenky smaz�ny?"));
        panenka1.nakresli();
        panenka2.nakresli();
        panenka3.nakresli();
        panenka4.nakresli();
        assertEquals(true, P.souhlas("Byly panenky op�t nakresleny?"));
    }
    
    @Test
    public void Posuny()
    {
        P.zprava("N�sleduje posun vpravo");
        panenka4.posunVpravo();
        panenka3.posunVpravo();
        panenka2.posunVpravo();
        panenka1.posunVpravo();
        assertEquals(true, P.souhlas("Posun vpravo v po��dku?\n\nN�sleduje posun vlevo."));
        panenka1.posunVlevo();
        panenka2.posunVlevo();
        panenka3.posunVlevo();
        panenka4.posunVlevo();
        assertEquals(true, P.souhlas("Posun vlevo vpo��dku?\n\nN�sleduje posun vzh�ru."));
        panenka4.posunVzhuru();
        panenka3.posunVzhuru();
        panenka2.posunVzhuru();
        panenka1.posunVzhuru();
        assertEquals(true, P.souhlas("Posun vzh�ru vpo��dku?\n\nN�sleduje posun dol�."));
        panenka1.posunDolu();
        panenka2.posunDolu();
        panenka3.posunDolu();
        panenka4.posunDolu();
        assertEquals(true, P.souhlas("Posun dol� vpo��dku?"));
    }
    
    @Test
    public void zaramovani()
    {
        panenka1.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        panenka2.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        panenka3.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        panenka4.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
    }
    
    @Test
    public void testStatickeZaramuj()
    {
        AP.odstranVse();
        Panenka.zaramuj( 200, 300 );
        assertTrue(P.souhlas("Panenka zaramovana?"));
    }
}
