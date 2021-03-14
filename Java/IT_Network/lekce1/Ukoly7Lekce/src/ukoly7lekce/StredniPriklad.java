/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly7lekce;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class StredniPriklad {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in, "Windows-1250");
        final String[] fruit = {"jablko", "hruška", "pomeranč", "jahoda", "banán", "kiwi", "malina"};
        final String[] vegetable = {"zelí", "okurka", "rajče", "paprika", "ředkev", "mrkev", "brokolice"};
        Arrays.sort(fruit);
        Arrays.sort(vegetable);

        boolean continueLoop = true;
        int counter = 0;
        while (continueLoop) {
            System.out.println("Zadej název libovolného ovoce nebo zeleniny:");
            String answer = scanner.nextLine().toLowerCase();
            counter++;
            if (Arrays.binarySearch(fruit, answer) >= 0) {
                System.out.println("Zadal jsi ovoce");
            } else if (Arrays.binarySearch(vegetable, answer) >= 0) {
                System.out.println("Zadal jsi zeleninu");
            } else {
                System.out.println("Tvoje slovo nemám v seznamu");
            }
            System.out.println("Přeješ si zadat další slovo? (ano/ne)");
            if (scanner.nextLine().equals("ne")) {
                continueLoop = false;
            }
        }
        System.out.printf("Zadal jsi %d slov\n", counter);
    }
}
