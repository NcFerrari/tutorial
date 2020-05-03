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
 * Trida Molekula_13c definuje sadu metod, ktere vygeneruji na platno
 * skupiny nahodne rozmistenych molekul, jez pak rozpohybuji simulujice
 * Brownuv pohyb molekul.
 * Tato verze ma v prostoru molekul umistenu "vylevku",
 * ktera vysaje kazdou molekulu, ktera se cele dostane do jejiho dosahu.
 *
 * Zmeny oproti tride Molekula_13b:
 * - atribut PRUMER zmenil svuj pristup z private na implicitni
 * - trida AnimatorMolekul_13c nyni simuluje vedle pohybu i cinost vylevky,
 *   ktera z platna odstrani molekuly, jez se dostaly do jeji oblasti
 *   (podrobnosti viz dokumentace tridy)
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Molekula_13c extends Kruh
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Frekvence prekreslovani planta s molekulami. */
    static final int FREKVENCE = 50;

    /** MAximalni pocet pokusu venovanych na umisteni dalsi moelkuly. */
    private static final int POKUSU = 3;

    /** Spolecny prumer vsech moelkul. */
    static final int PRUMER = 50;

    /** Maximalni povolena rychlost molekuly,
     * tj. kolik bodu muze molekula urazit za sekundu. */
    private static int maxR = 300 ;

    /** Mnozina vsech dosud vygenerovanych molekul.
     *  Atribut neni private aby k nemu mohl pristupovat animator. */
    static final Set<Molekula_13c> molekuly =
    					   new LinkedHashSet<Molekula_13c>();

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
            for( Molekula_13c m : molekuly )
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

        Molekula_13c m = new Molekula_13c( x, y );
        return true;
    }



//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * Na pozici o zadanych souradnicich vytvori molekulu s nahodnou rychlosti
     * a necha ji zobrazit na aktivnim platne.
     */
    public Molekula_13c(int x, int y)
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
        for( Molekula_13c m : molekuly )
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
        new AnimatorMolekul_13c();
    }


}//public class Molekula_13c extends Kruh



//==============================================================================
//==============================================================================
//==============================================================================


/*******************************************************************************
 * Trida AnimatorMolekul_13c definuje objekt, ktery zabezpeci
 * animaci molekul ulozenych ve statickem atributu <code>molekuly</code>
 * tridy </code>Molekula_13c</code>.
 * Animator by mel spravne byt bud jedinacek, nebo alespon kontrolovat,
 * ze se druhy nespusti drive, nez prvni dobehne.
 * Vzhledem k tomu, ze je urcen pouze pro testovaci ucely a bude jej
 * pouzivat pouze trida <code>Molekula_13c</code>, dopustime se maleho hrichu
 * a tyto kontroly do kodu nezahrneme.
 *
 * Oproti verzi AnimatorMolekul_13b doslo k temot zmenam:
 * - Trida nyni simuluje vedle pohybu molekul i cinost vylevky,
 *   ktera z platna odstrani molekuly, jez se dostaly do jeji oblasti.
 * - Pribyly konstanty POMER, V_POZICE, V_ROZMER
 *   definujici nektere parametry vylevky
 * - Konstruktor umisti do leveho horniho rohu platna velky cerny kruh
 *   predstavujici vylevku.
 * - Metoda run() odstrani z platna instanci,
 *   ktera se nachazi cela v oblasti vylevky.
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
class AnimatorMolekul_13c extends TimerTask
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
    /** O jaky dil prumeru molekuly budou vylevka a generator vetsi. */
    private static final double POMER = 0.3;

    /** Minimalni souradnice molekuly spadle do vylevky */
    private static final int V_POZICE = (int)(Molekula_13d.PRUMER * POMER);

    /** Rozmer vylevky a generatoru molekul. */
    private static final int V_ROZMER = (int)(Molekula_13d.PRUMER * (1+POMER));

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
     * Soucasti kontrukce animatoru je i nakresleni jimky
     * v levem hornim rohu aktivniho platna.
     */
    public AnimatorMolekul_13c()
    {
        AP.pridejDospod( new Kruh( 0, 0, V_ROZMER,
                                rup.cesky.tvary.Barva.CERNA ));
        new Timer().schedule( this, 0, 1000 / Molekula_13c.FREKVENCE );
    }



//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================

    /***************************************************************************
     * Metoda pozadovana tridou TimerTask. Bude spoustena casovacem
     * s pozadovanou frekvenci. Tato metoda ma na starosti vlastni animaci
     * vcetne "pozirani molekul" jimkou.
     */
    public void run()
    {
        AP.nekresli();
            for( Iterator it = Molekula_13c.molekuly.iterator();
                 it.hasNext();  )
            {
                Molekula_13c m = (Molekula_13c)(it.next());
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
        AP.vratKresli();
    }



//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}




