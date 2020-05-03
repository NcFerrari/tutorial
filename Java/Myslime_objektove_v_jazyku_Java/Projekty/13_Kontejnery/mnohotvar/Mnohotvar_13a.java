package mnohotvar;

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
 * Trida slouzi k demonstraci prace se seznamy.
 * Mnohotvar je postupne skladan z rady jednodussich tvaru, ktere museji byt
 * instancemi rozhrani IHybaci. Jine pozadavky na ne kladeny nejsou.
 * Pri sestavovani mnohotvar automaticky meni svoji pozici a rozmer tak,
 * aby pozice byla neustale v levem rohu opsaneho obdelnika a rozmer mnohotvaru
 * odpovidal rozmeru tohoto obdelnika.
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Mnohotvar_13a extends AHybaci
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    /** Seznam prvku, z nichz se mnohotvar sklada. */
    private final List<IHybaci> seznam = new LinkedList<IHybaci>();



//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori prazdny mnohotvar,
     * ktery prevezme nazev generovany rodicovskou tridou     .
     */
    public Mnohotvar_13a()
    {
        this( "" );
    }


    /***************************************************************************
     * Definuje prazdny mnohotvar se zadanym nazvem.
     *
     * @param nazev  Nazev vytvareneho mnohotvaru.
     */
    public Mnohotvar_13a(String nazev)
    {
        super( 0, 0, 0, 0 );
        if( nazev != "" )
            this.nazev = nazev;
    }



//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================

    /***************************************************************************
     * Nakresli mnohotvar pomoci dodaneho kreslitka.
     *
     * @param kreslitko   Kreslitko dodane aktivnim platnem
     */
    public void nakresli(rup.cesky.tvary.Kreslitko kreslitko)
    {
        for( IHybaci ih : seznam )
        {
            ih.nakresli( kreslitko );
        }
    }



//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================

    /***************************************************************************
     * Premisti cely mnohotvar na zadanou pozici.
     * Vsechny soucasti instance se premistuji jako celek
     *
     * @param x  Nastavovana vodorovna souradnice
     * @param y  Nastavovana nastavovana svisla souradnice
     */
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


    /***************************************************************************
     * Nastavi novy rozmer mnohotvaru. Upravi rozmery a pozice vsech jeho
     * sourasti tak, aby vysledny mnohotvar i pri novem rozmeru stejny vzhled.
     *
     * @param sirka  Nastavovana sirka
     * @param vyska  Nastavovana vyska
     */
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
                ih.setRozmer( (int)(ss * ih.getSirka()),
                              (int)(vv * ih.getVyska()) );
                //Pri zmene velikosti se podobjekt take posune
                int dhx = (int)((ih.getX() - xPos) * ss);
                int dhy = (int)((ih.getY() - yPos) * vv);
                ih.setPozice( (xPos + dhx), (yPos + dhy));
            }
            super.setRozmer( sirka, vyska );
        AP.vratKresli();
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Prida do mnohotvaru zadany prvek a prislusne upravi novou
     * pozici a velikost mnohotvaru.
     *
     * @param ih  Pridavany hybaci tvar
     */
    public void pridej( IHybaci ih )
    {
        if( seznam.contains( ih ) )
            throw new IllegalArgumentException( "V obrazci " + this.nazev +
                " je pridavany prvek jiz zahrnut.\n   Pridavano: " + ih);

        if( seznam.isEmpty() )  //Pridavame prvni
        {
            xPos  = ih.getX();
            yPos  = ih.getY();
            sirka = ih.getSirka();
            vyska = ih.getVyska();
        }
        else                    //Pridavame dalsi
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
}

