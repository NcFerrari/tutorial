/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regularnivyrazy;

/**
 *
 * @author NcFerrari
 */
public class RegularniVyrazy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // \\d+ -> vrátí true pouze, pokud je v řetězci KLADNÉ číslo
        String ciselnyRetezec = "321,44,11,-46,fklsdaj,446";

        String[] pole = ciselnyRetezec.split(",");
        for (String cislo : pole) {
            if (!cislo.matches("\\d+")) {
                continue;
            }
            System.out.println(cislo);
        }
    }

}
