package priklady;

import rup.cesky.spolecne.P;
import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.Oblast;
import rup.cesky.tvary.Presouvac;


/*******************************************************************************
 * Testovaci trida Strom_9aTest.
 * 
 * Oproti tride Strom_7Test nedoslo k zadnym zmenam, 
 * pouze se testuje jina trida.
 *
 * @author     Rudolf Pecinovsky
 * @version    2.01, duben 2004
 */
public class Strom_9aTest extends junit.framework.TestCase
{
    private AktivniPlatno ap;
    private Strom_9a strom1;
    private Strom_9a strom2;
    private Strom_9a strom3;
    private Strom_9a strom4;


//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori test se zadanym nazvem.
     *
     * @param nazev  Nazev konstruovaneho testu
     */
    public Strom_9aTest(String nazev)
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
        ap = AktivniPlatno.getPlatno();
        ap.setKrokRozmer( 50, 6, 6 );
        ap.setMrizka(true);
        ap.odstranVse();
        strom1 = new Strom_9a();                        
        strom2 = new Strom_9a( 25, 150);                
        strom3 = new Strom_9a(100, 100, 100,  90);      
        strom4 = new Strom_9a(200,   0, 100, 300, 5, 5);
        strom1.nakresli();
        strom2.nakresli();
        strom3.nakresli();
        strom4.nakresli();
    }


    /***************************************************************************
     * Uklid po testu - tato metoda se spusti po vykonani kazdeho testu.
     * Bezparametricky konstruktor pro testovaci tridu StromTest
     */
    protected void tearDown()
    {
    }


//== VLASTNI TESTY =============================================================

    public void testNakresliSmaz()
    {
        strom1.smaz();
        strom2.smaz();
        strom3.smaz();
        strom4.smaz();
        assertEquals(true, P.souhlas("Stromy smazany?"));
        strom1.nakresli();
        strom2.nakresli();
        strom3.nakresli();
        strom4.nakresli();
        assertEquals(true, P.souhlas(
            "Strom 1: x=0,   y=  0, s=100, v=150, sSt/sKm=10, vSt/vKo=3\n" +
            "Strom 2: x=0,   y=150, s=100, v=150, sSt/sKm= 5, vSt/vKo=4\n" +
            "Strom 3: x=100, y=100, s=200, v=200, sSt/sKm=20, vSt/vKo=2\n" +
            "Strom 4: x=100, y=0,   s=150, v=100, sSt/sKm= 3, vSt/vKo=5\n" +
            "\nPozice, rozmery a pomery kmen a korun souhlasi?"));
    }

    public void testPosuny()
    {
        P.zprava("Nasleduje posun vpravo");
        strom1.posunVpravo();
        strom2.posunVpravo();
        strom3.posunVpravo();
        strom4.posunVpravo();
        assertEquals(true, 
            P.souhlas("Posun vpravo vporadku?\n\nNasleduje posun vlevo"));
        strom1.posunVlevo();
        strom2.posunVlevo();
        strom3.posunVlevo();
        strom4.posunVlevo();
        assertEquals(true, 
            P.souhlas("Posun vlevo vporadku?\n\nNasleduje posun vzhuru"));
        strom1.posunVzhuru();
        strom2.posunVzhuru();
        strom3.posunVzhuru();
        strom4.posunVzhuru();
        assertEquals(true, 
            P.souhlas("Posun vzhuru vporadku?\n\nNasleduje posun dolu"));
        strom1.posunDolu();
        strom2.posunDolu();
        strom3.posunDolu();
        strom4.posunDolu();
        assertEquals(true, 
            P.souhlas("Posun dolu vporadku?"));
    }
    
    public void testKrok()
    {
        P.zprava("Nasleduje zmena kroku na 10");
        ap.setKrokRozmer(10, 30, 30);
        testPosuny();
    }
        
    public void testZaramuj()
    {
        strom1.zaramuj();
        assertTrue( P.souhlas("Implicitni strom zaramovan?") );
        strom1.smaz();
        strom3.zaramuj();
        assertTrue( P.souhlas("Treti strom zaramovan?") );
        strom3.smaz();
        strom4.zaramuj();
        assertTrue( P.souhlas("Ctvrty strom zaramovan?") );
    }

    public void testPocitaniInstanci()
    {
        assertTrue( P.souhlas( "Test pocitani instanci a prevodu na retezec\n" +
            strom1 + "\n" + strom2 + "\n" + strom3 + "\n" + strom4 + "\n" +
            "\n\nSouhlasi?"));
    }

    public void testObrazek()
    {
        Strom_9a.obrazek( new Oblast (100, 100, 100, 100), 10 );
        assertTrue( P.souhlas("V poradku na stredu zaramovany strom?"));
    }

    public void testAlej()
    {
        ap.odstranVse();
        Strom_9a.alej();
        assertTrue( P.souhlas("Alej nakreslena spravne?"));
    }

    public void testStatickeZaramuj()
    {
        ap.odstranVse();
        Strom_9a.zaramuj( 200, 300 );
        assertTrue( P.souhlas("Strom zaramovan v okne 200\u00d7300?"));
    }

    public void testPresouvani()
    {
            Presouvac pres1 = new Presouvac(3);
            pres1.presunO(strom3, -100, -100);

            Presouvac pres5 = new Presouvac(5);
            pres5.presunO(strom1, 200, 0);
            pres5.presunNa(strom4, 150, 200);
    }

    public void testSetRozmer()
    {
        ap.setKrokRozmer(10, 30, 30);
        assertEquals(true, P.souhlas(
            "Strom 1: x=0,   y=  0, s=100, v=150, sSt/sKm=10, vSt/vKo=3\n" +
            "Strom 2: x=25,  y=150, s=100, v=150, sSt/sKm=10, vSt/vKo=3\n" +
            "Strom 3: x=100, y=100, s=100, v= 90, sSt/sKm=10, vSt/vKo=3\n" +
            "Strom 4: x=200, y=  0, s=100, v=300, sSt/sKm= 5, vSt/vKo=5\n" +
            "\nPozice, rozmery a pomery kmenu a korun souhlasi?"));
        strom1.setRozmer( 11, 19 );
        strom2.setRozmer( 23, 29 );
        strom3.setRozmer( 27, 37 );
        strom4.setRozmer( 13, 17 );
        assertTrue( P.souhlas(
            "Strom 1: x=0,   y=  0, s=11, v=19, sSt/sKm=10, vSt/vKo=3\n" +
            "Strom 2: x=25,  y=150, s=23, v=29, sSt/sKm=10, vSt/vKo=3\n" +
            "Strom 3: x=100, y=100, s=27, v=37, sSt/sKm=10, vSt/vKo=3\n" +
            "Strom 4: x=200, y=  0, s=13, v=17, sSt/sKm= 5, vSt/vKo=5\n" +
            "\nPozice, rozmery a pomery kmenu a korun souhlasi?"));
        strom1.setRozmer( 100, 150 );
        strom2.setRozmer( 100, 150 );
        strom3.setRozmer( 100,  90 );
        strom4.setRozmer( 100, 300 );
        assertTrue( P.souhlas(
            "Strom 1: x=0,   y=  0, s=100, v=150, sSt/sKm=10, vSt/vKo=3\n" +
            "Strom 2: x=25,  y=150, s=100, v=150, sSt/sKm=10, vSt/vKo=3\n" +
            "Strom 3: x=100, y=100, s=100, v= 90, sSt/sKm=10, vSt/vKo=3\n" +
            "Strom 4: x=200, y=  0, s=100, v=300, sSt/sKm= 5, vSt/vKo=5\n" +
            "\nPozice, rozmery a pomery kmenu a korun souhlasi?"));
    }

}

