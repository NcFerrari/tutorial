package priklady;

/*******************************************************************************
 * Trida Sbl_Trida slouzi k ...
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Experimenty
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

    /***************************************************************************
     * Meotda demonstruje predani parametru, ktery je polem 
     * a moznost jeho zpracovani.
     * Prestoze vystupni parametr je oficielne typu Object,
     * programy v nem umeji poznat instanci typu String[].
     */
    public static Object objekty( String[] poleRetezcu )
    {
        Object[] poleObecnychObjektu = poleRetezcu;
        
        return   poleObecnychObjektu;
    }
    
    public static rup.cesky.tvary.AHybaci pozna()
    {
        rup.cesky.tvary.Elipsa e = new rup.cesky.tvary.Kruh();
        e.posunVpravo();
        rup.cesky.tvary.AHybaci ah = e;
        ah.posunDolu();
        return ah;
    }
    
    
    public static void demoObjekty()
    {
        String[] texty = { "raz", "dva", "tri" };

        System.out.println("Objekty - primy tisk pole: " + texty );

        System.out.print("Objekty - tisk po prvcich: ");
        for( String string : texty )
            System.out.print( string + " - " );
        System.out.println();

        System.out.println("Objekty - tisk prevodem na seznam: " +
            java.util.Arrays.asList( texty ) );

        Object objekty = objekty( texty );
        Object[] poleObjektu = (Object[]) objekty;
        String[] stringy = (String[])objekty;

        System.out.println("Objekty - tisk jako pole objektu: " +
            java.util.Arrays.asList( poleObjektu ) );
    }
    
    
    public static Object primitiva( int[] poleCelychCisel )
    {
        double[] poleRealnychCisel;

        //poleRealnychCisel = poleCelychCisel;

        int pocetPrvku = poleCelychCisel.length;
        poleRealnychCisel = new double[ pocetPrvku ];

        for( int i=0;   i < pocetPrvku;   i++ )
            poleRealnychCisel[i] = poleCelychCisel[i]; 

        return poleRealnychCisel;
    }

    
    public static void demoPrimitiva()
    {
        Object primitiva = primitiva( new int[] { 1, 2, 3 } );

        System.out.print("Primitiva - tisk po prvcich: ");
        
        double[] realna = (double[])primitiva;
        for( double realne : realna )
            System.out.print( realne + " - " );
        System.out.println();

        System.out.println("Primitiva - tisk prevodem na seznam: " +
            java.util.Arrays.asList( realna ) );

        int[] cela = (int[])primitiva;
    }
    
    
    public static String[][] dovjrozmerne()
    {
        String[][] tabulka = new String[2][3];
        tabulka[0][4] = "nula - jedna";
        return tabulka;
    }
    
    

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Trida Experimenty je knihovni tridou a proto zatajuje svuj konstruktor.
     */
    private Experimenty() {}

    

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

