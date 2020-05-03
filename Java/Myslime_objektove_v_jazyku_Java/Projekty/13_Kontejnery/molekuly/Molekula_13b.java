package molekuly;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import rup.cesky.spolecne.P;

import rup.cesky.tvary.Kruh;


/*******************************************************************************
 * Trida Molekula_13b definuje sadu metod, ktere vygeneruji na platno
 * skupiny nahodne rozmistenych molekul, jez pak rozpohybuji simulujice
 * Brownuv pohyb molekul. 
 *
 * Zmeny oproti tride Molekula_13a:
 * - odstraneny metody dalsi_1(), novaSada_1(int) a nova sada_2(int), 
 *   ktere byly pouze postupnymi kroky pri priprave definitivni verze
 * - metody dalsi_2(int) a novaSada_3(int,int) prejmenovany 
 *   na dalsi(int) a novaSada(int,int)
 * - atributy FREKVENCE, molekuly, x, y 
 *   maji zmeneny pristup z private na implicitni (package private).
 * - pridana metoda popojed()
 * - pridana metoda test() testujici funkcnost simulace
 * - pridana neverejna trida AnimatorMolekul_13b (rozsirujici TimerTask)
 *   s bezperemetrickym konsturktorem a metodou run(), ktera je zodpovedna
 *   za animaci molekul na platne
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Molekula_13b extends Kruh
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Frekvence prekreslovani planta s molekulami. */
    static final int FREKVENCE = 50;

    /** MAximalni pocet pokusu venovanych na umisteni dalsi moelkuly. */
    private static final int POKUSU = 3;

    /** Spolecny prumer vsech moelkul. */
    private static final int PRUMER = 50;

    /** Maximalni povolena rychlost molekuly, 
     * tj. kolik bodu muze molekula urazit za sekundu. */
    private static int maxR = 300 ;

    /** Mnozina vsech dosud vygenerovanych molekul. 
     *  Atribut neni private aby k nemu mohl pristupovat animator. */
    static final Set<Molekula_13b> molekuly = 
                           new LinkedHashSet<Molekula_13b>();

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


    /***************************************************************************
     * Vytvori sadu nahodne umistenych molekul. Generaci ukonci pote,
     * so se po zadanem poctu pokusu nepodari najit umisteni pro dalsi molekulu.
     *
     * @param molekul   Pozadovany pocet vytvorenych molekul
     */
    public static int novaSada( int molekul, int pokusu )
    {
        int pocet = 0;
        molekuly.clear();
        do{
            if( pocet >= molekul )
                return pocet;
            System.out.println("Generace " + ++pocet + ". molekuly:");
        }while( dalsi( pokusu ) );    //Dokud se dari molekuly generovat
        System.out.println("Vygenerovali jsme " + (pocet-1) + " molekul");
        return pocet - 1;
    }



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
    public static boolean dalsi( int pokusu )
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
            for( Molekula_13b m : molekuly )
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

        Molekula_13b m = new Molekula_13b( x, y );
        return true;
    }

    

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Na pozici o zadanych souradnicich vytvori molekulu s nahodnou rychlosti 
     * a necha ji zobrazit na aktivnim platne.
     */
    public Molekula_13b(int x, int y)
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

    private final String ps = ((poradi < 10) ? " " : "" ) + pocet;

    /***************************************************************************
     * Posune molekulu do nove pozice definovane jeji soucasnou pozici
     * a snimkovou rychlosti. V nove pozici zkontroluje, jestli molekula
     * nenarazila do okraje platna ci nektere jine molekuly. Pokud ano,
     * tak posun zrusi a upravi rychlost zucastnenych tak, aby similovaly
     * dokonaly odraz.     
     */
    public void popojed()
    {
        double xn = x + rx;     //Planovana nova vodorovna souradnice
        double yn = y + ry;     //Planovana nova svisla souradnice
        boolean odraz = false;  //Predpokladame, ze se neodrazi

        //Test odrazu od zdi
        if( (xn <= 0) || (maxX <= xn) )   {  rx =-rx;  odraz = true; }
        if( (yn <= 0) || (maxY <= yn) )   {  ry =-ry;  odraz = true; }
        if( x<=0  || y<=0  )
            System.out.println( "Zed: " +
                "xPos=" + xPos + ", x=" + x + ", rx=" + rx + ", xn=" + x +
         "\n     yPos=" + yPos + ", y=" + y + ", ry=" + ry + ", yn=" + y );

        //Testy moznych odrazu od ostatnich molekul
        for( Molekula_13b m : molekuly )
        {
            if( (m != this)  &&  //Sama od sebe se neodrazi
                (P.delka( xn, yn, m.x,  m.y )  <  PRUMER) )
            {
                double p;   //Molekuly si prohodi rychlosti
                p = rx;   rx = m.rx;   m.rx = p;
                p = ry;   ry = m.ry;   m.ry = p;
                if( x<0  || y<0  )
                {
            System.out.println( "Mol." + ps + ": " +
                "xPos=" + xPos + ", x=" + x + ", rx=" + rx + ", xn=" + xn +
      "\n        yPos=" + yPos + ", y=" + y + ", ry=" + ry + ", yn=" + yn +
      "\n    " + m.ps + ": " +
                "xPos=" + m.xPos + ", rx=" + m.rx + ", x=" + m.x +
      "\n        yPos=" + m.yPos + ", ry=" + m.ry + ", y=" + m.y +
                 "");
                }
                odraz = true;
            }
        }
        //Pokud se molekula odrazila, jeji pozice se nezmeni
        //(spokojime se pouze s nastavenou zmenou rchlosti)
        if( !odraz )
            setPozice( (int)(x = xn), (int)(y = yn) );
    }
        


//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
    
    /***************************************************************************
     * Testovaci program - vygeneruje novou sadu molekul a spusti animaci
     * jejich pohybu.     
     */         
    public static void test()
    {
        novaSada( 20, 20 );    //Zadavam pocet molekul
        new AnimatorMolekul_13b();
    }


}

