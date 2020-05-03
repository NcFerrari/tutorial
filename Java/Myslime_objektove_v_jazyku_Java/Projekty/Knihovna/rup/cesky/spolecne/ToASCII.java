package rup.cesky.spolecne;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.Enumeration;
import java.util.Properties;


//==============================================================================
/*******************************************************************************
 * Trida slouzi k prevodu znaku a retezcu do zankove sady ASCII.
 * Jinymi slovy: slouzi k odstranene diakritiy.
 *
 * @author    Rudolf Pecinovsky
 * @version   1.00.000,  18.2.2005
 */
public final class ToASCII
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY ATRIBUTU TRIDY ==========================================
//== OSTATNI METODY TRIDY ======================================================
    
    /***************************************************************************
     * Zkonvertuje zadany retezec na jeho ekvivalent, ktery nebude obsahovat
     * znaky s diakritikou. Provadi pouze konverzi znak na znak.
     * Nezabyva se tedy moznosti, ze by se nektere znaky mely konvertovat na
     * nekolik znaku (napr. oe -> oe).
     *
     * @param s retezec urceny ke konverzi
     * @return zkonvertovany retezec
     */
    public static String string(String s)
    {
        char[] zz = new char[ s.length() ];
        char   z;
        
        for( int i=0;   i < zz.length;   i++ )
        {
            zz[i] = ((z = s.charAt(i)) > 0x7F)  ?  znak(z)  :  z;
        }
        return new String( zz );
    }
    
    
    /***************************************************************************
     * Konvertuje zadany znak na jeho ekvivalent bez diakritky.
     * Provadi pouze konverzi znak na znak. Nezabyva se tedy moznosti,
     * ze by se nektere znaky mely konvertovat na nekolik znaku
     * (napr. nemecke oe -> oe).
     *
     * @param c konvertovany znak
     * @return ekvivalent zadaneho znaku bez diakritiky
     */
    public static char znak( char c )
    {
        if( (0 <= c)  &&  (c <= 0x7F) )   return c;  //==========>
        switch( c )
        {
            case 0x0C1:   c = 'A';   break;   //'A'
            case 0x0C4:   c = 'A';   break;   //'AE'
            case 0x0C9:   c = 'E';   break;   //'E'
            case 0x0CD:   c = 'I';   break;   //'I'
            case 0x0D3:   c = 'O';   break;   //'O'
            case 0x0D4:   c = 'O';   break;   //'O'
            case 0x0D6:   c = 'O';   break;   //'OE'
            case 0x0D7:   c = 'x';   break;   //'\u00d7' - nasobitko
            case 0x0DA:   c = 'U';   break;   //'U'
            case 0x0DC:   c = 'U';   break;   //'UE'
            case 0x0DD:   c = 'Y';   break;   //'Y'
            case 0x0E1:   c = 'a';   break;   //'a'
            case 0x0E4:   c = 'a';   break;   //'ae'
            case 0x0E9:   c = 'e';   break;   //'e'
            case 0x0ED:   c = 'i';   break;   //'i'
            case 0x0F3:   c = 'o';   break;   //'o'
            case 0x0F4:   c = 'o';   break;   //'o'
            case 0x0F6:   c = 'o';   break;   //'oe'
            case 0x0F7:   c = ':';   break;   //'\u00f7' - delitko
            case 0x0FA:   c = 'u';   break;   //'u'
            case 0x0FC:   c = 'u';   break;   //'ue'
            case 0x0FD:   c = 'y';   break;   //'y'
            case 0x10C:   c = 'C';   break;   //'C'
            case 0x10D:   c = 'c';   break;   //'c'
            case 0x10E:   c = 'D';   break;   //'D'
            case 0x10F:   c = 'd';   break;   //'d'
            case 0x11A:   c = 'E';   break;   //'E'
            case 0x11B:   c = 'e';   break;   //'e'
            case 0x139:   c = 'L';   break;   //'L'
            case 0x13A:   c = 'l';   break;   //'l'
            case 0x13D:   c = 'L';   break;   //'L'
            case 0x13E:   c = 'l';   break;   //'l'
            case 0x147:   c = 'N';   break;   //'N'
            case 0x148:   c = 'n';   break;   //'n'
            case 0x154:   c = 'R';   break;   //'R'
            case 0x155:   c = 'r';   break;   //'r'
            case 0x158:   c = 'R';   break;   //'R'
            case 0x159:   c = 'r';   break;   //'r'
            case 0x160:   c = 'S';   break;   //'S'
            case 0x161:   c = 's';   break;   //'s'
            case 0x164:   c = 'T';   break;   //'T'
            case 0x165:   c = 't';   break;   //'t'
            case 0x16E:   c = 'U';   break;   //'U'
            case 0x16F:   c = 'u';   break;   //'u'
            case 0x17D:   c = 'Z';   break;   //'Z'
            case 0x17E:   c = 'z';   break;   //'z'
            default:      c = '%';
        }
        return c;
    }
    
    

//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * Trida je knihovni e nama proto instance.
     */
    private ToASCII() {}

    
    
//== PRISTUPOVE METODY ATRIBUTU INSTANCI =======================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
//+ main
    public static void main( String[] args ) throws IOException
    {
        String mala  = "Priserne zlutoucky kun upel dabelske ody.";
        String velka = "PRISERNE ZLUTOUCKY KUN UPEL DABELSKE ODY.";
        
        System.out.println( string(mala) );
        System.out.println( string(velka));
    }
//- main
}
