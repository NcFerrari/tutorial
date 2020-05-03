package priklady;

import rup.cesky.spolecne.P;
import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.Kompresor;
import rup.cesky.tvary.Presouvac;


/*******************************************************************************
 * Testovaci trida XObdelnikTest slouzi ke komplexnimu otestovani tridy
 * XObdelnik.
 *
 * @author    Rudolf Pecinovsky
 * @version   1.00,  05.2004
 */
public class XObdelnikTest extends junit.framework.TestCase
{
    private AktivniPlatno AP;
    private int krok;
    private XObdelnik xo1;

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori test se zadanym nazvem.
     *
     * @param nazev  Nazev konstruovaneho testu
     */
    public XObdelnikTest(String nazev)
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
        xo1  = new XObdelnik();
        AP.pridej( xo1 );
    }


    /***************************************************************************
     * Uklid po testu - tato metoda se spusti po vykonani kazdeho testu.
     */
    protected void tearDown()
    {
    }


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
            xo1.posunVpravo();

            assertTrue( P.souhlas(getName(), "Prijde posun dolu") );
            xo1.posunDolu();

            assertTrue( P.souhlas(getName(), "Prijde posun vlevo") );
            xo1.posunVlevo();

            assertTrue( P.souhlas(getName(), "Prijde posun vzhuru") );
            xo1.posunVzhuru();

            if( i == 1 )   break;

            assertTrue( P.souhlas(getName(), "Krok se zmensi na polovinu") );
            AP.setKrokRozmer( krok /= 2, 8, 8 );

            assertTrue( P.souhlas(getName(), "Prijde posun vpravo o " + 2*krok) );
            xo1.posunVpravo(2*krok);

            assertTrue( P.souhlas(getName(), "Prijde posun dolu o " + 2*krok) );
            xo1.posunDolu(2*krok);
        }
        assertTrue( P.souhlas(getName(), "V poradku posunuto") );
    }


    /***************************************************************************
     *
     */
    public void testPresovace()
    {
        Presouvac presouvac3 = new Presouvac(3);
        Presouvac presouvac9 = new Presouvac(9);

        presouvac3.presunNa( xo1, 150, 50 );
        assertEquals( "\nx-ova souradnice xobdelniku", 150, xo1.getX() );
        assertEquals( "\ny-ova souradnice xobdelniku",  50, xo1.getY() );
        presouvac9.presunNa( xo1, 150, 150 );
        assertEquals( "\nx-ova souradnice elipsy", 150, xo1.getX() );
        assertEquals( "\ny-ova souradnice elipsy", 150, xo1.getY() );

        assertTrue( P.souhlas(getName(),
            "Objekty presunuty na [150;150]?") );

        presouvac3 = presouvac9 = null;
    }


    /***************************************************************************
     *
     */
    public void testHybaci()
    {
        int k2 = 25;
        int kr = 2*k2;

        AP.setKrokRozmer( kr, 6, 6 );
        xo1.setPozice( 3*kr, 3*kr );
        assertTrue( P.souhlas(getName(), "Umisten ve stredu platna?") );
        xo1.setRozmer( 4*kr, 4*kr );
        assertTrue( P.souhlas(getName(), "Zvetsen na rozmer 4\u00d74 pole?") );
        xo1.setRozmer( 2*kr, 2*kr );
        assertTrue( P.souhlas(getName(), "Zmensen na rozmer 2\u00d72 pole?") );

        Kompresor pk = new Kompresor( 4 );
        pk.nafoukniNa( xo1, 4*kr, 4*kr );
        pk.nafoukniNa( xo1, kr,   kr );
    }
}

