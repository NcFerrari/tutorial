package priklady;

import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.Ctverec;
import rup.cesky.tvary.Presouvac;

import rup.cesky.spolecne.P;

import static rup.cesky.tvary.Barva.*;

/*******************************************************************************
 * Testovaci trida Sbl_MinJUnitTest slouzi ke komplexnimu otestovani tridy
 * Sbl_MinJUnit 
 *
 * @author    Rudolf Pecinovsky
 * @author    jmeno autora
 * @version   0.00.000,  0.0.2004
 */
public class Mnohotvar_14Test extends junit.framework.TestCase
{
    private AktivniPlatno AP = AktivniPlatno.getPlatno();
    private Mnohotvar_14 petka;
    private Ctverec ccc, csv, csz, cjz, cjv, cc;
    
    private boolean tp = true;
    
    
//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori test se zadanym nazvem.
     *  
     * @param nazev  Nazev konstruovaneho testu
     */
    public Mnohotvar_14Test(String nazev)
    {
        super( nazev );
    }



//== PRIPRAVA A UKLID PRIPRAVKU ================================================

    /***************************************************************************
     * Vytvoreni pripravku (fixture), tj. sady objektu, s nimiz budou vsechny
     * testy pracovat a ktera se proto vytvori pred spustenim kazdeho testu.         
     */
    protected void setUp()
    {
        AP.odstranVse();
        AP.setKrokRozmer( 50, 6, 6 );
        AP.setMrizka( true );
        petka = new Mnohotvar_14( "Petka" );
    }


    /***************************************************************************
     * Uklid po testu - tato metoda se spusti po vykonani kazdeho testu.
     */
    protected void tearDown()
    {
    }


//== SOUKROME A POMOCNE METODY INSTANCI ========================================
    
    private int cekani = 500;
    
    private void overOblast( String pocText, Mnohotvar_14 tvar, 
                             int x, int y, int sirka, int vyska )
    {
        P.cekej( cekani );    //Aby byl cas si vysledek akce prohlednout 
        String pt = "\n" + pocText + ", spatna ";
        assertEquals( pt + "x-ova souradnice", x, tvar.getX() );
        assertEquals( pt + "y-ova souradnice", y, tvar.getY() );
        assertEquals( pt + "sirka", sirka, tvar.getSirka() );
        assertEquals( pt + "vyska", vyska, tvar.getVyska() );
    }
//== VLASTNI TESTY =============================================================

    /***************************************************************************
     * 
     */
    public void testPrazdny()
    {
        AP.pridej( petka );
        overOblast( "Prazdny tvar", petka, 0, 0, 0, 0 );
        assertEquals( "Nazev neodpovida", "Petka", petka.getNazev() );
    }

    
    /***************************************************************************
     * 
     */
    public void testPetka()
    {
        if( !tp ) 
            return;
        AP.pridej( petka );
        petka.pridej( ccc = new Ctverec( 100, 100, 50 ) );
        overOblast( "Stred", petka, 100, 100, 50, 50 );
        petka.pridej( csz = new Ctverec( 50, 50, 50 ) );
        overOblast( "SZ", petka, 50, 50, 100, 100 );
        petka.pridej( cjz = new Ctverec( 50, 150, 50 ) );
        overOblast( "JZ", petka, 50, 50, 100, 150 );
        petka.pridej( cjv = new Ctverec( 150, 150, 50 ) );
        overOblast( "JV", petka, 50, 50, 150, 150 );
        petka.pridej( csv = new Ctverec( 150, 50, 50 ) );
        overOblast( "SV", petka, 50, 50, 150, 150 );
    }
    
    
    /***************************************************************************
     * 
     */
    public void testPosuny()
    {
        cekani = 0;
        testPetka();
        cekani = 500;
        petka.posunVpravo();
        overOblast( "Posun vpravo", petka, 100, 50, 150, 150 );
        petka.posunDolu();
        overOblast( "Posun dolu", petka, 100, 100, 150, 150 );
        petka.posunVlevo();
        overOblast( "Posun vlevo", petka, 50, 100, 150, 150 );
        petka.posunVzhuru();
        overOblast( "Posun vzhuru", petka, 50, 50, 150, 150 );
        petka.setPozice( 0, 0 );
        overOblast( "Pozice[0;0]", petka, 0, 0, 150, 150 );
        Presouvac p = new Presouvac( 5 );
        p.presunNa( petka, 150, 150 );
        overOblast( "Pozice[0;0]", petka, 150, 150, 150, 150 );
    }


    /***************************************************************************
     * 
     */
    public void testRozmery()
    {
        cekani = 0;
        testPetka();
        P.cekej( 1000 );
        cekani = 1000;
        petka.setRozmer( 50, 50 );
        overOblast( "Rozmer 50\u00d750", petka, 50, 50, 50, 50 );
        petka.setRozmer( 5, 5 );
        overOblast( "Rozmer 50\u00d750", petka, 50, 50, 5, 5 );
        petka.setPozice( 0, 0 );
        petka.setRozmer( 300, 300 );
        overOblast( "Rozmer 150\u00d7150", petka, 0, 0, 300, 300 );
        cekani = 500;
    }


    /***************************************************************************
     * 
     */
    public void testVrstvy()
    {
        cekani = 0;
        testPetka();
        petka.pridejPod( csz, new Ctverec(  75,  75,  50, RUZOVA ) );
        petka.pridejNad( ccc, new Ctverec( 125, 125,  50, ZLATA ) );
        petka.pridejDolu(     new Ctverec(  75,  75, 100, AZUROVA ) );
        petka.pridejNahoru(   new Ctverec(  12,  12, 150, 
            new rup.cesky.tvary.Barva( 255, 255, 255, 192 ) ) );
        tp = false;

        P.cekej(1000);
        petka.setPozice(  50,  50 );
        P.cekej(1000);
        petka.setRozmer( 150, 150 );

        P.cekej(1000);
        testPosuny();

        petka.setPozice(  50,  50 );
        petka.setRozmer( 150, 150 );
        testRozmery();
    }
    

    /***************************************************************************
     * 
     * /
    public void testXXX()
    {
    }
    
/**/ 
}

