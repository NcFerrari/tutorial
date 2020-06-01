/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */
package lp.cesky.priklady;





/*******************************************************************************
 * Instance rozhran� {@code IZastavka} p�edstavuj� ...
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public interface IZastavka
{
    //== VE�EJN� KONSTANTY =====================================================
    //== DEKLAROVAN� METODY ====================================================
    //== ZD�D�N� METODY ========================================================
    //== INTERN� DATOV� TYPY ===================================================
    
    Linka getLinka();
    
    int getX();
    
    int getY();
    
    IZastavka getDalsiZastavka();
    
    IZastavka getPredchoziZastavka();
}
