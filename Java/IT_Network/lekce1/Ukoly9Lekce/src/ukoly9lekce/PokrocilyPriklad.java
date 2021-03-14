/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly9lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class PokrocilyPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        String[] smiles = {":)", ":D", ":P"};
        int index = 0;

        System.out.println("Zadej text k rozveselení:");
        char[] input = scanner.nextLine().trim().toCharArray();

        String result = "";
        for (char c : input) {
            switch (c) {
                case '.':
                    result += " " + smiles[index++];
                    break;
                case '!':
                case '?':
                    result += c + " " + smiles[index++];
                    break;
                default:
                    result += c;
            }
            if (index == smiles.length) {
                index = 0;
            }
        }

        System.out.println("Rozveselený text: " + result);
    }
}
// Rozveselený text: Dnes jsem zaspal :) Také jsem naboural auto! :D A spolkl mouchu! :P! :) Nemám já den blbec? :D
// Rozveselený text: Dnes jsem zaspal :) Také jsem naboural auto! :D A spolkl mouchu! :P! :) Nemám já den blbec? :D
