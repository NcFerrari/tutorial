package lp.cesky.priklady;

import lp.cesky.tvary.*;

/*******************************************************************************
 * Testovaci trida VytahTest slouzi ke komplexnimu otestovani
 * tridy Vytah a demonstraci chovani tridy Vytah_6.
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2004
 */
public class VytahTest2 extends junit.framework.TestCase
{
    private static AktivniPlatno AP = AktivniPlatno.getPlatno();

    private int krok = 50;      //Krok aktivniho platna
    private int sirka = 5;      //Pocet sloupcu aktivniho platna
    private int vyska = 5;      //Pocet radku aktivniho platna
    
    private Vytah v1;        //Vytah v prvnim sloupci
    private Vytah v3;        //Vytah ve tretim sloupci
    
    private Elipsa      k;      //Kruhovy pasazer
    private Trojuhelnik t;      //Trojuhelnikovy pasazer



//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * Vytvori test se zadanym nazvem.
     *  
     * @param nazev  Nazev konstruovaneho testu
     */
    public VytahTest2(String nazev)
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
        AP.setKrokRozmer( krok, sirka, vyska );
        
        k = new Elipsa     ( x(0), y(1), krok, krok, Barva.CERVENA );
        AP.pridej( k );
        t = new Trojuhelnik( x(2), y(4), krok, krok, Barva.CERVENA );
        AP.pridej( t );
        
        v1 = new Vytah( 1 );
        v3 = new Vytah( 3, 4, Barva.MODRA );
    }


    /***************************************************************************
     * Uklid po testu - tato metoda se spusti po vykonani kazdeho testu.
     */
    protected void tearDown()
    {
    }


//== SOUKROME A POMOCNE METODY TRIDY ===========================================

    /***************************************************************************
     * Otestuje, jestli je zadany objekt ve spravenem policku.
     * 
     * @param ip       Odkaz na objekt, jehoz sourqadnice testujeme.
     * @param sloupec  Sloupec, v nemz se ma proverovany objekt nachazet.
     * @param patro    Patro, v nemz se ma proverovany objekt nachazet.
     */
    public static void souradnice( Object ip, int sloupec, int patro )
    {
        assertEquals( "Nesouhlasi vodorovna souradnice objektu " + ip + ":", 
                      x(sloupec), ((IPosuvny)ip).getX() );
        assertEquals( "Nesouhlasi svisla souradnice objektu " + ip + ":", 
                      y(patro), ((IPosuvny)ip).getY() );
    }


    /***************************************************************************
     * Vrati x-ovou souradnici policek v zadanem sloupci;
     */
    public static int x( int sloupec )
    {
        return sloupec * AP.getKrok(); 
    }
    

    /***************************************************************************
     * Vrati y-ovou souradnici policek v zadanem radku;
     */
    public static int y( int patro )
    {
        return (AP.getVyska() - patro - 1) * AP.getKrok();
    }
    

    
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== VLASTNI TESTY =============================================================

    /***************************************************************************
     * Testuje spravne nastaveni pocatecnich podminek. 
     * Predpoklada pritom, ze metody getX() a getY() funguji u vytahu spravne.
     */
    public void testInicializace()
    {
        souradnice( v1, 1, 0 );
        souradnice( v3, 3, 0 );
    }
    

    /***************************************************************************
     * Otestuje, ze oba vytahy umi spravne dojet do 3. patra
     * a sjet zase zpet do prizemi.     
     */
    public void testPrazdnyVytahDoPatra()
    {
        v1.presunDoPatra( 3 );    souradnice( v1, 1, 3 );
        v3.presunDoPatra( 3 );    souradnice( v3, 3, 3 );
        v1.presunDoPatra( 0 );    souradnice( v1, 1, 0 );
        v3.presunDoPatra( 0 );    souradnice( v3, 3, 0 );
    }
    

    /***************************************************************************
     * Otestuje, ze oba vytahy umi spravne dojet do 3. patra
     * a sjet zase zpet do prizemi.     
     */
    public void testPrijedK()
    {
        v1.prijedK( k );    souradnice( v1, 1, 1 );
        v3.prijedK( t );    souradnice( v3, 3, 4 );
    }
    


    /***************************************************************************
     * Testuje schopnost vytahu premistit nastupujici pasazery do vytahu a
     * pak je vysadit na sousedni policko v zadnem smeru.
     */
    public void testNastupVystup()
    {
        v1.prijedK( k );
        v1.nastup( k );    souradnice( k, 1, 1 );

        v3.prijedK( t );
        v3.nastup( t );    souradnice( t, 3, 4 );

        v1.vystupVlevo(k);  souradnice( k, 0, 1 );
        v3.vystupVpravo(t); souradnice( t, 4, 4 );
    }
    

    /***************************************************************************
     * Testuje schopnost vytahu prevezt pasazery do pozadovaneho patra.
     */
    public void testPrevozPasazera()
    {
        v1.prijedK( k );
        v1.nastup( k );
        v1.presunDoPatra( 4 );
        v1.vystupVlevo(k);
        souradnice( k, 0, 4 );
        
        v3.prijedK( t );
        v3.nastup( t );
        v3.presunDoPatra( 0 );
        v3.vystupVpravo(t); 
        souradnice( t, 4, 0 );
    }
    

    /***************************************************************************
     * Testuje metody zabezpecujici kompletni obsluhu pasazera, 
     * tj. dojeti do jeho patra, nastup, prevezeni do pozadovaneho patra
     * a vysazeni pasazera na pozadovanou stranu.
     */
    public void testOdvez()
    {
        v1.odvezAVystupVpravo( k, 3 );   
        souradnice( v1, 1, 3 );  souradnice( k, 2, 3 );
        
        v3.odvezAVystupVlevo ( t, 1 );
        souradnice( v3, 3, 1 );  souradnice( t, 2, 1 );
        
        v3.odvezAVystupVpravo( k, 0 );
        souradnice( v3, 3, 0 );  souradnice( k, 4, 0 );
        
        v1.odvezAVystupVlevo ( t, 0 );
        souradnice( v1, 1, 0 );  souradnice( t, 0, 0 );
    }
    

    /***************************************************************************
     * Testuje metody zabezpecujici kompletni obsluhu pasazera, 
     * tj. dojeti do jeho patra, nastup, prevezeni do pozadovaneho patra
     * a vysazeni pasazera na pozadovanou stranu.
     */
    public void testOdvez_6()
    {
        assertTrue( "Trida Vytah musi implementovat rozhrani IKresleny",
                    v1 instanceof IKresleny );
        //Pretypovani na Object je tu proto, aby sla trida prelozit jeste
        //pred tim, nez uzivatel definuje implementaci rozhrani IKresleny
        Object o1 = v1;
        Object o3 = v3;
        if( AP.poradi( (IKresleny)o1 ) >= 0 )  
            AP.odstran( (IKresleny)o1 );
        if( AP.poradi( (IKresleny)o3 ) >= 0 )  
            AP.odstran( (IKresleny)o3 );
        
        Vytah r1 = new Vytah( 1 );
        Vytah r3 = new Vytah( 3, 4, Barva.MODRA );
        
        r1.odvezAVystupVpravo( k, 3 );   
        souradnice( r1, 1, 3 );  souradnice( k, 2, 3 );
        
        r3.odvezAVystupVlevo ( t, 1 );
        souradnice( r3, 3, 1 );  souradnice( t, 2, 1 );
        
        r3.odvezAVystupVpravo( k, 0 );
        souradnice( r3, 3, 0 );  souradnice( k, 4, 0 );
        
        r1.odvezAVystupVlevo ( t, 0 );
        souradnice( r1, 1, 0 );  souradnice( t, 0, 0 );
    }
    

    /***************************************************************************
     * 
     * /
    public void testXXX()
    {
    }
    
/**/ 

}

