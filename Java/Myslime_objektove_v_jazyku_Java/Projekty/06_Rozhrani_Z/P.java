import javax.swing.JOptionPane;


/*******************************************************************************
 * TPomocna trida slouzici jako schranka na pomocne staticke metody
 * s ruznymi uzitecnymi funkcemi.
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  12. unor 2004, 14:52
 */
public class P
{
//== SOUKROME KONSTANTY ========================================================
//== VEREJNE KONSTANTY =========================================================
//== RETEZCOVE LITERALY ========================================================
//== ATRIBUTY TRIDY ============================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

    /***************************************************************************
     * Pocka zadany pocet milisekund.
     * Na preruseni nijak zvlast nereaguje - proste skonci driv.
     *
     * @param milisekund   Pocet milisekund, po nez se ma cekat.
     */
    public static void cekej( int milisekund )
    {
        try {
            Thread.sleep( milisekund);
        }catch( InterruptedException e) {
            throw new RuntimeException( "Cekani bylo preruseno", e );
        }
    }


    /***************************************************************************
     * Spocte delku usecky se zadanymi krajnimi body.
     *
     * @param x1  Vodorovna souradnice pocatku usecky
     * @param y1  Svisla souradnice pocatku usecky
     * @param x2  Vodorovna souradnice konce usecky
     * @param y2  Svisla souradnice konce usecky
     *
     * @return   Delka usecky
     */
    public static double delka( double x1, double y1,
                                double x2, double y2 )
    {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return P.prepona( dx, dy );
    }


    /***************************************************************************
     * Vrati retezec s nazvem metody, ktera tuto metodu zavolala.
     *
     * @param hloubka Pta-li se metoda na svuj nazev nebo na nazev nektere
     *                ji volajicich metod. <br>
     *                0 - vrati nazev metody, ktera zavolal tuto metodu<br>
     *                1 - vrati nazev metody, jez zavolal metodu,
     *                    ktera zavolal tuto metodu<br>
     *                atd.
     * @param rodice  0 - vrati pouze nazev metody<br>
     *                1 - vrati nazev metody s nazvem tridy<br>
     *                2 - vrati nazev metody s nazvem tridy a balicku.
     * @return Pozadovany nazev
     */
    public static String kdoVola( int hloubka, int rodice )
    {
    	Throwable t = new Throwable();
        StackTraceElement[] ste = t.getStackTrace();
        if( ste.length < (hloubka+2) )
            return "== NIKDO ==";
        StackTraceElement metoda = ste[hloubka+1];
        String nazev = metoda.getMethodName();
        if( rodice > 0 )
        {
            String trida = metoda.getClassName();
            if( rodice < 2 )
                trida = pouzeNazev( trida );
            nazev = trida + "." + nazev;
        }
        return nazev;
    }


    /***************************************************************************
     * Vrati retezec s nazvem metody, ktera tuto metodu zavolala.
     *
     * @param rodice  0 - vrati pouze nazev metody<br>
     *                1 - vrati nazev metody s nazvem tridy<br>
     *                2 - vrati nazev metody s nazvem tridy a balicku.
     * @return Pozadovany nazev
     */
    public static String kdoVola( int rodice )
    {
        return kdoVola( 1, rodice );
    }


    /***************************************************************************
     * Vrati retezec s pouhym nazvem metody, ktera tuto metodu zavolala.
     *
     * @return
     */
    public static String kdoVola()
    {
        return kdoVola( 1, 0 );
    }


    /***************************************************************************
     * Vrati cisty nazev tridy bez nazvu balicku.
     *
     * @param c    Objekt Class tridy, jejiz nazev zjistujeme
     *
     * @return     Cisty nazev tridy
     */
    public static String nazevTridy( Class c )
    {
    	return P.pouzeNazev( c.getName() );
    }


    /***************************************************************************
     * Vrati cisty nazev vlastni tridy zadane instance bez nazvu balicku.
     *
     * @param o    Odkaz na instanci, jejiz nazev tridy nas zajima
     *
     * @return     Cisty nazev tridy
     */
    public static String nazevTridy( Object o )
    {
    	return P.pouzeNazev( o.getClass().getName() );
    }


    /***************************************************************************
     * Vyvola vyjimku oznamujici, ze metoda, z niz byla tato metoda volana,
     * neni podporovana.
     */
    public static void neumim()
    {
    	UnsupportedOperationException uoe = new UnsupportedOperationException();
        StackTraceElement[] ste = uoe.getStackTrace();
        if( ste.length < 2 )
            throw new IllegalStateException( "Prime volani metody \"neumim\"" );
        StackTraceElement metoda = ste[1];
        String nazev = metoda.getMethodName();
        String msg = "Metoda " + nazev + " neni implementovana!";
        StackTraceElement[] st2 = new StackTraceElement[ste.length - 2];
        System.arraycopy(ste, 2, st2, 0,  st2.length );
        uoe = new UnsupportedOperationException( msg );
        uoe.setStackTrace( st2 );
        throw uoe;
    }


    /***************************************************************************
     *  Prevede plny nazev tridy na jeji nazev bez balicku.
     *
     * @param  plny     Plny nazev tridy vcetne nazvu balicku
     * @return          Cisty nazev tridy
     */
    public static String pouzeNazev( String plny )
    {
        return plny.substring( 1+plny.lastIndexOf('.') );
    }


    /***************************************************************************
     * Pocka zadany pocet milisekund.
     * Na preruseni nijak zvlast nereaguje - proste skonci driv.
     *
     * @param milisekund   Pocet milisekund, po nez se ma cekat.
     */
    public static void pockejNa( Thread vlakno )
    {
        if( vlakno == null )
            return;
        try {
            vlakno.join();
        }catch( InterruptedException e) {
            throw new RuntimeException(
                "Cekani na vlakno bylo preruseno: " + vlakno, e );
        }
    }


    /***************************************************************************
     * Spocte delku prepony pravouhleho trojuelniku se zadanymi odvesnami.
     *
     * @param x  Delka prvni odvesny
     * @param y  Delka druhe odvesny
     *
     * @return   Delka prepony
     */
    public static double prepona( double x, double y )
    {
        return Math.sqrt(x*x + y*y);
    }


    /***************************************************************************
     * Zobrazi dialogove okno se zpravou a umozni uzivateli odpovedet
     * ANO, NE nebo STORNO. Vrati informaci o tom, jak uzivatel odpovedel.
     * Odpovede-li STORNO nebo zavre-li dialog, ukonci program.
     *
     * @param dotaz   Zobrazovany text otazky.
     *
     * @return true odpovedel-li uzivatel ANO, false odpovedel-li NE
     */
    public static boolean souhlas( Object dotaz )
    {
        return souhlas( "Dotaz", dotaz);
    }


    /***************************************************************************
     * Zobrazi dialogove okno se zpravou a umozni uzivateli odpovedet
     * ANO, NE nebo STORNO. Vrati informaci o tom, jak uzivatel odpovedel.
     * Odpovede-li STORNO nebo zavre-li dialog, ukonci program.
     *
     * @param dotaz   Zobrazovany text otazky.
     * @param nadpis   Nadpis v titulkove liste dialogoveho okna.
     *
     * @return true   Odpovedel-li uzivatel ANO, false odpovedel-li NE
     */
    public static boolean souhlas( String nadpis, Object dotaz )
    {
        int odpoved = JOptionPane.showOptionDialog(
            null,   //Rodicovska komponenta neni - vystredi se na obrazovce
            dotaz,  //Otazka, na kterou ma uzivatel odpovedet
            nadpis,  //Titulek okna
            0,      //Optiona type
            JOptionPane.QUESTION_MESSAGE, //Message type
            null,   //Icon
            new Object[] { "ANO", "NE", "STORNO"},
            "ANO"
             );
        if( (odpoved == JOptionPane.CANCEL_OPTION)  ||
            (odpoved == JOptionPane.CLOSED_OPTION) )
        {
            System.exit(0);
        }
        return (odpoved == JOptionPane.YES_OPTION);
    }


    /***************************************************************************
     * Na standardni vystup vypise vzpravu o vstupu do teto metody
     * nasledovanou na dalsim radku zadanym textem.
     *
     * @param hloubka Hloubka dotazu na volanou metodu
     * @param text  Text, vypsany za radkem s oznamenim vstupu do metody
     *              Je-li text "" nebo null, radek se nevygeneruje.
     */
    public static void vstup( int hloubka, String text )
    {
        System.out.println("\n>>>>> Start: " + kdoVola( hloubka, 3 ));
        if( (text != null)  &&  !text.equals("") )
            System.out.println( "      " + text );
    }


    /***************************************************************************
     * Na standardni vystup vypise vzpravu o vstupu do teto metody
     * nasledovanou na dalsim radku zadanym textem.
     *
     * @param text  Text, vypsany za radkem s oznamenim vstupu do metody
     *              Je-li text "" nebo null, radek se nevygeneruje.
     */
    public static void vstup( String text )
    {
        vstup( 2, text );
    }


    /***************************************************************************
     * Na standardni vystup vypise vzpravu o vstupu do teto metody.
     */
    public static void vstup()
    {
        vstup( 2, null );
    }


    /***************************************************************************
     * Na standardni vystup vypise zadany text nasledovny vzpravou
     * o ukonceni volajici metody.
     *
     * @param hloubka Hloubka dotazu na volanou metodu
     * @param text  Text, vypsany pred radkem s oznamenim vystupu z metody
     *              Je-li text "" nebo null, radek se nevygeneruje.
     */
    public static void vystup( int hloubka, String text )
    {
        if( (text != null)  &&  !text.equals("") )
            System.out.println( "      " + text );
        System.out.println("<<<<< STOP: " + kdoVola( hloubka, 3 ) + "\n" );
    }


    /***************************************************************************
     * Na standardni vystup vypise zadany text nasledovny vzpravou
     * o ukonceni volajici metody.
     *
     * @param text  Text, vypsany pred radkem s oznamenim vystupu z metody
     *              Je-li text "" nebo null, radek se nevygeneruje.
     */
    public static void vystup( String text )
    {
        vystup( 2, text );
    }


    /***************************************************************************
     * Na standardni vystup vypise vzpravu o ukonceni volajici metody.
     */
    public static void vystup()
    {
        vystup( 2, null );
    }


    /***************************************************************************
     * Zobrazi dialogove okno s vyzvou k zadani realne hodoty;
     * pri zavreni okna nebo stisku tlacitka Cancel ukonci aplikaci.
     *
     * @param vyzva        Text, ktery se uzivateli zobrazi.
     * @param doubleImpl   Implicitni hodnota.
     *
     * @return Uzivatelem zadana hodnota, resp. potvrzena implicitni hodnota.
     */
    public static double zadej( Object vyzva, double doubleImpl )
    {
        return Double.parseDouble( zadej( vyzva, ""+doubleImpl ).trim() );
    }


    /***************************************************************************
     * Zobrazi dialogove okno s vyzvou k zadani celociselne hodoty;
     * pri zavreni okna nebo stisku tlacitka Cancel ukonci aplikaci.
     *
     * @param vyzva     Text, ktery se uzivateli zobrazi.
     * @param intImpl   Implicitni hodnota.
     *
     * @return Uzivatelem zadana hodnota, resp. potvrzena implicitni hodnota.
     */
    public static int zadej( Object vyzva, int intImpl )
    {
        return Integer.parseInt( zadej( vyzva, ""+intImpl ).trim() );
    }


    /***************************************************************************
     * Zobrazi dialogove okno s vyzvou k zadani textove hodoty;
     * pri zavreni okna nebo stisku tlacitka Cancel ukonci aplikaci.
     *
     * @param vyzva        Text, ktery se uzivateli zobrazi.
     * @param stringImpl   Implicitni hodnota.
     *
     * @return Uzivatelem zadana hodnota, resp. potvrzena implicitni hodnota.
     */
    public static String zadej( Object vyzva, String stringImpl )
    {
        String odpoved = JOptionPane.showInputDialog(null, vyzva, stringImpl );
        if( odpoved == null )
            System.exit(0);
        return odpoved;
    }


    /***************************************************************************
     * Zobrazi dialogove okno se zpravou a pocka, az je uzivatel odklepne;
     * pri zavreni okna ukonci aplikaci.
     *
     * @param text   Zobrazovany text.
     */
    public static void zprava( Object text )
    {
        int odpoved = JOptionPane.showConfirmDialog(
            null,     //Rodicovska komponenta neni - vystredi se na obrazovce
            text,     //Zprava, kteoru uzivateli sdelujeme
            "Zprava", //Titulek okna
            JOptionPane.DEFAULT_OPTION,      //Optiona type - OK
            JOptionPane.INFORMATION_MESSAGE  //Message type
             );
        if( (odpoved == JOptionPane.CLOSED_OPTION) )
            System.exit(0);
    }



//== ATRIBUTY INSTANCI =========================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Trida P neni urcena k tomu, aby mela nejake instance.
     * Konstruktor je zde pouze kvuli tomu, aby bylo mozno definovat jejiho
     * pototmka, ktery mnozinu metod rozsiri. Vzhledem k nemoznosti vytvaret
     * instance ale ale museji byt vsechny metody definovany jako staticke.
     */
    protected P()
    {
        throw new RuntimeException(
            "Od teto tridy neni povoleno vytvaret instance");
    }


//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

