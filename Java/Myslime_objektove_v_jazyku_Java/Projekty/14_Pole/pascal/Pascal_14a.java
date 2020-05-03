package pascal;

/*******************************************************************************
 * Trida Pascal_14a slouzi k ...
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Pascal_14a
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
    
    int[][] trojuhelnik;
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * 
     */
    public Pascal_14a(int n)
    {
        if( n <= 0 )
            throw new IllegalArgumentException(
                "Trojuhelnik musi mit kladny pocet radku - zadano " + n );

        trojuhelnik = new int[n][];
        trojuhelnik[0] = new int[] { 1 };
        if( n == 1 )   return;      //====================>

        trojuhelnik[1] = new int[] { 1, 1 };
        for( int r = 2;   r < n;   r++ )
        {
            int[] radek = new int[r+1];
            radek[0] = radek[r] = 1;
            for( int s=1;   s < r;   s++ )
                radek[s] = trojuhelnik[r-1][s-1] + trojuhelnik[r-1][s];
            trojuhelnik[r] = radek;
        }
    }

    

//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
    
    public String toString()
    {
        String t = "";
        for( int[] radek : trojuhelnik )
        {
            for( int hodnota : radek )
                t += " " + hodnota;
            t += "\n";
        }
        return t;
    }
    
    
    
//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================

    public static void test( int n )
    {
        System.out.println( new Pascal_14a( n ) );
    }
    
    public static void test6()
    {
        test( 6 );
    }
}

