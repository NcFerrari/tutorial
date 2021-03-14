/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cykly;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class Cykly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        for (int i = 0; i < 3; i++) {
            System.out.println("Knock");
        }
        System.out.println("Penny!");

        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1 + " ");
        }

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(j * i + "\t");
            }
            System.out.println();
        }

        System.out.println("Mocninátor\n==========\nZadejte základ mocniny: ");
        double zaklad = Double.parseDouble(scanner.nextLine());
        System.out.println("Zadejte exponent: ");
        int exponent = Integer.parseInt(scanner.nextLine());

        double vysledek = 1;
        for (int i = 0; i < exponent; i++) {
            vysledek = vysledek * zaklad;
        }

        System.out.println("Výsledek: " + vysledek);
        System.out.println("Děkuji za použití mocninátoru");
    }
}
