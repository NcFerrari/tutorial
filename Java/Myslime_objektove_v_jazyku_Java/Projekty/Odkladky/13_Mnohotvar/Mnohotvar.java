import java.util.LinkedList;
import java.util.List;

import rup.cesky.tvary.AHybaci;
import rup.cesky.tvary.IHybaci;

import rup.cesky.tvary.Barva;
import rup.cesky.tvary.Smer8;

import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.Ctverec;
import rup.cesky.tvary.Obdelnik;
import rup.cesky.tvary.Elipsa;
import rup.cesky.tvary.Trojuhelnik;
import rup.cesky.tvary.Kruh;
import rup.cesky.tvary.Presouvac;
import rup.cesky.tvary.Kompresor;


/*******************************************************************************
 * Trida Sbl_Trida slouzi k ...
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Mnohotvar extends AHybaci
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
    
    private static final List<IHybaci> seznam = new LinkedList<IHybaci>();
    
    
    
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * 
     */
    public Mnohotvar()
    {
        this( "" );
    }


    /***************************************************************************
     * 
     */
    public Mnohotvar( String nazev )
    {
        super( 0, 0, 0, 0 );
        if( nazev != "" )
            this.nazev = nazev;
    }

    

//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================

    public void nakresli(rup.cesky.tvary.Kreslitko kreslitko)
    {
        for( IHybaci ih : seznam )
        {
            ih.nakresli( kreslitko );
        }
    }
    
    
    
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
    
    public void setPozice( int x, int y )
    {
        int dx = x - xPos;
        int dy = y - yPos;
        AP.nekresli();
            for( IHybaci ih : seznam )
            {
                ih.setPozice( dx + ih.getX(), dy + ih.getY() );
            }
            super.setPozice( x, y );   
        AP.vratKresli();
    }
    
    
    public void setRozmer( int sirka, int vyska )
    {
        //Zapamatuj si pomery zmeny sirky a vysky celeho obrazce
        double ss = (double)sirka / this.sirka;
        double vv = (double)vyska / this.vyska;
        
        //Uprav velikosti a pozice jednotlivych casti
        AP.nekresli();
            for( IHybaci ih : seznam )
            {
                //Objekty s nulovymi rozmery svou velikost nemeni
                if( (ih.getSirka() == 0)  ||  (ih.getVyska() == 0) )
                    continue;
                ih.setRozmer( (int)Math.round(ss * ih.getSirka()),  
                              (int)Math.round(vv * ih.getVyska()) );
                //Pri zmene velikosti se podobjekt take posune
                int dhx = (int)Math.round((ih.getX() - xPos) * ss);
                int dhy = (int)Math.round((ih.getY() - yPos) * vv);
                ih.setPozice( (xPos + dhx), (yPos + dhy));
            }
            super.setRozmer( sirka, vyska );
        AP.vratKresli();
    }

    
    
//== NOVE ZAVEDENE METODY INSTANCI =============================================
    
    public void pridej( IHybaci ih )
    {
        if( seznam.contains( ih ) )
            throw new IllegalArgumentException( "V obrazci " + this.nazev + 
                " je pridavany prvek jiz zahrnut.\n   Pridavano: " + ih);
        
        if( seznam.isEmpty() )
        {
            xPos  = ih.getX();
            yPos  = ih.getY();
            sirka = ih.getSirka();
            vyska = ih.getVyska();
        }
        else
        {
            int ihx = ih.getX();
            int ihy = ih.getY();
            int ihs = ih.getSirka();
            int ihv = ih.getVyska();

            if( ihx < xPos )
            {
                sirka += xPos - ihx;
                xPos = ihx;
            }
            if( ihy < yPos )
            {
                vyska += yPos - ihy;
                yPos = ihy;
            }
            if( (xPos + sirka) < (ihx + ihs) )
                sirka = ihx + ihs - xPos;
            if( (yPos + vyska) < (ihy + ihv) )
                vyska = ihy + ihv - yPos;
        }
        AP.nekresli();
            AP.odstran( ih );
            seznam.add( ih );
        AP.vratKresli();
    }
    
    
    
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================

    private static void test_1()
    {
//        AP.setRozmer( 8, 8 );
        Mnohotvar mt = new Mnohotvar( "Zkusebni" );
        AP.pridej( mt );
        mt.pridej( new Ctverec() );
        mt.pridej( new Ctverec( 50, 50, 50) );
        mt.setPozice( 50, 50 );
        mt.pridej( new Ctverec() );
        mt.posunDolu();
        mt.posunVpravo();
        mt.setRozmer( 50, 50 );
        mt.setRozmer(200, 200);
        mt.setRozmer( 5, 5 );
        mt.setRozmer(150, 150);
        mt.posunDolu();
        mt.posunVpravo();
    }
    public static void main( String[] args )
    {
        test_1();
    }
}//public class Sbl_Trida

