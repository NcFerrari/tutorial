/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retezce;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class Retezce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        final char[] samohlasky = {'a', 'e', 'i', 'o', 'u', 'y', 'á', 'é', 'ě', 'í', 'ó', 'ú', 'ů', 'ý'};
        final char[] souhlasky = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z', 'č', 'ď', 'ň', 'ř', 'š', 'ť', 'ž'};
        Arrays.sort(samohlasky);
        Arrays.sort(souhlasky);

        int pocetSamohlasek = 0;
        int pocetSouhlasek = 0;
        int pocetOstatnichZnaku = 0;
        String s = "Programátor se zasekne ve sprše, protože instrukce na šampónu byly: Namydlit, omýt, opakovat.";

        for (char letter : s.toLowerCase().toCharArray()) {
            if (Arrays.binarySearch(samohlasky, letter) >= 0) {
                pocetSamohlasek++;
            } else if (Arrays.binarySearch(souhlasky, letter) >= 0) {
                pocetSouhlasek++;
            } else {
                pocetOstatnichZnaku++;
            }
        }

        System.out.println(s);
        System.out.printf("Počet samohlásek: %d\nPočet souhlasek: %d\nPočet ostatních znaků: %d\n", pocetSamohlasek, pocetSouhlasek, pocetOstatnichZnaku);
    }

}
