package priklady;

import rup.cesky.spolecne.P;
import rup.cesky.tvary.Barva;
import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.Kompresor;
import rup.cesky.tvary.Presouvac;


/*******************************************************************************
 * Testovaci trida Terc_9Test slouzi ke komplexnimu otestovani
 * tridy ...
 *
 * @author    Rudolf Pecinovsky
 * @version   1.00,  05.2004
 */
public class Terc_9Test extends junit.framework.TestCase
{
    private AktivniPlatno AP;
    private int           krok, k1, k2, k3;
    private Terc_9        t1;
    private Terc_9        t2;
    private Terc_9        t3;


//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori test se zadanym nazvem.
     *
     * @param nazev  Nazev konstruovaneho testu
     */
    public Terc_9Test(String nazev)
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
        krok = 50;
        AP = AktivniPlatno.getPlatno();
        AP.odstranVse();
        AP.setKrokRozmer( krok, 6, 6 );

        k1 = krok / 2;
        t1 = new Terc_9();

        k2 = 2*krok;
        t2 = new Terc_9( k2, k2, k2 );

        k3 = (int)(4.5 * krok);
        t3 = new Terc_9( k3, k3, 3*krok,
                         Barva.CERVENA, Barva.ZELENA, Barva.AZUROVA );
        AP.pridej( t1 );
        AP.pridej( t2 );
        AP.pridej( t3 );
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
     * /
    public void testXXX()
    {
    }

/**/

    /***************************************************************************
     *
     */
    public void testPosuny()
    {
        for( int i=0;   i < 2;   i++ )
        {
            assertTrue( P.souhlas(getName(), "Prijde posun vpravo") );
            t1.posunVpravo();
            t2.posunVpravo();
            t3.posunVpravo();
            assertEquals( "\nx-ova souradnice 1. terce", k1+krok, t1.getX() );
            assertEquals( "\ny-ova souradnice 1. terce", k1,      t1.getY() );
            assertEquals( "\nx-ova souradnice 2. terce", k2+krok, t2.getX() );
            assertEquals( "\ny-ova souradnice 2. terce", k2,      t2.getY() );
            assertEquals( "\nx-ova souradnice 3. terce", k3+krok, t3.getX() );
            assertEquals( "\ny-ova souradnice 3. terce", k3,      t3.getY() );

            assertTrue( P.souhlas(getName(), "Prijde posun dolu") );
            t1.posunDolu();
            t2.posunDolu();
            t3.posunDolu();
            assertEquals( "\nx-ova souradnice 1. terce", k1+krok, t1.getX() );
            assertEquals( "\ny-ova souradnice 1. terce", k1+krok, t1.getY() );
            assertEquals( "\nx-ova souradnice 2. terce", k2+krok, t2.getX() );
            assertEquals( "\ny-ova souradnice 2. terce", k2+krok, t2.getY() );
            assertEquals( "\nx-ova souradnice 3. terce", k3+krok, t3.getX() );
            assertEquals( "\ny-ova souradnice 3. terce", k3+krok, t3.getY() );

            assertTrue( P.souhlas(getName(), "Prijde posun vlevo") );
            t1.posunVlevo();
            t2.posunVlevo();
            t3.posunVlevo();
            assertEquals( "\nx-ova souradnice 1. terce", k1,      t1.getX() );
            assertEquals( "\ny-ova souradnice 1. terce", k1+krok, t1.getY() );
            assertEquals( "\nx-ova souradnice 2. terce", k2,      t2.getX() );
            assertEquals( "\ny-ova souradnice 2. terce", k2+krok, t2.getY() );
            assertEquals( "\nx-ova souradnice 3. terce", k3,      t3.getX() );
            assertEquals( "\ny-ova souradnice 3. terce", k3+krok, t3.getY() );

            assertTrue( P.souhlas(getName(), "Prijde posun vzhuru") );
            t1.posunVzhuru();
            t2.posunVzhuru();
            t3.posunVzhuru();
            assertEquals( "\nx-ova souradnice 1. terce", k1,      t1.getX() );
            assertEquals( "\ny-ova souradnice 1. terce", k1,      t1.getY() );
            assertEquals( "\nx-ova souradnice 2. terce", k2,      t2.getX() );
            assertEquals( "\ny-ova souradnice 2. terce", k2,      t2.getY() );
            assertEquals( "\nx-ova souradnice 3. terce", k3,      t3.getX() );
            assertEquals( "\ny-ova souradnice 3. terce", k3,      t3.getY() );

            if( i == 1 )   break;

            assertTrue( P.souhlas(getName(), "Krok se zmensi na polovinu") );
            AP.setKrokRozmer( krok/2, 2*(AP.getSirka()+1), 2*(AP.getVyska()+1) );

            assertTrue( P.souhlas(getName(), "Prijde posun vpravo o " + 2*krok) );
            t1.posunVpravo(krok);
            t2.posunVpravo(krok);
            t3.posunVpravo(krok);

            assertTrue( P.souhlas(getName(), "Prijde posun dolu o " + 2*krok) );
            t1.posunDolu(krok);     k1 += krok;
            t2.posunDolu(krok);     k2 += krok;
            t3.posunDolu(krok);     k3 += krok;
            assertEquals( "\nx-ova souradnice 1. terce", k1,      t1.getX() );
            assertEquals( "\ny-ova souradnice 1. terce", k1,      t1.getY() );
            assertEquals( "\nx-ova souradnice 2. terce", k2,      t2.getX() );
            assertEquals( "\ny-ova souradnice 2. terce", k2,      t2.getY() );
            assertEquals( "\nx-ova souradnice 3. terce", k3,      t3.getX() );
            assertEquals( "\ny-ova souradnice 3. terce", k3,      t3.getY() );

            krok /= 2;
        }
        assertTrue( P.souhlas(getName(), "V poradku posunuto") );
    }


    /***************************************************************************
     *
     */
    public void testPresouvace()
    {
        AP.odstran( t2 );
        AP.odstran( t3 );

        Presouvac presouvac3 = new Presouvac(3);
        Presouvac presouvac9 = new Presouvac(9);

        presouvac3.presunNa( t1, 150, 50 );
        assertEquals( "\nx-ova souradnice 1. terce", 150, t1.getX() );
        assertEquals( "\ny-ova souradnice 1. terce",  50, t1.getY() );
        presouvac9.presunNa( t1, 150, 150 );
        assertEquals( "\nx-ova souradnice 1. terce", 150, t1.getX() );
        assertEquals( "\ny-ova souradnice 1. terce", 150, t1.getY() );

        assertTrue( P.souhlas(getName(),
            "Objekt presunut na [150;150]?") );

        presouvac3 = presouvac9 = null;
    }


    /***************************************************************************
     *
     */
    public void testHybaci()
    {
        AP.odstran( t2 );
        AP.odstran( t3 );

        int k2 = 25;
        int kr = 2*k2;

        AP.setKrokRozmer( kr, 5, 5 );
        t1.setPozice( 5*k2, 5*k2 );
        assertTrue( P.souhlas(getName(), "Umisten ve stredu platna?") );
        t1.setRozmer( 4*kr, 4*kr );
        assertTrue( P.souhlas(getName(), "Zvetsen na rozmer 4\u00d74 pole?") );
        t1.setRozmer( 2*kr, 2*kr );
        assertTrue( P.souhlas(getName(), "Zmensen na rozmer 2\u00d72 pole?") );

        Kompresor pk = new Kompresor( 4 );
        pk.nafoukniNa( t1, 4*kr, 4*kr );
        pk.nafoukniNa( t1, kr,   kr );
    }
}

