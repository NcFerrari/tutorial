package lp.cesky.priklady;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kÛdov·nÌ: P¯Ìliö ûluùouËk˝ k˘Ú ˙pÏl Ô·belskÈ Ûdy. */


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
 * TestovacÌ t¯Ìda {@code VytahTest} slouûÌ ke komplexnÌmu otestov·nÌ
 * t¯Ìdy {@link VytahTest}.
 *
 * @author    jmÈno autora
 * @version   0.00.000
 */
public class VytahTest
{
    public static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    private Elipsa elipsa1;
    private Trojuhelnik trojuhel1;
    private Vytah vytah1;
    private Vytah vytah2;

    //== KONSTANTNÕ ATRIBUTY TÿÕDY =============================================
    //== PROMÃNN… ATRIBUTY TÿÕDY ===============================================
    //== STATICK› INICIALIZA»NÕ BLOK - STATICK› KONSTRUKTOR ====================
    //== KONSTANTNÕ ATRIBUTY INSTANCÕ ==========================================
    //== PROMÃNN… ATRIBUTY INSTANCÕ ============================================
    //== PÿÕSTUPOV… METODY VLASTNOSTÕ TÿÕDY ====================================
    //== OSTATNÕ NESOUKROM… METODY TÿÕDY =======================================

    //##########################################################################
    //== KONSTRUKTORY A TOV¡RNÕ METODY =========================================
    //-- TestovacÌ t¯Ìda vystaËÌ s pr·zdn˝m implicitnÌm konstruktorem ----------
    //== PÿÕPRAVA A ⁄KLID PÿÕPRAVKU ============================================

    /***************************************************************************
     * Inicializace p¯edch·zejÌcÌ spuötÏnÌ kaûdÈho testu a p¯ipravujÌcÌ tzv.
     * p¯Ìpravek (fixture), coû je sada objekt˘, s nimiû budou testy pracovat.
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
     * ⁄klid po testu - tato metoda se spustÌ po vykon·nÌ kaûdÈho testu.
     */
    @After
    public void tearDown()
    {
    }



    //== PÿÕSTUPOV… METODY VLASTNOSTÕ INSTANCÕ =================================
    //== OSTATNÕ NESOUKROM… METODY INSTANCÕ ====================================
    //== SOUKROM… A POMOCN… METODY TÿÕDY =======================================
    //== SOUKROM… A POMOCN… METODY INSTANCÕ ====================================
    //== INTERNÕ DATOV… TYPY ===================================================
    //== VLASTNÕ TESTY =========================================================
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

