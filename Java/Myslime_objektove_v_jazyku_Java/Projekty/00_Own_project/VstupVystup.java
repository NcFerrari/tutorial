/*******************************************************************************
 * Trida VstupVystup slouzi k demonstraci nekterych obratu spojenych 
 * s jednoduchymi okenimi vstupy a vystupy vyuzivajicimi metody tridy P.
 *
 * @author     Rudolf Pecinovsky
 * @version    1.00, kveten 2004
 */
public class VstupVystup
{
    
    /***************************************************************************
     * Metoda demonstruje moznosti vstupu textovych dat prostrednictvim
     * jednoducheho dialogoveho okna.
     */
    public static String jmeno()
    {
        String krestni = P.zadej( "Zadej sve krestni jmeno:", "Pepa" );
        String prijmeni = P.zadej( "Zadej sve prijmeni:", "" );
        String jmeno = krestni + " " + prijmeni;
        P.zprava( "Jmenujes se:\n\n" + jmeno );
        return jmeno;
    }

    
    
    /***************************************************************************
     * Metoda demonstruje moznosti vstupu celociselnych dat prostrednictvim
     * jednoducheho dialogoveho okna; slouzi jako kalkulacka, ktera se zepta
     * na citatele a jmenovatele a vrati hodnotcu celociselneho podilu.
     * 
     * @return Cela cast podilu.               
     */
    public static int celociselneDeleni()
    {
        int delenec = P.zadej( "Zadej delence (cele cislo):", 0 );
        int delitel = P.zadej( "Zadej delitele (cele cislo):", 1 );
        int podil   = delenec / delitel;
        int zbytek  = delenec % delitel;
        P.zprava( delenec + " : " + delitel + " = " + podil + 
                  ", zbyde " + zbytek );
        return podil;
    }

    
    
    /***************************************************************************
     * Metoda demonstruje moznosti vstupu realnych cisel prostrednictvim
     * jednoducheho dialogoveho okna; slouzi jako kalkulacka, ktera se zepta
     * na citatele a jmenovatele a vrati hodnotcu podilu.
     * 
     * @return Hodnota podilu.               
     */
    public static double realneDeleni()
    {
        double delenec = P.zadej( "Zadej delence:", 0. );
        double delitel = P.zadej( "Zadej delitele:", 1d );
        double podil   = delenec / delitel;
        double zbytek  = delenec % delitel;
        P.zprava( delenec + " : " + delitel + " = " + podil + 
                  "\n\"zbytek\" = " + zbytek );
        return podil;
    }

    
    /***************************************************************************
     * Implicitni konstruktor tridy je definovan jako soukromy, 
     * a jiny definovan neni. Oblibeny obrat, jak zaridit, aby trida nikomu
     * nedovolila vytvaret jeji instance.
     */
    private VstupVystup()
    {
    }
    
    
}

