package priklady;

import rup.cesky.spolecne.P;
import rup.cesky.tvary.Barva;
import rup.cesky.tvary.Kreslitko;
import rup.cesky.tvary.Kruh;


/*******************************************************************************
 * Trida Balon_12a simuluje pruzny padajici balon, ktery pada zrychlene dolu
 * a po dopadu se odrazi zmensenou rychlosti, takze o nejake dobe doskace.
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public final class Balon_13 extends Kruh implements IAnimovany
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Zmena rychlosti za jeden snimek. */
    private static final int IMPLICITNI_VELIKOST = 20;

    /** Zmena rychlosti za jeden snimek. */
    private static final Barva IMPLICITNI_BARVA = Barva.CERVENA;

    private static final Animator ANIMATOR = Animator.getInstance();

    /** Gravitacni zrychleni. **/
    private static final double GRAVITACNI_ZRYCHLENI  = 400;

    /** Zmena rychlosti za jeden snimek. */
    private static final double UTLUM = 0.85;

    /** Zmena rychlosti za jeden snimek. */
    private static final double MINIMALNI_RYCHLOST = 50;



//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    private final double konecne_y = AP.getBVyska() - getVyska();


//== PROMENNE ATRIBUTY INSTANCI ================================================

    private double rychlost;
    private double y;



//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Implicitni konstruktor vytvori v levem hornim rohu aktivniho platna
     * balon o prumeru 25 a necha jej spadnout.
     */
    public Balon_13()
    {
        this( 0, 0, IMPLICITNI_VELIKOST, IMPLICITNI_BARVA );
    }


    /***************************************************************************
     * Vytvori novy balon na zadane pozici a o zadanem prumeru
     * a necha jej spadnout.
     */
    public Balon_13(int x, int y, int prumer, Barva barva)
    {
        super( x, y, prumer, barva );
        AP.pridej( this );
        spadni();
    }



//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================

    public void nakresli( rup.cesky.tvary.Kreslitko kr )
    {
        super.nakresli(kr);
    }

    /***************************************************************************
     * Simuluje poskakovani balonu v gravitacnim poli.
     * Balon se po dopadu odrazi po dopadu se odrazi zmensenou rychlosti,
     * takze o nejake dobe doskace.
     */
    public boolean popojed()
    {
        if( y < konecne_y )
        {
            rychlost += GRAVITACNI_ZRYCHLENI * ANIMATOR.getUplynulo() /1000;
            y += rychlost * ANIMATOR.getUplynulo() /1000;
        }
        else
        {
            y = konecne_y - 1;
            rychlost = -rychlost * UTLUM;
            if( -rychlost < MINIMALNI_RYCHLOST )
            {
                return true;
            }
        }
        //Rodicovska verze setPozice vyzaduje celociselne parametry -
        // aktualni svislou souradnici proto musime pretypovat
        setPozice( xPos, (int)y );
        return false;
    }


//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Presune balon do zadane pozice a necha jej odtud spadnout.
     */
    public void presunNa( int x, int y )
    {
        setPozice( x, y );  //Nastaveni pozice muzes sverit rodici
        spadni();           //Zacni padat
    }


    /***************************************************************************
     * Simuluje poskakovani balonu v gravitacnim poli.
     * Balon se po dopadu odrazi po dopadu se odrazi zmensenou rychlosti,
     * takze o nejake dobe doskace.
     */
    private void spadni()
    {
        this.y = y;
        this.rychlost = 0;
        ANIMATOR.start();
        ANIMATOR.pridej( this );
    }



//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================

    /***************************************************************************
     * Test vytvori implicitni balon a necha jej spadnout.
     * Pak vytvori druhy balon a po jeho dopadu presune prvni do nove pozice
     * a opet jej odtud necha spadnout.
     */
    public static void test()
    {
        AP.odstranVse();
        //Velikost aktivniho platna ne nastavena na obrazovku 1024\u00d7768
        AP.setKrokRozmer( 50, 3 , 15 );
        AP.setMrizka( true );

        Balon_13 b1 = new Balon_13();
        P.cekej( 1000 );
        Balon_13 b2 = new Balon_13( 50, 50, 100, Barva.ZELENA );
        P.cekej( 1000 );
        Balon_13 b3 = new Balon_13( 100, 100, 50, Barva.MODRA );
    }


}

