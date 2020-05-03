package rup.cesky.tvary_2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;


/*******************************************************************************
 * Trida <b><code>AktivniPlatno</code></b> slouzi k jednoduchemu kresleni
 * na virtualni platno a pripadne nasledne animaci nakreslenych obrazku.
 * </p><p>
 * Trida neposkytuje verejny konstruktor, protoze chce, aby jeji instance
 * byla jedinacek, tj. aby se vsechno kreslilo na jedno a to same platno.
 * Jedinym zpusobem, jak ziskat odkaz na instanci tridy
 * <code>AktivniPlatno</code>,
 * je volani jeji staticke metody <code>getPlatno()</code>.
 * </p><p>
 * Trida <code>AktivniPlatno</code> funguje jako manazer, ktery dohlizi
 * na to, aby se po zmene zobrazeni nektereho z tvaru vsechny ostatni tvary
 * radne prekreslily, aby byly spravne zachyceny vsechny prekryvy
 * a aby se pri pohybu jednotlive obrazce vzajemne neodmazavaly.
 * Aby vse spravne fungovalo, je mozno pouzit jeden dvou pristupu:</p>
 * <ul>
 *   <li>Manazer bude obsah platna prekreslovat
 *       <b>v pravidelnych intervalech</b>
 *       bez ohledu na to, jestli se na nem udala nejaka zmena ci ne.
 *       <ul><li>
 *       <b>Vyhodou</b> tohoto pristupu je, ze se zobrazovane objekty
 *       nemusi starat o to, aby se manazer dozvedel, ze se jejich stav zmenil.
 *       </li><li>
 *       <b>Neyhodou</b> tohoto pristupu je naopak to, ze manazer
 *       spotrebovava na neustale prekreslovani jistou cast vykonu
 *       procesoru, coz muze u pomalejsich pocitacu pusobit problemy.
 *       <br>&nbsp;</li></ul></li>
 *   <li>Manazer prekresluje platno <b>pouze na vyslovne pozadani</b>.
 *       <ul><li>
 *       <b>Vyhodou</b> tohoto pristupu je uspora spotrebovaneho vykonu
 *       pocitace v obdobi, kdy se na platne nic nedeje.
 *       </li><li>
 *       <b>Nevyhodou</b> tohoto pristupu je naopak to, ze kreslene
 *       objekty musi na kazdou zmenu sveho stavu upozornit manazera,
 *       aby vedel, zed ma platno prekreslit.
 *   </li>
 * </ul><p>
 * Trida <code>AktivniPlatno</code> poziva druhou z uvedenych strategii,
 * tj. <b>prekresluje platno pouze na pozadani</b>.
 * </p><p>
 * Obrazec, ktery chce byt zobrazovan na platne, se musi nejprve prihlasit
 * u instance tridy <code>AktivniPlatno</code>, aby jej tato zaradila
 * mezi spravovane obrazce (sada metod <code>pridej&hellip;</code>).
 * Prihlasit se vsak mohou pouze instance trid, ktere implementuji
 * rozhrani <code>IKresleny</code>.
 * </p><p>
 * Neprihlaseny obrazec nema sanci byti zobrazen, protoze na platno
 * se muze zobrazit pouze za pomoci kreslitka, jez muze ziskat jedine od
 * instance tridy <code>AktivniPlatno</code>, ale ta je poskytuje pouze
 * instancim, ktere se prihlasily do jeji spravy.
 * </p><p>
 * Obrazec, ktery jiz dale nema byt kreslen, se muze odhlasit zavolanim
 * metody <code>odstran(IKresleny)</code>.Zavolanim metody
 * <code>odstranVse()</code> se ze seznamu spravovanych (a tim i z platna)
 * odstrani vsechny vykreslovane obrazce.
 * </p><p>
 * Efektivitu vykreslovani je mozne ovlivnit volanim metody
 * <code>nekresli()</code>, ktera pozastavi prekreslovani platna po nahlasenych
 * zmenach. Jeji volani je vyhodne napr. v situaci, kdy je treba vykreslit
 * obrazec slozeny z rady mensich obrazcu a bylo by nevhodne prekreslovat
 * platno po vykresleni kazdeho z nich.
 * </p><p>
 * Do puvodniho stavu prevedeme platno volanim metody <code>vratKresli()</code>,
 * ktera vrati vykreslovani do stavu pred poslednim volanim metody
 * <code>nekresli()</code>. Nemuzec se tedy stat, ze by se pri zavolani metody
 * <code>nekresli()</code> v situaci, kdy je jiz vykreslovani pozastaveno,
 * zacalo po nasledem zavolani <code>vratKresli()</code> hned vykreslovat.
 * Po dvou volanich <code>vratKresli()</code> se zacne vykreslovat az po
 * dvou zavolanich <code>vratKresli()</code>.
 * </p><p>
 * Proto platno pouze zadame, aby se vratilo do toho kresliciho stavu,
 * ve kterem bylo v okamziku, kdy jsme je naposledy zadali o to,
 * aby se prestalo prekreslovat. Nemuze se tedy stat, ze by se pri zavolani
 * metody <code>nekresli()</code> v situaci, kdy je jiz vykreslovani
 * pozastaveno, zacalo po naslednem zavolani <code>vratKresli()</code> hned
 * vykreslovat.
 * </p><p>
 * Kazde zavolani metody <code>nekresli()</code> musi byt doplneno
 * odpovidajicim volanim <code>vratKresli()</code>. Teprve kdyz posledni
 * <code>vratKresli()</code> odvola prvni <code>nekresli()</code>, bude
 * prekreslovani opet obnoveno.
 * </p>
 *
 * @author     Rudolf Pecinovsky
 * @version    2.01, 22.02.2004
 */
public class AktivniPlatno
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Pocatecni sirka aktivni plochy platna v bodech. */
    public static final int SIRKA_0 = 6;

    /** Pocatecni vyska aktivni plochy platna v bodech. */
    public static final int VYSKA_0 = 6;

    /** Pocatecni barva pozadi platna. */
    public static final Barva POZADI_0 = Barva.KREMOVA;

    /** Pocatecni barva car mrizky. */
    public static final Barva BARVA_CAR_0 = Barva.CERNA;

    /** Implicitni roztec ctvercove site. */
    private static final int KROK_0 = 50;

    /** Maximalni povolena velikost roztece ctvercove site. */
    private static final int MAX_KROK = 200;

    /** Jedina instance tridy AktivniPlatno */
    private static final AktivniPlatno jedinacek = new AktivniPlatno();

    //Pri kresleni car se pta APosuvny po aktivnim platnu.
    //Proto se mohou cary kreslit az pote, co bude jedinacek inicializovan
    static 
    {
        //Pripravi a vykresli prazdne platno
        jedinacek.setRozmer(SIRKA_0, VYSKA_0);
    }



//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

        /** Aplikacni okno animacniho platna. */
        private final JFrame okno;

        /** Instance lokalni tridy, ktera je zrizena proto, aby odstinila
         *  metody sveho rodice JPanel. */
        private final JPanel vlastniPlatno;
        
        
//== PROMENNE ATRIBUTY INSTANCI ================================================

    //Z venku neovlivnitelne Atributy pro zobrazeni platna v aplikacnim okne

        /** Vse se kresli na obraz - ten se snadneji prekresli. */
        private Image obrazPlatna;

        /** Kreslitko ziskane od obrazu platna, na nejz se vlastne kresli. */
        private Kreslitko kreslitko;

        /** Semafor branici prilis castemu prekreslovani. Prekresluje se pouze
         *  je-li ==0. Nesmi byt <0. */
        private int nekreslit = 0;

        /** Priznak toho, ze v dobe zakazaneho kresleni prisel pozadavek
         *  na prekresleni platna */
        private boolean kreslit = false;

        /** Priznak toho, ze kresleni prave probiha,
         *  takze vypinani nefunguje. */
        private boolean kreslim = false;

        /** Cary zobrazujici na plante mrizku. */
        private Cara[] vodorovna,   svisla;

    //Primo ovlivnitelne atributy

        /** Roztec ctvercove site. */
        private int krok = KROK_0;

        /** Zobrazuje-li se mrizka. */
        private boolean mrizka = true;

        /** Barva pozadi platna. */
        private Barva barvaPozadi = POZADI_0;

        /** Barva car mrizky. */
        private Barva barvaCar = BARVA_CAR_0;

        /** Sirka aktivni plochy platna v bodech. */
        private int sirka = SIRKA_0;

        /** Vyska aktivni plochy platna v bodech. */
        private int vyska = VYSKA_0;


        /** Sirka aktivni plochy platna v bodech. */
        private int sirkaBodu = SIRKA_0 * krok;

        /** Vyska aktivni plochy platna v bodech. */
        private int vyskaBodu = VYSKA_0 * krok;

        /** Seznam zobrazovanych predmetu. */
        List<IKresleny> predmety = new LinkedList<IKresleny>();

        /** Nazev v titulkove liste animacniho platna. */
        private String nazev  = "Animacni platno";


//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori instanci tridy - je volana pouze jednou.
     */
    private AktivniPlatno()
    {
        okno  = new JFrame();          //Vytvori nove aplikacni okno
        okno.setTitle(nazev);
        okno.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        okno.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
        //Vlastni platno je definovano jako lokalni trida
        vlastniPlatno = new JPanel()
        {
            /** Povinne prekryvana abstraktni metoda tridy JPanel. */
            public void paint( Graphics g )
            {
                synchronized( obrazPlatna )
                {
                    g.drawImage( obrazPlatna, 0, 0, null );
                }
            }

        };//Konec definice tridy vlastniPlatno
        okno.setContentPane(vlastniPlatno);
    }


    /***************************************************************************
     * Jedina metoda umoznujici ziskat odkaz na instanci platna.
     * Vraci vsak pokazde odkaz na stejnou instanci,
     * protoze instance platna je jedinacek.
     * <p>
     * Pokud instance pri volani metody jeste neexistuje,
     * metoda instanci vytvori.</p>
     *
     * @return Instance tridy AktivniPlatno
     */
    public static AktivniPlatno getPlatno()
    {
        return jedinacek;
    }



//== PRISTUPOVE METODY ATRIBUTU INSTANCI =======================================

    /***************************************************************************
     * Nastavi rozmer platna zadanim bodove velikosti policka a
     * poctu policek ve vodorovnem a svislem smeru.
     * Pri velikosti policka = 1 se vypina zobrazovani mrizky.
     *
     * @param  krok   Nova bodova velikost policka
     * @param  sirka  Novy pocet policek vodorovne
     * @param  vyska  Novy pocet policek svisle
     */
    public synchronized void setKrokRozmer( int krok, int sirka, int vyska )
    {
        sirkaBodu = sirka * krok;
        vyskaBodu = vyska * krok;

        Dimension obrazovka = Toolkit.getDefaultToolkit().getScreenSize();
        if( (krok  < 1)  ||
            (sirka < 2)  ||  (obrazovka.width  < sirkaBodu) ||
            (vyska < 2)  ||  (obrazovka.height < vyskaBodu) )
        {
            throw new IllegalArgumentException(
                "\nSpatne zadane rozmery: krok=" + krok +
                " bodu, sirka="  + sirka + "(" + sirka*krok +
                " bodu), vyska=" + vyska + "(" + vyska*krok +
                " bodu), obrazovka=" + obrazovka.width  + "\u00d7" +
                                       obrazovka.height + " bodu" );
        }
        this.krok  = krok;
        this.sirka = sirka;
        this.vyska = vyska;

        okno.setResizable( true );
        vlastniPlatno.setPreferredSize( new Dimension( sirkaBodu, vyskaBodu ) );
        okno.pack();
        okno.setResizable( false );

        obrazPlatna = vlastniPlatno.createImage( sirkaBodu, vyskaBodu );
        kreslitko = new Kreslitko( (Graphics2D)obrazPlatna.getGraphics() );
        kreslitko.setPozadi( barvaPozadi );

        if( krok > 1 )
        {
            svisla    = new Cara[ sirka ];
            vodorovna = new Cara[ vyska ];
            for( int i=0, x=krok;   i < sirka;      i++, x+=krok )
                svisla[i]    = new Cara( x, 0, x, vyskaBodu, barvaCar );
            for( int i=0, y=krok;   i < vyska;   i++, y+=krok )
                vodorovna[i] = new Cara( 0, y, sirkaBodu, y, barvaCar );
        }
        else
        {
            //Uvolneni doposud pouzivanych instanci
            svisla = null;
            vodorovna = null;
            mrizka = false;
        }

        okno.setVisible(true);
        prekresli();
        okno.toFront();
    }


    /***************************************************************************
     * Vrati vzdalenost car mrizky = bodovou velikost policka.
     *
     * @return Bodova velikost policka
     */
     public synchronized int getKrok()
     {
         return krok;
     }


    /***************************************************************************
     * Nastavi vzdalenost car mrizky = bodovou velikost policka.
     * Pri velikosti policka = 1 se vypina zobrazovani mrizky.
     *
     * @param velikost  Nova bodova velikost policka
     */
    public synchronized void setKrok( int velikost )
    {
        setKrokRozmer( velikost, sirka, vyska );
    }


    /***************************************************************************
     * Vrati polickovou sirku platna.
     *
     * @return  Aktualni polickova sirka platna (pocet policek vodorovne)
     */
    public synchronized int getSirka()
    {
        return sirka;
    }


    /***************************************************************************
     * Vrati bodovou sirku platna.
     *
     * @return  Aktualni bodova sirka platna (pocet bodu vodorovne)
     */
    public synchronized int getBsirka()
    {
        return sirkaBodu;
    }


    /***************************************************************************
     * Vrati polickovou vysku platna.
     *
     * @return  Aktualni polickova vyska platna (pocet policek svisle)
     */
    public synchronized int getVyska()
    {
        return vyska;
    }


    /***************************************************************************
     * Vrati bodovou vysku platna.
     *
     * @return  Aktualni bodova vyska platna (pocet bodu svisle)
     */
    public synchronized int getBVyska()
    {
        return vyskaBodu;
    }


    /***************************************************************************
     * Nastavi rozmer platna zadanim jeho polickove vysky a sirky.
     *
     * @param  sirka  Novy pocet policek vodorovne
     * @param  vyska  Novy pocet policek svisle
     */
    public synchronized void setRozmer(int sirka, int vyska)
    {
        setKrokRozmer( krok, sirka, vyska );
    }


    /***************************************************************************
     * Nastavi rozmer platna zadanim jeho polickove vysky a sirky.
     *
     * @param  rozmer  Zadavany rozmer v poctu policek
     */
    public synchronized void setRozmer(Rozmer rozmer)
    {
        setRozmer( rozmer.sirka, rozmer.vyska );
    }


    /***************************************************************************
     * Vrati informaci o tom, je-li zobrazovana mrizka.
     *
     * @return Mrizka je zobrazovana = true, neni zobrazovana = false.
     */
    public synchronized boolean getMrizka()
    {
    	return mrizka;
    }


    /***************************************************************************
     * V zavislosti na hodnte parametru nastavi nebo potlaci
     * zobrazovani car mrizky.
     *
     * @param zobrazit  Jestli mrizku zobrazovat.
     */
    public synchronized void setMrizka( boolean zobrazit )
    {
        mrizka = zobrazit;
        prekresli();
    }


    /***************************************************************************
     * Poskytuje informaci o aktualni viditelnosti okna.
     *
     * @return Je-li okno viditelne, vraci <b>true</b>, jinak vraci <b>false</b>
     */
    public synchronized boolean isViditelne()
    {
        return okno.isVisible();
    }


    /***************************************************************************
     * V zavislosti na hodnte parametru nastavi nebo potlaci viditelnost platna.
     *
     * @param viditelne logicka hodnota pozadovane viditelnost (true=viditelne)
     */
    public synchronized void setViditelne(boolean viditelne)
    {
        boolean zmena = (isViditelne() != viditelne);
        if( zmena )
        {
            okno.setVisible(viditelne);
            if( viditelne )
            {
                okno.toFront();
                prekresli();
            }
        }
    }


    /***************************************************************************
     * Vrati aktualni barvu pozadi.
     *
     * @return  Nastavena barva pozadi
     */
    public synchronized Barva getBarvaPozadi()
    {
        return barvaPozadi;
    }


    /***************************************************************************
     * Nastavi pro platno barvu pozadi.
     *
     * @param  barva  Nastavovana barva pozadi
     */
    public synchronized void setBarvaPozadi(Barva barva)
    {
        barvaPozadi = barva;
        kreslitko.setPozadi( barvaPozadi );
        prekresli();
    }


    /***************************************************************************
     * Pomocna metoda pro ucely ladeni aby bylo mozno zkontrolovat,
     * ze na konci metody ma semafor stejnou hodnotu, jako mel na pocatku.
     *
     * @return  Stav vnitrniho semaforu: >0  - nebude se kreslit,<br>
     *                                   ==0 - kresli se,<br>
     *                                   <0  - chyba
     */
    public synchronized int getNekresli()
    {
        return nekreslit;
    }

    
    /***************************************************************************
     * Nastavi nazev v titulkove liste okna platna.
     *
     * @param nazev  Nastavovany nazev
     */
    public void setNazev( String nazev )
    {
        okno.setTitle( this.nazev = nazev );
    }
    
    
    /***************************************************************************
     * Vrati aktualni nazev v titulkove liste okna platna.
     *
     * @return  Aktualni nazev okna
     */
    public String getNazev()
    {
        return okno.getTitle();
    }


//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================

    /***************************************************************************
     * Prevede instanci na retezec. Pouziva se predevsim pri ladeni.
     *
     * @return Retezcova reprezentace dane instance.
     */
    public String toString()
    {
        return getClass().getName() + "(sirka=" + sirka + ",vyska=" + vyska +
               ", krok=" + krok + ", pozadi=" + barvaPozadi + ")";
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Vykresli vsechny elementy.
     */
    public synchronized void prekresli()
    {
        if( kreslim )   //Prave prekresluji - volam neprimo sam sebe
            return;
        if( (nekreslit == 0)  &&  isViditelne() )   //Mam kreslit a je proc
        {
            kreslim = true;
            synchronized( obrazPlatna )
            {
                kreslitko.vyplnRam( 0, 0, sirkaBodu, vyskaBodu, barvaPozadi );
                if( mrizka  &&  (barvaCar != barvaPozadi) )
                {
                    for( int i=0;   i < sirka;   )
                        svisla[i++].nakresli( kreslitko );
                    for( int i=0;   i < vyska;   )
                        vodorovna[i++].nakresli( kreslitko ) ;
                }
                ListIterator it = predmety.listIterator();
                while(it.hasNext()) {
                    ((IKresleny)it.next()).nakresli( kreslitko );
                }
            }//synchronized( obrazPlatna )
            vlastniPlatno.repaint();
            kreslit = false;    //Vse, co se melo prekreslit, bylo prekresleno
            kreslim = false;
        }
        else
            kreslit = true;     //Nevyhoveli jsme zadosti o prekresleni
    }


    /***************************************************************************
     * Potlaci prekreslovani platna, presneji zvysi hladinu potlaceni
     * prekreslovani o jednicku. Navratu do stavu pred volanim teto metody
     * se dosahne zavolanim metody <code>vratKresli()</code>.</p>
     * <p>
     * Metody <code>nekresli()</code> a <code>vratKresli()</code>
     * se tak chovaji obdobne jako zavorky, mezi nimiz je vykreslovani
     * potlaceno.</p>
     */
    public synchronized void nekresli()
    {
        nekreslit++;
    }


    /***************************************************************************
     * Vrati prekreslovani do stavu pred poslednim volanim metody
     * <code>nekresli()</code>. Predchazelo-li proto vice volani metody
     * <code>nekresli()</code>, zacne se prekreslovat az po odpovidajim poctu
     * zavolani metody <code>vratKresli()</code>.
     *
     * @throws IllegalStateException
     *         Je-li metoda volana aniz by predchazelo odpovidajici volani
     *         <code>nekresli()</code>.
     */
    public synchronized void vratKresli()
    {
        if( nekreslit == 0 )
            throw new IllegalStateException(
                "Vraceni do stavu kresleni musi prechazet zakaz!" );
        nekreslit--;
        if( nekreslit == 0 )
            prekresli();
    }


    /***************************************************************************
     * Odstrani zadany obrazec ze seznamu malovanych.
     * Byl-li obrazec v seznamu, prekresli vlastniPlatno.
     *
     * @param obrazec  Odstranovany obrazec
     *
     * @return  true v pripade, kdyz obrazec v seznamu byl,
     *          false v pripade, kdyz nebylo co odstranovat
     */
    public synchronized boolean odstran(IKresleny obrazec)
    {
        boolean ret = predmety.remove(obrazec);
        if(ret) prekresli();
        return ret;
    }


    /***************************************************************************
     * Vycisti platno, tj. vyprazdni seznam malovanych
     * (odstrani z nej vsechny obrazce).
     */
    public synchronized void odstranVse()
    {
        //nekresli();
        ListIterator it = predmety.listIterator();
        while( it.hasNext() ) {
            it.next();
            it.remove();
        }
        prekresli();
        //vratKresli();
    }


    /***************************************************************************
     * Neni-li zadany obrazec v seznamu malovanych, prida jej na konec
     * (bude se kreslit jako posledni, tj. na vrchu.
     * Byl-li obrazec opravdu pridan, prekresli platno.
     *
     * @param  obrazec  Pridavany obrazec
     *
     * @return  true  v pripade, kdyz byl obrazec opravdu pridan,
     *          false v pripade, kdyz jiz mezi zobrazovanymi byl
     *                a pouze se presunul do jine urovne
     */
    public synchronized boolean pridej(IKresleny obrazec)
    {
        if( predmety.contains(obrazec) )
        {
            return false;
        }
        else
        {
            predmety.add(obrazec);
            prekresli();
            return true;
        }
    }


    /***************************************************************************
     * Prida obrazec do seznamu malovanych tak, aby byl kreslen
     * nad zadanym obrazcem.
     * Pokud jiz v seznamu byl, jenom jej presune do zadane pozice.
     *
     * @param  soucasny  Obrazec, ktery ma byt pri kresleni pod
     *                    pridavanym obrazcem
     * @param  pridany   Pridavany obrazec
     *
     * @return  true  v pripade, kdyz byl obrazec opravdu pridan,
     *          false v pripade, kdyz jiz mezi zobrazovanymi byl
     *                a pouze se presunul do jine urovne
     */
    public synchronized boolean pridejNad(IKresleny soucasny, IKresleny pridany )
    {
        boolean nebyl = ! predmety.remove(pridany);
        int kam = predmety.indexOf( soucasny );
        if( kam < 0 )
        {
            throw new IllegalArgumentException(
                "Referencni objekt neni na platne zobrazovan!" );
        }
        predmety.add( kam+1, pridany );
        prekresli();
        return nebyl;
    }


    /***************************************************************************
     * Prida obrazec do seznamu malovanych tak, aby byl kreslen
     * pod zadanym obrazcem.
     * Pokud jiz v seznamu byl, jenom jej presune do zadane pozice.
     *
     * @param  soucasny  Obrazec, ktery ma byt pri kresleni nad
     *                   pridavanym obrazcem
     * @param  pridany   Pridavany obrazec
     *
     * @return  true  v pripade, kdyz byl obrazec opravdu pridan,
     *          false v pripade, kdyz jiz mezi zobrazovanymi byl
     *                a pouze se presunul do jine urovne
     */
    public synchronized boolean pridejPod(IKresleny soucasny, IKresleny pridany)
    {
        boolean nebyl = ! predmety.remove(pridany);
        int kam = predmety.indexOf( soucasny );
        if( kam < 0 )
        {
            throw new IllegalArgumentException(
                "Referencni objekt neni na platne zobrazovan!" );
        }
        predmety.add( kam, pridany );
        prekresli();
        return nebyl;
    }


    /***************************************************************************
     * Prida obrazec do seznamu malovanych tak, aby byl kreslen
     * nad vsemi obrazci.
     * Pokud jiz v seznamu byl, jenom jej presune do pozadovane pozice.
     *
     * @param  pridany   Pridavany obrazec
     *
     * @return  true  v pripade, kdyz byl obrazec opravdu pridan,
     *          false v pripade, kdyz jiz mezi zobrazovanymi byl
     *                a pouze se presunul do jine urovne
     */
    public synchronized boolean pridejNavrch( IKresleny pridany)
    {
        boolean nebyl = ! predmety.remove(pridany);
        predmety.add( pridany );
        prekresli();
        return nebyl;
    }


    /***************************************************************************
     * Prida obrazec do seznamu malovanych tak, aby byl kreslen
     * pod zadanym obrazcem.
     * Pokud jiz v seznamu byl, jenom jej presune do zadane pozice.
     *
     * @param  pridany   Pridavany obrazec
     *
     * @return  true  v pripade, kdyz byl obrazec opravdu pridan,
     *          false v pripade, kdyz jiz mezi zobrazovanymi byl
     *                a pouze se presunul do jine urovne
     */
    public synchronized boolean pridejDospod( IKresleny pridany)
    {
        boolean nebyl = ! predmety.remove(pridany);
        predmety.add( 0, pridany );
        prekresli();
        return nebyl;
    }


    /***************************************************************************
     * Vrati poradi zadaneho prvku v seznamu kreslenych prvku.
     * Prvky se pritom kresli v rostoucim poradi, takze obrazec
     * s vetsim poradim je kreslen nad obrazcem s mensim poradim.
     * Neni-li zadany obrazec mezi kreslenymi, vrati -1.
     *
     * @param  obrazec  Objekt, na jehoz kreslici poradi se dotazujeme
     *
     * @return  Poradi obrazce; prvy kresleny obrazec ma poradi 0.
     *           Neni-li zadany obrazec mezi kreslenymi, vrati -1.
     */
    public synchronized int poradi(IKresleny obrazec)
    {
        return predmety.indexOf( obrazec );
    }


    /***************************************************************************
     * Vrati retezec s nazvy vsech spravovanych obrazku.
     *
     * @return  pozadovany retezec
     */
    public String nazvyKreslenych()
    {
        int i = 0;
        StringBuffer sb = new StringBuffer();
        ListIterator ii=predmety.listIterator(predmety.size()-1);
        ii.next();
        while( ii.hasPrevious() )
        {
            IKresleny ik = (IKresleny)(ii.previous());
            sb.append(i++).append(". ").append(ik).append('\n');
        }
        return sb.toString();
    }


    /***************************************************************************
     * Vrati nemodifikovatelny seznam vsech spravovanych obrazku.
     *
     * @return  Pozadovany seznam
     */
    public List seznamKreslenych()
    {
        return Collections.unmodifiableList( predmety );
    }


    /***************************************************************************
     * Prihlasi posluchace udalosti klavesnice.
     */
    public void prihlasKlavesnici( KeyListener posluchac )
    {
        okno.addKeyListener( posluchac );
    }


    /***************************************************************************
     * Odhlasi posluchace klavesnice.
     */
    public void odhlasKlavesnici( KeyListener posluchac )
    {
        okno.removeKeyListener( posluchac );
    }


    /***************************************************************************
     * Prihlasi posluchace udalosti mysi.
     */
    public void prihlasMys( MouseListener posluchac )
    {
        okno.addMouseListener( posluchac );
    }



    /***************************************************************************
     * Odhlasi posluchace mysi.
     */
    public void odhlasMys( MouseListener posluchac )
    {
        okno.removeMouseListener( posluchac );
    }



//== SOUKROME A POMOCNE METODY =================================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

