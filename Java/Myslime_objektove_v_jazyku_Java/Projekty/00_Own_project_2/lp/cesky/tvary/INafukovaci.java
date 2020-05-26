package lp.cesky.tvary;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */




/*******************************************************************************
 * Instance rozhran� {@code INafukovaci} p�edstavuj� ...
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public interface INafukovaci
{
    //== VE�EJN� KONSTANTY =====================================================
    //== DEKLAROVAN� METODY ====================================================
    int getSirka();
    
    int getVyska();
    
    void setRozmer(int sirka, int vyska);
    
    int getX();
    
    int getY();
    
    void setPozice(int x, int y);
    //== ZD�D�N� METODY ========================================================
    //== INTERN� DATOV� TYPY ===================================================
}
