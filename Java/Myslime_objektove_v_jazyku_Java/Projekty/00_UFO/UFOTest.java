/*******************************************************************************
 * Testovaci trida UFOTest slouzi ke komplexnimu otestovani
 * tridy ...
 *
 * @author     Rudolf Pecinovsky
 * @version    1.00, cerven 2004
 */
public class UFOTest extends junit.framework.TestCase
{
    Dispecer dispecer;
    UFO      u1;

//##############################################################################
//== PRIPRAVA A UKLID PRIPRAVKU ================================================

    /***************************************************************************
     * Vytvoreni pripravku (fixture), tj. sady objektu, s nimiz budou vsechny
     * testy pracovat a ktera se proto vytvori pred spustenim kazdeho testu.         
     */
    protected void setUp()
    {
    }


    /***************************************************************************
     * Uklid po testu - tato metoda se spusti po vykonani kazdeho testu.
     */
    protected void tearDown()
    {
    }


//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== VLASTNI TESTY =============================================================

    /***************************************************************************
     * 
     */
    public void testUFO()
    {
        test( false );
    }


    /***************************************************************************
     * 
     */
    public void testUFO_3a()
    {
        test( true );
    }


    /***************************************************************************
     * 
     */
    public void test( boolean u3a )
    {
        final int    TV   = Dispecer.TV;
        final double DTAH = UFO.DTAH;
        final int    f    = 4;  //frekvence

        double px=TV,  py=TV;   //Pozice
        double rx=0,   ry=0;    //rychlsot
        double tx=0,   ty=0;    //tah
        
        dispecer = Dispecer.getDispecer( 1, false );
        if( u3a )
            dispecer.pouzijUFO_3a();
        u1 = dispecer.pristavUFO();
        //----------------------------------------------------------------------
        assertEquals( "Spatne nastavena vodorovna pocatecni souradnice", 
                      px, u1.getX(), .01 );
        assertEquals( "Spatne nastavena svisla pocatecni souradnice", 
                      py, u1.getY(), .01 );
        assertEquals( "Spatne nastavena pocatecni vodorovna rychlost", 
                      rx, u1.getXRychlost(), .01 );
        assertEquals( "Spatne nastavena pocatecni svisla rychlost", 
                      ry, u1.getYRychlost(), .01 );
        assertEquals( "Spatne nastaveny pocatecni vodorovny tah", 
                      tx, u1.getXTah(), .01 );
        assertEquals( "Spatne nastaveny pocatecni svisly tah", 
                      ty, u1.getXTah(), .01 );
        //----------------------------------------------------------------------
        rx = 16;
        ry = 32;
        u1.setRychlost( rx, ry );
        assertEquals( "Metoda setRychlost spatne nastavuje vodorovnou rychlost", 
                      rx, u1.getXRychlost(), .01 );
        assertEquals( "Metoda setRychlost spatne nastavuje svislou rychlost", 
                      ry, u1.getYRychlost(), .01 );
        u1.popojed( 1 );
        assertEquals( "Metoda Popojed spatne nastavuje vodorovnou souradnici" +
                      " pri nulovem tahu motoru a jednotkove frekvenci", 
                      px+=rx, u1.getX(), .01 );
        assertEquals( "Metoda Popojed spatne nastavuje svislou souradnici" +
                      " pri nulovem tahu motoru a jednotkove frekvenci", 
                      py+=ry, u1.getY(), .01 );
        //----------------------------------------------------------------------
        u1.vlevo();
        assertEquals( "Metoda vlevo spatne nastavuje vodorovny tah", 
                      tx-=DTAH, u1.getXTah(), .01 );
        u1.vlevo();
        assertEquals( "Metoda vlevo spatne nastavuje vodorovny tah", 
                      tx-=DTAH, u1.getXTah(), .01 );
        assertEquals( "Metoda vlevo spatne nastavuje svisly tah", 
                      ty, u1.getYTah(), .01 );
        //----------------------------------------------------------------------
        u1.vzhuru();
        assertEquals( "Metoda vzhuru spatne nastavuje svisly tah", 
                      ty-=DTAH, u1.getYTah(), .01 );
        u1.vzhuru();
        assertEquals( "Metoda vzhuru spatne nastavuje svisly tah", 
                      ty-=DTAH, u1.getYTah(), .01 );
        assertEquals( "Metoda vzhuru spatne nastavuje vodorovny tah", 
                      tx, u1.getXTah(), .01 );
        //----------------------------------------------------------------------
        u1.vypniMotory();
        assertEquals( "Metoda vypniMotory nevypina vodorovny tah", 
                      tx=0, u1.getXTah(), .01 );
        assertEquals( "Metoda vypniMotory nevypina svisly tah", 
                      ty=0, u1.getYTah(), .01 );
        //----------------------------------------------------------------------
        u1.vpravo();
        assertEquals( "Metoda vpravo spatne nastavuje vodorovny tah", 
                      tx+=DTAH, u1.getXTah(), .01 );
        u1.vpravo();
        assertEquals( "Metoda vpravo spatne nastavuje vodorovny tah", 
                      tx+=DTAH, u1.getXTah(), .01 );
        u1.vpravo();
        assertEquals( "Metoda vpravo spatne nastavuje vodorovny tah", 
                      tx+=DTAH, u1.getXTah(), .01 );
        assertEquals( "Metoda vpravo spatne nastavuje svisly tah", 
                      ty, u1.getYTah(), .01 );
        //----------------------------------------------------------------------
        u1.dolu();
        assertEquals( "Metoda dolu spatne nastavuje svisly tah", 
                      ty+=DTAH, u1.getYTah(), .01 );
        u1.dolu();
        assertEquals( "Metoda dolu spatne nastavuje svisly tah", 
                      ty+=DTAH, u1.getYTah(), .01 );
        assertEquals( "Metoda dolu spatne nastavuje vodorovny tah", 
                      tx, u1.getXTah(), .01 );
        //----------------------------------------------------------------------
        u1.popojed( 1 );
        assertEquals( "Metoda popojed ovlivnuje vodorovny tah", 
                      tx, u1.getXTah(), .01 );
        assertEquals( "Metoda popojed ovlivnuje svisly tah", 
                      ty, u1.getYTah(), .01 );
        assertEquals( "Metoda Popojed spatne nastavuje vodorovnou rychlost" +
                      " pri NEnulovem tahu motoru a jednotkove frekvenci", 
                      rx+=tx, u1.getXRychlost(), .01 );
        assertEquals( "Metoda Popojed spatne nastavuje svislou rychlost" +
                      " pri NEnulovem tahu motoru a jednotkove frekvenci", 
                      ry+=ty, u1.getYRychlost(), .01 );
        assertEquals( "Metoda Popojed spatne nastavuje vodorovnou souradnici" +
                      " pri NEnulovem tahu motoru a jednotkove frekvenci", 
                      px+=rx, u1.getX(), .01 );
        assertEquals( "Metoda Popojed spatne nastavuje svislou souradnici" +
                      " pri NEnulovem tahu motoru a jednotkove frekvenci", 
                      py+=ry, u1.getY(), .01 );
        //----------------------------------------------------------------------
        u1.popojed( f );
        assertEquals( "Metoda Popojed spatne nastavuje vodorovnou rychlost" +
                      " pri NEnulovem tahu motoru a NEjednotkove frekvenci", 
                      rx+=tx/f, u1.getXRychlost(), .01 );
        assertEquals( "Metoda Popojed spatne nastavuje svislou rychlost" +
                      " pri NEnulovem tahu motoru a NEjednotkove frekvenci", 
                      ry+=ty/f, u1.getYRychlost(), .01 );
        assertEquals( "Metoda Popojed spatne nastavuje vodorovnou souradnici" +
                      " pri NEnulovem tahu motoru a NEjednotkove frekvenci", 
                      px+=rx/f, u1.getX(), .01 );
        assertEquals( "Metoda Popojed spatne nastavuje svislou souradnici" +
                      " pri NEnulovem tahu motoru a NEjednotkove frekvenci", 
                      py+=ry/f, u1.getY(), .01 );
    }
    


    /***************************************************************************
     * 
     */
    public void testRychlost()
    {
        Dispecer dispecer = Dispecer.getDispecer();
        UFO u1 = dispecer.pristavUFO();
            u1.setRychlost(10,10);
        UFO u2 = dispecer.pristavUFO();
            u2.setRychlost(8,12);
        UFO u3 = dispecer.pristavUFO();
            u3.setRychlost(6,12);
        UFO u4 = dispecer.pristavUFO();
            u4.setRychlost(4,15);
        UFO u5 = dispecer.pristavUFO();
            u5.setRychlost(0,20);
    }
    

    /***************************************************************************
     * Vytvori standardnio dispecera a spusti tak hru.
     */
    public void testHra()
    {
        Dispecer dispecer = Dispecer.getDispecer();
    }
    

    /***************************************************************************
     * Vytvori standardnio dispecera a spusti tak hru.
     */
    public void testHra_3a()
    {
        Dispecer dispecer = Dispecer.getDispecer();
        dispecer.pouzijUFO_3a();
    }
    

    /***************************************************************************
     * Vytvori standardnio dispecera a spusti tak hru.
     */
    public void testRychlost_3a()
    {
        Dispecer dispecer = Dispecer.getDispecer();
        dispecer.pouzijUFO_3a();
        testRychlost();
    }
    

    /***************************************************************************
     * 
     * /
    public void testXXX()
    {
    }
    
/**/ 
}

