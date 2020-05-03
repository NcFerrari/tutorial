package rup.cesky.tvary;


//==============================================================================
import java.awt.Color;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rup.cesky.spolecne.ToASCII;

/*******************************************************************************
 *  Trida Barva definuje skupinu zakladnich barev pro pouziti
 *  pri kresleni tvaru pred zavedenim balicku.
 *
 * @author     Rudolf Pecinovsky
 * @version    2.02.000, 18.2.2005
 */
public class Barva
{
    /** Pocet pojmenovanych barev se pri konstrukci nasledujicich instanci
     *  nacita, a proto musi byt deklarovan pred nimi. */
    private static int pojmenovanych = 0;

//== KONSTANTNI ATRIBUTY TRIDY =================================================

    private static final Map<String,Barva> NAZVY =
                                             new LinkedHashMap<String,Barva>();
    private static final List<Barva> BARVY = new ArrayList<Barva>( 32 );

    public static final Barva
        CERNA   = new Barva( 0x00, 0x00, 0x00, 0xFF, "cerna"   ),
        MODRA   = new Barva( 0x00, 0x00, 0xFF, 0xFF, "modra"   ),
        CERVENA = new Barva( 0xFF, 0x00, 0x00, 0xFF, "cervena" ),
        FIALOVA = new Barva( 0xFF, 0x00, 0xFF, 0xFF, "fialova" ),
        ZELENA  = new Barva( 0x00, 0xFF, 0x00, 0xFF, "zelena"  ),
        AZUROVA = new Barva( 0x00, 0xFF, 0xFF, 0xFF, "azurova" ),
        ZLUTA   = new Barva( 0xFF, 0xFF, 0x00, 0xFF, "zluta"   ),
        BILA    = new Barva( 0xFF, 0xFF, 0xFF, 0xFF, "bila"    ),
        KREMOVA = new Barva( 0xFF, 0xFF, 0xCC, 0xFF, "kremova" ),
        SEDA    = new Barva( 0x99, 0x99, 0x99, 0xFF, "seda"    ),
        OCELOVA = new Barva( 0x00, 0x99, 0xCC, 0xFF, "ocelova" ),
        RUZOVA  = new Barva( 0xFF, 0x99, 0x99, 0xFF, "ruzova"  ),
        HNEDA   = new Barva( 0x99, 0x33, 0x00, 0xFF, "hneda"   ),
        KHAKI   = new Barva( 0x99, 0x99, 0x00, 0xFF, "khaki"   ),
        CIHLOVA = new Barva( 0xFF, 0x66, 0x33, 0xFF, "cihlova" ),
        ZLATA   = new Barva( 0xFF, 0x99, 0x00, 0xFF, "zlata"   ),
        STRIBRNA= new Barva( 0xCC, 0xCC, 0xCC, 0xFF, "stribrna");


//== PROMENNE ATRIBUTY TRIDY ===================================================

//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    private final String nazev;     //Nazev barvy zadavany konstruktoru
    private final Color  color;     //Barva ze standardni knihovny
    private final int    index = pojmenovanych++;


//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

    /***************************************************************************
     * Vrati vektor retezcu s nazvy definovanych barev.
     *
     * @return  Vektror retezcu s nazvy znamych barev
     */
    public static String[] getZnameNazvy()
    {
        String[] s = new String[ pojmenovanych ];
        for( int i=-1;   ++i < pojmenovanych;   s[i] = BARVY.get(i).nazev );
        return s;
    }


    /***************************************************************************
     * Vrati vektor definovanych barev.
     *
     * @return  Vektror retezcu s nazvy znamych barev
     */
    public static Barva[] getZnameBarvy()
    {
        //return (Barva[])BARVY.toArray( new Barva[0] );
        return BARVY.toArray( new Barva[0] );
    }



//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori instanci barvy se zadanou velikosti barevnych slozek
     * a hladinou pruhlednosti nastavovanou v kanale alfa
     * a se zadanym ceskym nazvem a nazvem bez diakritiky.
     *
     * @param red       Velikost cervene slozky
     * @param green     Velikost zelene slozky
     * @param blue      Velikost modre slozky
     * @param alpha     Hladina pruhlednosti: 0=pruhledna, 255=nepruhledna
     * @param nazev     Nazev vytvorene barvy
     * @param nazevBHC  Nazev bez hacku a carek
     */
    private Barva( int red, int green, int blue, int alpha, String nazev )
    {
        if( (nazev == "")  ||  (nazev == null)  )
            throw new IllegalArgumentException(
                "Prvni z nazvu musi byt zadan" );
        nazev = nazev   .toLowerCase();
        if( NAZVY.containsKey( nazev ) )
        {
            throw new IllegalArgumentException(
                "\nBarvu nelze vytvorit - barva " + nazev + " jiz existuje" );
        }
        color = new Color( red, green, blue, alpha );
        BARVY.add( index, this );
        this.nazev = nazev;
        String bhc = ToASCII.string( nazev );
        if( ! nazev.equals(bhc) )
            NAZVY.put( bhc, this );
    }


    /***************************************************************************
     * Prevede nazev barvy na prislusny objekt typu Barva.
     *
     * @param nazevBarvy  Nazev pozadovane barvy -- seznam znamych nazvu
     *                    je mozno ziskat zavolanim metody getZnameNazvy()
     *
     * @return Instance tridy Barva reprezentujici zadanou barvu
     *
     * @throws IllegalArgumentException neni-li barva (nazev) mezi znamymi
     */
    public static Barva getBarva( String nazevBarvy )
    {
        Barva barva = NAZVY.get( nazevBarvy.toLowerCase() );
        if( barva != null )
            return barva;
        else
            throw new IllegalArgumentException(
                "Takto pojmenovanou barvu neznam." );
    }


    /***************************************************************************
     * Vytvori instanci barvy se zadanou velikosti barevnych slozeka.
     *
     * @param red   Velikost cervene slozky
     * @param green Velikost zelene slozky
     * @param blue  Velikost modre slozky
     */
    public static Barva getBarva( int red, int green, int blue )
    {

        return getBarva( red, green, blue, 0xFF );
    }


    /***************************************************************************
     * Vytvori instanci nepojmenovane barvy se zadanou velikosti barevnych
     * slozeka hladinou pruhlednosti nastavovanou v kanale alfa.
     *
     * @param red    Velikost cervene slozky
     * @param green  Velikost zelene slozky
     * @param blue   Velikost modre slozky
     * @param alpha  Hladina pruhlednosti: 0=pruhledna, 255=nepruhledna
     */
    public static Barva getBarva( int red, int green, int blue, int alpha )
    {
        String nazev = "Barva(r=" + red + ",g=" + green +
                       ",b=" + blue + ",a=" + alpha + ")" ;
        return getBarva( red, green, blue, alpha, nazev, "" );
    }


    /***************************************************************************
     * Existuje-li zadana barva mezi znamymi, vrati ji; v opacnem pripade
     * vytvori novou barvu se zadanymi parametry a vrati odkaz na ni.
     *
     * @param red       Velikost cervene slozky
     * @param green     Velikost zelene slozky
     * @param blue      Velikost modre slozky
     * @param nazev     Nazev vytvorene barvy
     *
     * @return Instance tridy Barva reprezentujici zadanou barvu.
     *
     * @throws IllegalArgumentException ma-li nektere ze znamych barev nektery
     *         ze zadanych nazvu a pritom ma jine nastaveni barevnych slozek
     *         nebo ma jiny druhy nazev.
     */
    public static Barva getBarva( int red, int green, int blue, String nazev )
    {
        return getBarva( red, green, blue, 0xFF, nazev );
    }


    /***************************************************************************
     * Existuje-li zadana barva mezi znamymi, vrati ji; v opacnem pripade
     * vytvori novou barvu se zadanymi parametry a vrati odkaz na ni.
     *
     * @param red       Velikost cervene slozky
     * @param green     Velikost zelene slozky
     * @param blue      Velikost modre slozky
     * @param alpha     Hladina pruhlednosti: 0=pruhledna, 255=nepruhledna
     * @param nazev     Nazev vytvorene barvy
     *
     * @return Instance tridy Barva reprezentujici zadanou barvu.
     *
     * @throws IllegalArgumentException ma-li nektere ze znamych barev nektery
     *         ze zadanych nazvu a pritom ma jine nastaveni barevnych slozek
     *         nebo ma jiny druhy nazev.
     */
    public static Barva getBarva( int red, int green, int blue, int alpha,
                                  String nazev )
    {
        if( (nazev == null)  ||
            ((nazev = nazev.trim().toLowerCase()) == "") )
        {
            throw new IllegalArgumentException(
                "Barva musi mit zadan neprazdny nazev" );
        }
        Barva barva = NAZVY.get( nazev );
        if( barva != null )
        {
            Color c = barva.color;
            if( (red    == c.getRed()  )  &&
                (green  == c.getGreen())  &&
                (blue   == c.getBlue() )  &&
                (alpha  == c.getAlpha())  )
            {
                return barva;
            }
            else
            {
                String s = (barva == null)  ?  null  :  barva.nazev;
                throw new IllegalArgumentException(
                    "\nZadane parametry barvy " + barva +
                    "koliduji s parametry existujici barvy "+
                    "[existujici \u00d7 zadana]:" +
                    "\ncervena slozka: " + c.getRed()    + " \u00d7 " + red   +
                    "\nzelena  slozka: " + c.getGreen()  + " \u00d7 " + green +
                    "\nmodra   slozka: " + c.getBlue()   + " \u00d7 " + blue  +
                    "\npruhlednost:    " + c.getAlpha()  + " \u00d7 " + alpha );
            }
        }
        else
        //Zadny z nazvu nezna - vytvori novou barvu
            return new Barva( red, green, blue, alpha, nazev );
    }


    /***************************************************************************
     * Existuje-li zadana barva mezi znamymi, vrati ji; v opacnem pripade
     * vytvori novou barvu se zadanymi parametry a vrati odkaz na ni.
     *
     * @deprecated Pouzivani teto metody se nedoporucuje,
     *             protoze nova verze druhy nazev ignoruje,
     *             jelikoz si jej v pripade potreby vyrobi sama.
     *             Pouzivejte proto verzi s jednim nazvem.
     *
     * @param red       Velikost cervene slozky
     * @param green     Velikost zelene slozky
     * @param blue      Velikost modre slozky
     * @param nazev     Nazev vytvorene barvy
     * @param nazevBHC  Nazev bez hacku a carek
     *
     * @return Instance tridy Barva reprezentujici zadanou barvu.
     *
     * @throws IllegalArgumentException ma-li nektere ze znamych barev nektery
     *         ze zadanych nazvu a pritom ma jine nastaveni barevnych slozek
     *         nebo ma jiny druhy nazev.
     */
    @Deprecated
    public static Barva getBarva( int red, int green, int blue,
                                  String nazev, String nazevBHC )
    {
        return getBarva( red, green, blue, 0xFF, nazev );
    }


    /***************************************************************************
     * Existuje-li zadana barva mezi znamymi, vrati ji; v opacnem pripade
     * vytvori novou barvu se zadanymi parametry a vrati odkaz na ni.
     *
     * @deprecated Pouzivani teto metody se nedoporucuje,
     *             protoze nova verze druhy nazev ignoruje,
     *             jelikoz si jej v pripade potreby vyrobi sama.
     *             Pouzivejte proto verzi s jednim nazvem.
     *
     * @param red       Velikost cervene slozky
     * @param green     Velikost zelene slozky
     * @param blue      Velikost modre slozky
     * @param alpha     Hladina pruhlednosti: 0=pruhledna, 255=nepruhledna
     * @param nazev     Nazev vytvorene barvy
     * @param nazevBHC  Nazev bez hacku a carek
     *
     * @return Instance tridy Barva reprezentujici zadanou barvu.
     *
     * @throws IllegalArgumentException ma-li nektere ze znamych barev nektery
     *         ze zadanych nazvu a pritom ma jine nastaveni barevnych slozek
     *         nebo ma jiny druhy nazev.
     */
    @Deprecated
    public static Barva getBarva( int red, int green, int blue, int alpha,
                                  String nazev, String nazevBHC )
    {
        return new Barva( red, green, blue, alpha, nazev );
    }



//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================

    /***************************************************************************
     * Vrati nazev barvy.
     *
     * @return Retezec definujici zadanou barvu.
     */
    public String getNazev()
    {
        return nazev;
    }


    /***************************************************************************
     * Prevede nami pouzivanou barvu na typ pouzivany kreslitkem.
     * Metoda je pouzivana ve tride AktivniPlatno.
     *
     * @return Instance tridy Color reprezentujici zadanou barvu
     */
    public Color getColor()
    {
        return color;
    }


    /***************************************************************************
     * Prevede nami pouzivanou barvu na typ pouzivany kreslitkem.
     * Metoda je pouzivana ve tride AktivniPlatno.
     *
     * @return Instance tridy Color reprezentujici zadanou barvu
     */
    public String getCharakteristikaDec()
    {
        return rup.cesky.spolecne.IO.sprintf( "%s(R=%d,G=%d,B=%d,A=%d)", nazev,
            color.getRed(), color.getGreen(), color.getBlue(),
            color.getAlpha());
    }


    /***************************************************************************
     * Prevede nami pouzivanou barvu na typ pouzivany kreslitkem.
     * Metoda je pouzivana ve tride AktivniPlatno.
     *
     * @return Instance tridy Color reprezentujici zadanou barvu
     */
    public String getCharakteristikaHex()
    {
        return rup.cesky.spolecne.IO.sprintf( "%s(R=%X,G=%X,B=%X,A=%X)", nazev,
            color.getRed(), color.getGreen(), color.getBlue(),
            color.getAlpha());
    }



//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================

    /***************************************************************************
     * Vrati nazev barvy.
     *
     * @return  Nazev barvy
     */
    public String toString()
    {
        return nazev;
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
//+ main
    public static void main( String[] args )
    {
        Barva divna = new Barva( 1, 2, 3, 255, "DIVNA" );
        Barva prusvitna = getBarva( 255, 0, 0, 128, "prusvitna" );
        System.out.println("Prusvitna: " + prusvitna );
        System.out.println( "Nazvy: " + Arrays.asList(getZnameNazvy()) );
        System.out.println( "Barvy: " + Arrays.asList(getZnameBarvy()) );
        for( Barva b : getZnameBarvy() )
        {
            System.out.println();
            System.out.println( b.getCharakteristikaDec() );
            System.out.println( b.getCharakteristikaHex() );
        }
        try
        {
            getBarva( 1, 2, 3, 5, "divna", "prusvitna" );
        }catch( IllegalArgumentException iae ) {
            System.out.println("Vijimka: " + iae );
            System.out.println("Vyjimka vyhozena spravne");
        }
    }
//- main
}
