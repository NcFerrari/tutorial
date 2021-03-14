/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly6lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class PokrocilyPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadejte levou mez 1. intervalu:");
        int leftFirstLimit = Integer.parseInt(scanner.nextLine());
        System.out.println("Zadejte pravou mez 1. intervalu:");
        int rightFirstLimit = Integer.parseInt(scanner.nextLine());
        System.out.println("Zadejte levou mez 2. intervalu:");
        int leftSecondLimit = Integer.parseInt(scanner.nextLine());
        System.out.println("Zadejte pravou mez 2. intervalu:");
        int rightSecondLimit = Integer.parseInt(scanner.nextLine());
        System.out.println("Dvojice čísel, jejichž součet leží v některém z intervalů:");
        System.out.println("(1. číslo je z prvního intervalu a 2. z druhého intervalu)");

        String output = "";
        for (int i = leftFirstLimit; i <= rightFirstLimit; i++) {
            for (int j = leftSecondLimit; j <= rightSecondLimit; j++) {
                if ((i + j >= leftFirstLimit && i + j <= rightFirstLimit) || (i + j >= leftSecondLimit && i + j <= rightSecondLimit)) {
                    output += String.format("[%d;%d], ", i, j);
                }
            }
        }
        System.out.println(output.trim());
    }
}
