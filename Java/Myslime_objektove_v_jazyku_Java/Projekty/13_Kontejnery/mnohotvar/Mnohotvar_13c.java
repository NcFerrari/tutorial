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
 * Oproti tride Mnohotvar_13b se zmenilo:
 * - V souboru pribyla vnorena trida Cast, ktera slouzi jako prepravka
 *   pro dodatecne informace o tvarech, z nichz je mnohotvar sestavovan.
 * - Zmenil se typ prvku seznamu - nyni jsou jeho prvky instance tridy Cast
 * - Metoda setRozmer(int,int) nyni vyuziva dodatecne informace z prepravek.
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Mnohotvar_13c extends AHybaci
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    /** Seznam prvku, z nichz se mnohotvar sklada. */
    private final List<Cast> seznam = new LinkedList<Cast>();



//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori prazdny mnohotvar,
     * ktery prevezme nazev generovany rodicovskou tridou     .
     */
    public Mnohotvar_13c()
    {
        this( "" );
    }


    /***************************************************************************
     * Definuje prazdny mnohotvar se zadanym nazvem.
     *
     * @param nazev  Nazev vytvareneho mnohotvaru.
     */
    public Mnohotvar_13c(String nazev)
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
        for( Cast c : seznam )
        {
            c.ih.nakresli( kreslitko );
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
            for( Cast c : seznam )
            {
                IHybaci cih = c.ih;
                cih.setPozice( dx + cih.getX(), dy + cih.getY() );
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
        Cast.pripravKonstanty( xPos, yPos, this.sirka, this.vyska, 
                               xPos, yPos, sirka,      vyska );
        //Uprav velikosti a pozice jednotlivych casti
        AP.nekresli();
            for( Cast c : seznam )
                c.poNafouknuti();
            super.setRozmer( sirka, vyska );
        AP.vratKresli();
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Vrati index zadaneho prvku v mnohotvaru. Prvek, ktery je zcela vespod
     * ma index 0, prvek ktery je zcela navrchu ma index o jednicku mensi,
     * nez je pocet prvku mnohotvaru.
     *
     * @param ih  Pridavany hybaci tvar
     * 
     * @return    Index zadaneho prvku v mnohotvaru. 
     *            Neni-li prvek soucasti mnohotvaru, vrati -1.
     */
    public int index( IHybaci prvek )
    {
        int kde = 0;
        for( Cast c : seznam )
        {
            if( c.ih == prvek )
                return kde;     //==========>
            kde++;
        }
        return -1;
    }


    /***************************************************************************
     * Prida do mnohotvaru zadany prvek a prislusne upravi novou
     * pozici a velikost mnohotvaru.
     *
     * @param ih  Pridavany hybaci tvar
     */
    public void pridej( IHybaci ih )
    {
        if( index( ih ) >= 0 )
            throw new IllegalArgumentException( "V obrazci " + this.nazev +
                " je pridavany prvek jiz zahrnut.\n   Pridavano: " + ih);

        if( seznam.isEmpty() )  //Pridavame prvni
        {
            xPos  = ih.getX();
            yPos  = ih.getY();
            sirka = ih.getSirka();
            vyska = ih.getVyska();
            Cast.pripravKonstanty( 0, 0, 0, 0, xPos, yPos, sirka, vyska );
        }
        else                    //Pridavame dalsi
        {
            int mx = xPos;
            int my = xPos;
            int ms = sirka;
            int mv = vyska;

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

            Cast.pripravKonstanty( mx, my, ms, mv, xPos, yPos, sirka, vyska );
            for( Cast c : seznam )
                c.poPridani();
        }
        AP.nekresli();
            AP.odstran( ih );
            seznam.add( new Cast( ih ) );
        AP.vratKresli();
    }


//== VNORENE A VNITRNI TRIDY ===================================================

    /*******************************************************************************
     * Trida slouzi jako prepravka pro uchovavani pomocnych informaci
     * pro co nelepsi zmenu velikosti mnohotvaru.
     *
     * @author    Rudolf Pecinovsky
     * @version   0.00.000,  0.0.2003
     */
    private static final class Cast
    {
    //== KONSTANTNI ATRIBUTY TRIDY =================================================
    //== PROMENNE ATRIBUTY TRIDY ===================================================
    
        /** Stare a nove souradnice a rozmery celeho mnohotvaru. */
        static double smx, smy, sms, smv,
                      nmx, nmy, nms, nmv;
    
    //== KONSTANTNI ATRIBUTY INSTANCI ==============================================
    //== PROMENNE ATRIBUTY INSTANCI ================================================
    
        /** Odkaz na cast mnohotvaru. */
        IHybaci ih;
    
        /** Podil odstupu od leveho kraje mnohotvaru na jeho celkove sirce. */
        double dx;
    
        /** Podil odstupu od horniho kraje mnohotvaru na jeho celkove vysce. */
        double dy;
    
        /** Podil sirky casti k celkove sirce mnohotvaru. */
        double ds;
    
        /** Podil vysky casti k celkove vysce mnohotvaru. */
        double dv;
    
    
    
    //== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
    //== OSTATNI METODY TRIDY ======================================================
    
    
        /***************************************************************************
         * Pripravuje podklady pro naslednou aktualizaci uchovavanych pomeru
         * klicovych rozmeru jednotlivych soucasti mnohotvaru.
         * Tyto konstanty jsou pro vsechny soucasti mnohotvaru spolecne.
         * 
         * @param sx  Puvodni (stare) x.
         * @param sy  Puvodni (stare) y.
         * @param ss  Puvodni (stara) sirka.
         * @param sv  Puvodni (stara) vyska.
         * @param nx  Nove x.
         * @param ny  Nove y.
         * @param ns  Nova sirka.
         * @param nv  Nova vyska.
         */
        static void pripravKonstanty( int sx, int sy, int ss, int sv,
                                      int nx, int ny, int ns, int nv )
        {
            smx = sx;   smy = sy;   sms = ss;   smv = sv;
            nmx = nx;   nmy = ny;   nms = ns;   nmv = nv;
        }
    
    //##############################################################################
    //== KONSTRUKTORY A TOVARNI METODY =============================================
    
        /***************************************************************************
         * Vytvori prepravku a zapamatuje si aktualni stav nekterych pomeru
         * vuci soucasne porobe multitvaru.
         */
        Cast( IHybaci ih )
        {
            this.ih = ih;
    
            dx = (ih.getX() - nmx) / nms;
            dy = (ih.getY() - nmy) / nmv;
            ds = ih.getSirka() / nms;
            dv = ih.getVyska() / nmv;
        }
    
    
    //== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
    //== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
    //== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
    //== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
    //== NOVE ZAVEDENE METODY INSTANCI =============================================
    
        /***************************************************************************
         * Aktiualizuje uchovavane pomery klicovych rozmeru tvaru vuci mnohotvaru.
         * Ocekava, ze metoda priprav nastavila hodnoty potrebnych konstant.
         */
        void poPridani()
        {
            //Souradnice se mohou pouze zmensovat
            dx = (smx - nmx + dx*sms) / nms;
            dy = (smy - nmy + dy*smv) / nmv;
            
            ds = ds * sms / nms;
            dv = dv * smv / nmv;
        }
    
    
        /***************************************************************************
         * Aktualizuje uchovavane pomery klicovych rozmeru a vykresli dany tvar
         * v aktualni pozici a rozmeru.
         */
        void poNafouknuti()
        {
            ih.setPozice( (int)Math.round( nmx + dx*nms ),
                          (int)Math.round( nmy + dy*nmv )  );
            ih.setRozmer( (int)Math.round( nms*ds ),  
                          (int)Math.round( nmv*dv ) );
        }
    
    
    //== SOUKROME A POMOCNE METODY TRIDY ===========================================
    //== SOUKROME A POMOCNE METODY INSTANCI ========================================
    //== VNORENE A VNITRNI TRIDY ===================================================
    //== TESTY A METODA MAIN =======================================================
    }

//== TESTY A METODA MAIN =======================================================
}

