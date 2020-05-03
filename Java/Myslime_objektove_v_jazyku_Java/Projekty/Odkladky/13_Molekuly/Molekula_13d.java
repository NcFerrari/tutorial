import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Iterator;

import rup.cesky.spolecne.P;

import rup.cesky.tvary.Kruh;
import rup.cesky.tvary.AktivniPlatno;


/*******************************************************************************
 * Trida Molekula_13d definuje sadu metod, ktere vygeneruji na platno
 * skupiny nahodne rozmistenych molekul, jez pak rozpohybuji simulujice
 * Brownuv pohyb molekul.
 * Tato verze ma v prostoru molekul umistenu nejenom vylevku,
 * ktera vysaje kazdou molekulu, jez se cele dostane do jejiho dosahu,
 * ale take generator novych molekul, ktery v okamzkuku, kdy se v jeho oblasti
 * nenachazi zadna molekula vygeneruje novou molekulu a vysle ji do sveta
 *
 * Zmeny oproti tride Molekula_13d:
 * - atribut maxX, maxY zmenily svuj pristup z private na implicitni
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Molekula_13d extends Kruh
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Frekvence prekreslovani planta s molekulami. */
    public static final int FREKVENCE = 50;

    /** MAximalni pocet pokusu venovanych na umisteni dalsi moelkuly. */
    private static final int POKUSU = 3;

    /** Spolecny prumer vsech moelkul. */
    static final int PRUMER = 50;

    /** Maximalni povolena rychlost molekuly,
     * tj. kolik bodu muze molekula urazit za sekundu. */
    private static int maxR = 300 ;

    /** Mnozina vsech dosud vygenerovanych molekul.
     *  Atribut neni private aby k nemu mohl pristupovat animator. */
    static final Set<Molekula_13d> molekuly =
    					   new LinkedHashSet<Molekula_13d>();

    /** Spolecny generator nahodnych cisel. */
    private static final Random rnd = new Random();





//== PROMENNE ATRIBUTY TRIDY ===================================================

    /** Pocet dosud vytvorenych instanci. */
    private static int pocet = 0;

    /** Maximalni povolene souradnice molekuly. */
    static int maxX;
    static int maxY;

    static { nastavMaxima(); }



//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    /** Poradi vytvoreni dane instance v ramci tridy. */
    private final int poradi = ++pocet;


//== PROMENNE ATRIBUTY INSTANCI ================================================


    /** Slozky aktualni pozice molekuly. */
    double x, y;

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
        }while( dalsi( pokusu ) );
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
            for( Molekula_13d m : molekuly )
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

        Molekula_13d m = new Molekula_13d( x, y );
        return true;
    }



//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * Na pozici o zadanych souradnicich vytvori molekulu s nahodnou rychlosti
     * a necha ji zobrazit na aktivnim platne.
     */
    public Molekula_13d(int x, int y)
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
        for( Molekula_13d m : molekuly )
        {
            if( (m != this)  &&  (P.delka( xn, yn, m.x,  m.y )  <  PRUMER) )
            {
                double p;
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
        new AnimatorMolekul_13d();
    }


}//public class Molekula_13d extends Kruh
//==============================================================================
//==============================================================================
//==============================================================================


/*******************************************************************************
 * Trida AnimatorMolekul_13d definuje skupinu objekt, ktery zabezpeci
 * animaci molekul ulozenych ve statickem atributu molekuly
 * tridy Molekula_13d.
 * Tato verze navic umisti do rohu oblasti s molekulami vylevku,
 * ktera vcucne kazdou molekulu, jez do ni cele vstoupi.
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
class AnimatorMolekul_13d extends TimerTask
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** O jaky dil prumeru molekuly budou vylevka a generator vetsi. */
    private static final double POMER = 0.3;

    /** Minimalni souradnice molekuly spadle do vylevky */
    private static final int V_POZICE = (int)(Molekula_13d.PRUMER * POMER);

    /** Rozmer vylevky a generatoru molekul. */
    private static final int V_ROZMER = (int)(Molekula_13d.PRUMER * (1+POMER));

    /** Souradnice generatoru molekul. */
    private static final int X_GENERATORU = Molekula_13d.maxX - V_POZICE;
    private static final int Y_GENERATORU = Molekula_13d.maxY - V_POZICE;

    /** Maximalni souradnice molekuly nazasahujici do generatoru. */
    private static final int XX = X_GENERATORU - Molekula_13d.PRUMER;
    private static final int YY = Y_GENERATORU - Molekula_13d.PRUMER;

    /** AP od tridy Molekula_13d je nedosazitelne, protoze ta je dedi od
     *  rodicovske tridy trida APosuvny, jez je deklarovala jako protected. */
    AktivniPlatno AP = AktivniPlatno.getPlatno();


//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * Vytvori novy animator molekul, ktery bude s frekvenci zadanou ve tride
     * Molekula_13b zadat moelkuly o aktulizaci jejich pozice
     * a nasledne nechavat prekreslit platno.
     * Soucasti kontrukce animatoru je i nakresleni jimky v levem hornim
     * a generatoru molekul v pravem dolnim rohu aktivniho platna.
     */
    public AnimatorMolekul_13d()
    {
        AP.pridejDospod( new Kruh( 0, 0, V_ROZMER,
                                rup.cesky.tvary.Barva.CERNA ));
        AP.pridejDospod( new Kruh( X_GENERATORU, Y_GENERATORU, V_ROZMER,
                                rup.cesky.tvary.Barva.CERVENA ));
        new Timer().schedule( this, 0, 1000 / Molekula_13d.FREKVENCE );
    }



//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================

    /***************************************************************************
     * Metoda pozadovana tridou TimerTask. Bude spoustena casovacem
     * s pozadovanou frekvenci. Tato metoda ma na starosti vlastni animaci
     * vcetne "pozirani molekul" jimkou a generace novych molekul generatorem.
     */
    public void run()
    {
        AP.nekresli();
            for( Iterator it = Molekula_13d.molekuly.iterator();
                 it.hasNext();  )
            {
                Molekula_13d m = (Molekula_13d)(it.next());
                if( (m.x <= V_POZICE)  &&  (m.y <= V_POZICE) )
                {
                    it.remove();
                    AP.odstran( m );
                }
                else
                {
                    m.popojed();
                }
            }
            zkusNovou();
        AP.vratKresli();
    }



//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================

    /***************************************************************************
     * Metoda zjisti, jestli se v oblasti generatoru nenachazi zadne molekula
     * (tj. jestli ji v generovani nikdo neprekazi) a pokud ne,
     * vygeneruje novou molekulu, ktera se inicialitvne vzapeti vyda do svete.
     */
    private void zkusNovou()
    {
        boolean prekazi = false;
        for( Molekula_13d m : Molekula_13d.molekuly )
        {
            if( (m.x > XX)  &&  (m.y > YY) )
            {
                prekazi = true;
                break;
            }
        }
        if( !prekazi )
        {
            new Molekula_13d( (X_GENERATORU + V_POZICE/2),
                              (Y_GENERATORU + V_POZICE/2) );
        }
    }


//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}






