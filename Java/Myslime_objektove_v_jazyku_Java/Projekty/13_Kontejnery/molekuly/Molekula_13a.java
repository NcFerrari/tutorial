package molekuly;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import rup.cesky.spolecne.P;

import rup.cesky.tvary.Kruh;


/*******************************************************************************
 * Trida Molekula_13a definuje metody, ktere vygeneruji na platno
 * nahodne rozmistene molekuly, ktere pak dalsi verze tridy rozpohybuji.
 * Slouzi predevsim k demonstraci prace s mnozinami.
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Molekula_13a extends Kruh
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Frekvence prekreslovani planta s molekulami. */
    private static final int FREKVENCE = 50;

    /** MAximalni pocet pokusu venovanych na umisteni dalsi moelkuly. */
    private static final int POKUSU = 3;

    /** Spolecny prumer vsech moelkul. */
    private static final int PRUMER = 50;

    /** Maximalni povolena rychlost molekuly,
     * tj. kolik bodu muze molekula urazit za sekundu. */
    private static int maxR = 300 ;

    /** Mnozina vsech dosud vygenerovanych molekul. */
    private static final Set<Molekula_13a> molekuly =
                           new LinkedHashSet<Molekula_13a>();

    /** Spolecny generator nahodnych cisel. */
    private static final Random rnd = new Random();





//== PROMENNE ATRIBUTY TRIDY ===================================================

    /** Pocet dosud vytvorenych instanci. */
    private static int pocet = 0;

    /** Maximalni povolene souradnice molekuly. */
    private static int maxX;
    private static int maxY;

    static { nastavMaxima(); }



//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    /** Poradi vytvoreni dane instance v ramci tridy. */
    private final int poradi = ++pocet;


//== PROMENNE ATRIBUTY INSTANCI ================================================

    /** Slozky aktualni pozice molekuly. */
    private double x, y;

    /** Slozky aktualni rychlosti molekuly. */
    private double rx, ry;



//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

    /***************************************************************************
     * Nastavi maximalni povolene souradnice molekul
     * podle aktualni velikosti aktivniho platna.
     */
    public static void nastavMaxima()
    {
        maxX = AP.getBsirka() - PRUMER;
        maxY = AP.getBVyska() - PRUMER;
    }

//------------------------------------------------------------------------------

    /***************************************************************************
     * Vytvori zadany pocet nahodne umistenych molekul.
     *
     * @param molekul   Pozadovany pocet vytvorenych molekul
     */
    public static void novaSada_1( int molekul )
    {
        molekuly.clear();   //Zapomenu vsechny drive ulozene
        for( int m=1;   m <= molekul;   m++ )
        {
            System.out.println("Generace " + (pocet+1) + ". molekuly:");
            dalsi_1();
        }
    }


    /***************************************************************************
     * Najde nahodne umisteni dalsi molekuly tak, aby se neprekryvala s zadnou
     * z dosud vytvorenych molekul, a necha molekulu na teto pozici vytvorit.
     */
    public static void dalsi_1()
    {
        int x, y;         //Navrhovane souradnice nove molekuly
        int K_PROVERENI = molekuly.size();  //Pocet dosud vytvorenych
        int provereno;
        int pokus = 0;
        do{
            //Generace navrhu nove pozice
            x = rnd.nextInt( maxX );
            y = rnd.nextInt( maxY );
            System.out.print( "  " + ++pokus + ". pokus: x=" + x +
                                                      ", y=" + y );
            //Otestovani pripadnych kolizi
            provereno = 0;
            //Projdeme mnozinu a otestujeme molekulu za molekulou
            for( Molekula_13a m : molekuly )
            {
                if( PRUMER > P.delka( x, y, m.x,  m.y ) )
                {
                    System.out.println(" koliduje s " + m.poradi +
                                       ". molekulou" );
                    break;
                }
                provereno++;    //Dalsi byla proverena
            }
        //Nebyly-li provereny vsechny, je treba zkusit znovu
        }while( provereno < K_PROVERENI );
        System.out.println( " - USPESNY" );

        Molekula_13a m = new Molekula_13a( x, y );
    }

//------------------------------------------------------------------------------

    /***************************************************************************
     * Vytvori sadu nahodne umistenych molekul. Generaci ukonci pote,
     * co se po zadanem poctu pokusu nepodari najit vhodne umisteni
     * pro dalsi molekulu.
     *
     * @param molekul   Maximalne povoleny pocet pokusu pri hledani
     *                  pozice vytvarene molekuly
     */
    public static int novaSada_2( int pokusu )
    {
        int pocet = 0;
        molekuly.clear();
        do{
            System.out.println("Generace " + ++pocet + ". molekuly:");
        }while( dalsi_2( pokusu ) );   //Dokud se dari molekuly generovat
        System.out.println("Vygenerovali jsme " + (pocet-1) + " molekul");
        return pocet - 1;
    }

//------------------------------------------------------------------------------

    /***************************************************************************
     * Vytvori sadu nahodne umistenych molekul. Generaci ukonci pote,
     * so se po zadanem poctu pokusu nepodari najit umisteni pro dalsi molekulu.
     *
     * @param molekul   Pozadovany pocet vytvorenych molekul
     */
    public static int novaSada_3( int molekul, int pokusu )
    {
        int pocet = 0;
        molekuly.clear();
        do{
            if( ++pocet > molekul )
                return pocet;
            System.out.println("Generace " + pocet + ". molekuly:");
        }while( dalsi_2( pokusu ) );    //Dokud se dari molekuly generovat
        System.out.println("Vygenerovali jsme " + (pocet-1) + " molekul");
        return pocet-1 ;
    }

//------------------------------------------------------------------------------

    /***************************************************************************
     * Najde nahodne umisteni dalsi molekuly tak, aby se neprekryvala s zadnou
     * z dosud vytvorenych molekul, a necha molekulu na teto pozici vytvorit.
     * Nepodari-li se to do zadaneho maximalniho poctu pokusu,
     * vzda dalsi snazeni a vrati false. Jinak vrati true.
     *
     * @param pokusu    Maximalne povoleny pocet pokusu pri hledani
     *                  pozice vytvarene molekuly
     *
     * @return Priznak uspesnosti: true = podarilo se vytvorit dalsi molekulu
     */
    public static boolean dalsi_2( int pokusu )
    {
        int x, y;         //Navrhovane souradnice nove molekuly
        int K_PROVERENI = molekuly.size();  //Pocet dosud vytvorenych
        int provereno;
        int pokus = 0;
        do{
            if( pokus >= pokusu )
                return false;   //Na dany pocet pokusu se generace nezdarila

            //Generace navrhu nove pozice
            x = rnd.nextInt( maxX );
            y = rnd.nextInt( maxY );
            System.out.print( "  " + ++pokus + ". pokus: x=" + x +
                                                      ", y=" + y );
            //Otestovani pripadnych kolizi
            provereno = 0;
            //Projdeme mnozinu a otestujeme molekulu za molekulou
            for( Molekula_13a m : molekuly )
            {
                if( PRUMER > P.delka( x, y, m.x,  m.y ) )
                {
                    System.out.println(" koliduje s " + m.poradi +
                                       ". molekulou" );
                    break;
                }
                provereno++;    //Dalsi byla proverena
            }
        //Nebyly-li provereny vsechny, je treba zkusit znovu
        }while( provereno < K_PROVERENI );
        System.out.println( " - USPESNY" );

        Molekula_13a m = new Molekula_13a( x, y );
        return true;
    }



//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Na pozici o zadanych souradnicich vytvori molekulu s nahodnou rychlosti
     * a necha ji zobrazit na aktivnim platne.
     */
    public Molekula_13a(int x, int y)
    {
        super( x, y, PRUMER );
        this.x = x;
        this.y = y;
        this.rx = (rnd.nextDouble() - 0.5) * 2 * maxR / FREKVENCE;
        this.ry = (rnd.nextDouble() - 0.5) * 2 * maxR / FREKVENCE;
        molekuly.add( this );      //Pridej molekulu do mnoziny vygenerovanych
        AP.pridej( this );         //a nech ji zobrazit na aktivni platno
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





