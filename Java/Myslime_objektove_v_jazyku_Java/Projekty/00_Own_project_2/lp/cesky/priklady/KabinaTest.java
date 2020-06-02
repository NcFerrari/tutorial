package lp.cesky.priklady;

import lp.cesky.spolecne.P;

import lp.cesky.tvary.Barva;
import lp.cesky.tvary.AktivniPlatno;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


/*******************************************************************************
 * Testovaci trida KabinaTest slouzi ke komplexnimu otestovani
 * pridkladu s kabinovou lanovkou.
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class KabinaTest extends junit.framework.TestCase
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================

    private AktivniPlatno AP = AktivniPlatno.getPlatno();
    private int   krok = AP.getKrok();
    private Linka vnejsi;
    private Linka stredni;
    private Linka vnitrni;
    private static String nazevTridy;


//== METODY TRIDY PRO PRIPRAVU A SPUSTENI SADY =================================
//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori test se zadanym nazvem.
     *
     * @param nazev  Nazev konstruovaneho testu
     */
    public KabinaTest(String nazev)
    {
        super( nazev );
    }



//== PRIPRAVA A UKLID PRIPRAVKU ================================================

    /***************************************************************************
     * Vytvori tri soustredne linky.
     */
    protected void setUp()
    {
        AP.odstranVse();
        krok = 50;
        AP.setKrokRozmer( krok, 7, 7 );
        AP.setMrizka( true );
        vnejsi  = Linka.vytvorVnejsi ( 50 );
        stredni = Linka.vytvorStredni( 40 );
        vnitrni = Linka.vytvorVnitrni( 30 );
        P.cekej( 1500 );
    }


    /***************************************************************************
     * Zrusi linky aby mohly byt v pristim testu vytvoreny znovu.
     */
    protected void tearDown()
    {
        vnejsi.zrus();
        stredni.zrus();
        vnitrni.zrus();
    }


//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================

    /***************************************************************************
     * Pro kazdou ze tri linek vytvori kabinu a umisi ji na ni.
     *
     * @param trida  Trida, jejiz budou vytvorene kabiny instanci.
     */
    private TKabina[] vytvorTrojici( Class trida )
    {
        final int TROJIC = 3;
        TKabina.setTrida( trida );
        TKabina[] trojice = new TKabina[ 3*TROJIC ];
        for( int i=0, t=0;   t++ < TROJIC;   )
        {
            trojice[i++] = new TKabina( vnejsi  );
            trojice[i++] = new TKabina( stredni );
            trojice[i++] = new TKabina( vnitrni );
            P.cekej( 1000 );
        };
        return trojice;
    }


    /***************************************************************************
     * Zdvojnasobi rychlost na vsech linkach.
     */
    private void zrychliLinky()
    {
        P.zprava( nazevTridy + "\nBudeme zrychlovat");
        vnejsi .setRychlost( 2*vnejsi .getRychlost() );
        stredni.setRychlost( 2*stredni.getRychlost() );
        vnitrni.setRychlost( 2*vnitrni.getRychlost() );
    }


    /***************************************************************************
     * Demostruje vzorove reseni: vytvori tri linky, umisti na ne kabinky
     * a po potvrzeni od uzivatele pohyb kabin zrychli.
     */
    private void ukonciSkupinu( TKabina[] skupina )
    {
        P.zprava( nazevTridy + "\nBudeme koncit");
        AP.nekresli();
            for( int i=skupina.length;   --i >= 0;   skupina[i].skonci() );
            //Pro pripad, ze by kabina nebyla prave v provozu (ceka ve stanici)
            //a cekala teprve na sve dalsi nasazeni.
            P.cekej( vnejsi.getCekani() + 50 );
            for( int i=skupina.length;   --i >= 0;   skupina[i].skonci() );
        AP.vratKresli();
    }



//== VNORENE A VNITRNI TRIDY ===================================================

    /***************************************************************************
     * Soukroma trida umoznujici pripravit jednu sadu metod pro celou skalu
     * postupne budovanych trid.
     */
    private static class TKabina
    {
        static boolean     tovarni;
        static final Class linka = Linka.class;
        static Class trida;
        static Constructor konstruktor;
        static Method      tovarna;
        static Method      skonci;
         

        Object kabina;


        /***********************************************************************
         * Pripravi potrebne atributy, aby nasledne volane metody mohly pracovat
         * s instancemi tridy zadane jako parametr.
         */
        static void setTrida( Class trida )
        {
            nazevTridy = P.nazevTridy( trida );
            AktivniPlatno.getPlatno().setNazev( "Test tridy: " + nazevTridy );
            TKabina.trida = trida;
            try
            {
                try
                {
                    tovarna = trida.getMethod( "getInstance", 
                                               new Class[] {linka} );
                    tovarni = true;
                }
                catch( NoSuchMethodException e )
                {
                    konstruktor = trida.getConstructor( new Class[] {linka} );
                    tovarni = false;
                }
                    
                skonci = trida.getMethod( "skonci", new Class[0] );
            }
            catch( Exception e )
            {
                throw new RuntimeException(
                    "Nepodarilo se zanalyzovat tridu " + trida, e );
            }
        }


        /***********************************************************************
         * Vytvori novou instanci kabinove tridy a 
         * odkaz na ni ulozi do atributu kabina.
         */
        TKabina( Linka linka )
        {
            if( trida == null )
                throw new IllegalStateException(
                    "Neni definovana trida kabin" );
            try
            {
                if( tovarni )
                    kabina = tovarna.invoke( null, new Object[] { linka } );
                else
                    kabina = konstruktor.newInstance( new Object[] { linka } );
            }
            catch( Exception e )
            {
                throw new RuntimeException(
                    "Nepodarilo se vytvorit kabinu na lince " + linka, e );
            }
        }
        

        /***********************************************************************
         * Ukonci cinnost sve kabiny = zavola jeji metodu skonci().
         */
        void skonci()
        {
            try
            {
                skonci.invoke( kabina, new Object[0] );
             }
            catch( Exception e )
            {
                throw new RuntimeException(
                    "Nepodarilo se ukoncit kabinu na lince " + linka, e );
            }
       }
    }



//== VLASTNI TESTY =============================================================

    /***************************************************************************
     * Test schopnosti vytvoreni nekolika nezavislych linek;
     */
    public void testLinka()
    {
        assertTrue( P.souhlas( "Tri soustredne linky uspesne vytvoreny?" ) );
    }


    /***************************************************************************
     * Test postupne tvorby linky. Protoze se mi nechtelo definovat novou
     * testovaci tridu, tak jsem nejprve uklidil, pak provedl test a pak zase
     * nechal vybudovat pripravek, aby se uklizeci metoda nevzbourila.
     * Nani v tom jiny ucel nez ma lenora.
     */
    public void testTvorbyLinky()
    {
        int[][] zastavky = { {25,125}, {125,25}, {125,225} };
        tearDown();
        Linka linka = new Linka( Barva.FIALOVA, 25, 25, 225, 225 );
        P.zprava( "Nova linka se dvema zastavkami" );
        IZastavka minula = linka.getPrvni();
        for( int i=0;   i < zastavky.length;   i++ )
        {
            int[] nova = zastavky[i];
            int x = nova[0];
            int y = nova[1];
            linka.pridejZa( minula, x, y );
            P.zprava( "Pribyla zastavka na souradncich [" + x + ";" + y + "]" );
        }
    }


    /***************************************************************************
     * Demostruje vzorove reseni: vytvori tri linky, umisti na ne kabinky
     * a po potvrzeni od uzivatele pohyb kabin zrychli.
     */
    public void testKabina_8a()
    {
        TKabina[] k3 = vytvorTrojici( Kabina_8a.class );
        zrychliLinky();
        ukonciSkupinu( k3 );
    }


    /***************************************************************************
     * Demostruje vzorove reseni: vytvori tri linky, umisti na ne kabinky
     * a po potvrzeni od uzivatele pohyb kabin zrychli.
     */
    public void testKabina()
    {
        TKabina[] k3 = vytvorTrojici( Kabina.class );
        zrychliLinky();
        ukonciSkupinu( k3 );
    }


    /***************************************************************************
     *
     * /
    public void testXXX()
    {
    }

/**/

}

