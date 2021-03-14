/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retezce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class CesarovaSifra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        String s = "cernediryjsoutamkdebuhdelilnulou";
        System.out.printf("Původní zpráva: %s\n", s);
        String zprava = "";
        int posun = 1;
        for (char c : s.toCharArray()) {
            int letter = (int) c + posun;
            if(letter > 122) {
                letter -= 26;
            }
            zprava += (char) letter;
        }

        System.out.printf("Zašifrovaná zpráva: %s\n", zprava);
    }
}
