

/*******************************************************************************
 * Trida START slouzi ke spousteni aplikace ...
 *
 * @author    jmeno autora
 * @version   0.00.000
 */
public class START
{
    public static void main( String [] args )
    {
        Dispecer dispecer = Dispecer.getDispecer();
        dispecer.pouzijUFO_3a();
        javax.swing.JOptionPane.showMessageDialog( null,
            "Klepnete na okno aplikace, \nstiskem Enter pristavte UFO\n" +
            "a pomoci stisku kurzorovych klaves\nje doprovodte na rampu." );
    }
}



