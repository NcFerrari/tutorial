/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Pøíliš luouèkı kùò úpìl ïábelské ódy. */
package lp.cesky.priklady;





/*******************************************************************************
 * Instance rozhraní {@code IZastavka} pøedstavují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public interface IZastavka
{
    //== VEØEJNÉ KONSTANTY =====================================================
    //== DEKLAROVANÉ METODY ====================================================
    //== ZDÌDÌNÉ METODY ========================================================
    //== INTERNÍ DATOVÉ TYPY ===================================================
    
    Linka getLinka();
    
    int getX();
    
    int getY();
    
    IZastavka getDalsiZastavka();
    
    IZastavka getPredchoziZastavka();
}
