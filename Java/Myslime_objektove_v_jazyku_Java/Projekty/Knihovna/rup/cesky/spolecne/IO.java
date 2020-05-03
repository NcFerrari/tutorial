package rup.cesky.spolecne;


//==============================================================================
import javax.swing.JOptionPane;

import java.util.Formatter;
import java.util.Locale;


/*******************************************************************************
 * Knihovni trida IO obsahuje sadu jednoduchych metod 
 * pro okenni vstup a vystup.
 *
 * @author    Rudolf Pecinovsky
 * @version   1.00.000,  18.2.2004
 */
public final class IO
{
//== SOUKROME KONSTANTY ========================================================
//== VEREJNE KONSTANTY =========================================================
//== RETEZCOVE LITERALY ========================================================
//== ATRIBUTY TRIDY ============================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

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
     * Vytvori retezec obsahujici formatovany text na zaklade
     * zadanych parametru.
     *
     * @param format  Zadane formatovani.
     * @param param   Hodnoty vystupujici v zadanem formatu.
     *
     * @return  Pozadovany zformatovany retezec
     */
    public static String sprintf(String format, Object ... args) 
    {
        StringBuilder sb = new StringBuilder();
        Formatter fm;
        fm = new Formatter( sb );
        fm.format(Locale.getDefault(), format, args);
        return sb.toString();
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
     * Trida IO je knihovni tridou a proto neni urcena k tomu, 
     * aby mela nejake instance.
     */
    private IO() {}


//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
//+ main

    /***************************************************************************
     * @param args
     */
    public static void main( String[] args ) {
        System.out.println( sprintf("Dec=%1$d, hex=%1$h", 123 ));
    }
//- main
}
