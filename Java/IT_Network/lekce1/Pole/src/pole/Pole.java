/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pole;

/**
 *
 * @author NcFerrari
 */
public class Pole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] pole = new int[10];
        pole[0] = 1;
        for (int i = 1; i <= 10; i++) {
            pole[i - 1] = i;
        }

        for (int a : pole) {
            System.out.println(a);
        }

        String[] simpsonovi = {"Homer", "Marge", "Bart", "Lisa", "Maggie"};
        for (String simpson : simpsonovi) {
            System.out.println(simpson);
        }
    }

}
