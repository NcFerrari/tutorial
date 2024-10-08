package lp.cesky.priklady;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

import lp.cesky.tvary.AktivniPlatno;
import lp.cesky.tvary.Presouvac;
import lp.cesky.spolecne.P;

/*******************************************************************************
 * Testovac� t��da {@code HvezdaTest} slou�� ke komplexn�mu otestov�n�
 * t��dy {@link HvezdaTest}.
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public class HvezdaTest
{
    public static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private Hvezda hvezda1;
    private Hvezda hvezda2;
    private Hvezda hvezda3;
    private Hvezda hvezda4;

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
        hvezda1 = new Hvezda();
        hvezda2 = new Hvezda(25, 200);
        hvezda3 = new Hvezda(70, 100, 100, 90);
        hvezda4 = new Hvezda(200, 0, 100, 300);
        hvezda1.nakresli();
        hvezda2.nakresli();
        hvezda3.nakresli();
        hvezda4.nakresli();
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
        hvezda1.smaz();
        hvezda2.smaz();
        hvezda3.smaz();
        hvezda4.smaz();
        assertEquals(true, P.souhlas("Byly hv�zdy smaz�ny?"));
        hvezda1.nakresli();
        hvezda2.nakresli();
        hvezda3.nakresli();
        hvezda4.nakresli();
        assertEquals(true, P.souhlas("Byly hv�zdy op�t nakresleny?"));
    }
    
    @Test
    public void Posuny()
    {
        P.zprava("N�sleduje posun vpravo");
        hvezda4.posunVpravo();
        hvezda3.posunVpravo();
        hvezda2.posunVpravo();
        hvezda1.posunVpravo();
        assertEquals(true, P.souhlas("Posun vpravo v po��dku?\n\nN�sleduje posun vlevo."));
        hvezda1.posunVlevo();
        hvezda2.posunVlevo();
        hvezda3.posunVlevo();
        hvezda4.posunVlevo();
        assertEquals(true, P.souhlas("Posun vlevo vpo��dku?\n\nN�sleduje posun vzh�ru."));
        hvezda4.posunVzhuru();
        hvezda3.posunVzhuru();
        hvezda2.posunVzhuru();
        hvezda1.posunVzhuru();
        assertEquals(true, P.souhlas("Posun vzh�ru vpo��dku?\n\nN�sleduje posun dol�."));
        hvezda1.posunDolu();
        hvezda2.posunDolu();
        hvezda3.posunDolu();
        hvezda4.posunDolu();
        assertEquals(true, P.souhlas("Posun dol� vpo��dku?"));
    }
    
    @Test
    public void zaramovani()
    {
        hvezda1.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        hvezda2.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        hvezda3.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
        hvezda4.zaramuj();
        assertEquals(true, P.souhlas("ok?"));
    }
    
    @Test
    public void testStatickeZaramuj()
    {
        AP.odstranVse();
        Hvezda.zaramuj( 200, 300 );
        assertTrue(P.souhlas("Hvezda zaramovana?"));
    }
    
    @Test
    public void plynulePresun()
    {
        AP.odstranVse();
        Presouvac pres1 = new Presouvac();
        assertEquals(true, AP.pridej(hvezda1));
        pres1.presunO(hvezda1, 100, 100);
        Presouvac pres5 = new Presouvac(5);
        pres5.presunO(hvezda1, -100, -100);
        pres5.presunNa(hvezda1, 200, 150);
    }
}
