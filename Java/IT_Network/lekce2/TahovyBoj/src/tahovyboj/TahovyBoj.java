/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahovyboj;

/**
 *
 * @author NcFerrari
 */
public class TahovyBoj {

    public static void main(String[] args) {
        Kostka kostka = new Kostka();
        Bojovnik lubor = new Bojovnik("Lubor", 100, 20, 10);
        lubor.setKostka(kostka);
        System.out.println(lubor);
        Bojovnik magda = new Bojovnik("Magda", 150, 30, 80);
        magda.setKostka(kostka);
        magda.utoc(lubor);
        System.out.println(magda.getZprava());
        System.out.println(lubor.getZprava());

        System.out.println(lubor);
    }
}
