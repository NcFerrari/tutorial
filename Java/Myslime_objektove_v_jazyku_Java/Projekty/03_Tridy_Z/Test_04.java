/*******************************************************************************
 * Testovaci trida Test_04.
 *
 * @author    jmeno autora
 * @version   0.00.000,  0.0.2003
 */
public class Test_04 extends junit.framework.TestCase
{
    private Platno platno1;
    private Obdelnik obdelnik1;
    private Elipsa elipsa1;
    private Trojuhelnik trojuhel1;
    private Strom_4 strom1;

    private static String text ="";

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori test se zadanym nazvem.
     *
     * @param nazev  Nazev konstruovaneho testu
     */
    public Test_04( String nazev )
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
        platno1 = Platno.getPlatno();
        obdelnik1 = new Obdelnik   (   0,   0, 100, 150 );
        elipsa1   = new Elipsa     ( 150,   0, 150, 100 );
        trojuhel1 = new Trojuhelnik( 150, 150, 150, 150 );
        strom1     = new Strom_4   (   0, 150 );
    }


    /***************************************************************************
     * Uklid po testu - tato metoda se spusti po vykonani kazdeho testu.
     */
    protected void tearDown()
    {
        assertTrue( P.souhlas(text + "\n\nV poradku?") );
        platno1.setRozmer(300, 300);
    }


//== VLASTNI TESTY =============================================================

    public void testZmenaVelikostiPlatna()
    {
        platno1.setRozmer(100, 200);
        obdelnik1.nakresli();
        elipsa1.nakresli();
        trojuhel1.nakresli();
        strom1.nakresli();
        text = "Rozemr platna = 100\u00d7200.";
    }

    public void testProhozeni()
    {
        //Aby bylo prohozeni videt co nejlepe, vypiseme nejprve upozorneni
        P.zprava("Bude se prohazovat");

        //Nejprve je treba nektere obrazce presunout jinam,
        //aby se pri presunech vzajemne neumazavaly.
        //To, ze se budou v odkladne pozici prekryvat, nevadi.
        obdelnik1.setPozice(300,0);
        elipsa1.setPozice(300,0);
        trojuhel1.setPozice(300, 0);

        //Strom_4 je posledni - proto jej jiz nikdo nepremaze
        //Nyni presuneme obrazce do cilovych pozic
        strom1.setPozice(150,0);
        obdelnik1.setPozice(150, 150);
        elipsa1.setPozice(0, 150);
        trojuhel1.setPozice(0, 0);
        text = "Obrazce prohozeny.";
    }

	public void testPlatno()
	{
		platno1.setBarvaPozadi(Barva.MODRA);
        text = "Platno ma modre pozadi.";
	}

	public void testZastaveni()
	{
	    P.zprava("Start");
	    P.zprava("Cekam");
        text = "Startovaci a cekaci zprava odeslany.";
	}

}

