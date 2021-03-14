/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly8lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class StredniPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadej palindrom:");
        String palindrom = scanner.nextLine();
        boolean isPalindrom = true;
        for (int i = 0; i < palindrom.length() / 2; i++) {
            if (palindrom.charAt(i) != palindrom.charAt(palindrom.length() - 1 - i)) {
                isPalindrom = false;
                break;
            }
        }
        if (isPalindrom) {
            System.out.println("Ano, toto je palindrom.");
        } else {
            System.out.println("Toto není palindrom.");
        }
    }
}
