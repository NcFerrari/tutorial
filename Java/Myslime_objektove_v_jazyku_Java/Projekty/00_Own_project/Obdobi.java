/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */




/*******************************************************************************
 * Instance v��tov�ho typu {@code Obdobi} p�edstavuj� ...
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public enum Obdobi
{
    //== HODNOTY V��TOV�HO TYPU ================================================
    
    ////=====  N�POV�DA: KONSTRUKTOR BEZ PARAMETR�  ==============
    JARO ("pu��"),
    LETO ("zraje"),
    PODZIM ("plod�"),
    ZIMA ("sp�");
    //
    ////=====  N�POV�DA: KONSTRUKTOR S PARAMETRY  ================
    //     JARO(par), LETO(par), PODZIM(par), ZIMA(par);
    
    
    //== KONSTANTN� ATRIBUTY T��DY =============================================
    //== PROM�NN� ATRIBUTY T��DY ===============================================
    //== STATICK� INICIALIZA�N� BLOK - STATICK� KONSTRUKTOR ====================
    //== KONSTANTN� ATRIBUTY INSTANC� ==========================================
    private final String cinnost;
    //== PROM�NN� ATRIBUTY INSTANC� ============================================
    //== P��STUPOV� METODY VLASTNOST� T��DY ====================================
    //== OSTATN� NESOUKROM� METODY T��DY =======================================
    
    //##########################################################################
    //== KONSTRUKTORY A TOV�RN� METODY =========================================

    /***************************************************************************
     *
     */
    private Obdobi(String text) {
        cinnost = text;
    }

    public String zprava() {
        return "Je " + name().toLowerCase() + ", p��roda " + cinnost + ".";
    }

    //== ABSTRAKTN� METODY =====================================================
    //== P��STUPOV� METODY VLASTNOST� INSTANC� =================================
    //== OSTATN� NESOUKROM� METODY INSTANC� ====================================
    //== SOUKROM� A POMOCN� METODY T��DY =======================================
    //== SOUKROM� A POMOCN� METODY INSTANC� ====================================
    //== INTERN� DATOV� TYPY ===================================================
    //== TESTOVAC� METODY A T��DY ==============================================
    //
    //     /********************************************************************
    //      * Testovac� metoda.
    //      */
    //     public static void test()
    //     {
    //     }
    //     /** @param args Parametry p��kazov�ho ��dku - nepou��van�. */
    //     public static void main(String[] args)  {  test();  }
}
