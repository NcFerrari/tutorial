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
        Kostka kostka = new Kostka(10);
        Bojovnik lubor = new Bojovnik("Lubor", 100, 20, 10, kostka);
        Bojovnik magda = new Bojovnik("Magda", 60, 18, 15, kostka);
        Arena arena = new Arena(lubor, magda, kostka);
        arena.zapas();
    }
}
