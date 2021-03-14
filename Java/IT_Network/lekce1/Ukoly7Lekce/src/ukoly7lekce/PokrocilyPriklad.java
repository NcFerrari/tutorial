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
public class PokrocilyPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadej počet čísel:");
        int[] field = new int[Integer.parseInt(scanner.nextLine())];
        for (int i = 0; i < field.length; i++) {
            System.out.printf("Zadej %d. číslo: ", (i + 1));
            field[i] = Integer.parseInt(scanner.nextLine());
        }

        int[] medianField = Arrays.copyOf(field, field.length);
        Arrays.sort(medianField);
        double median = medianField[medianField.length / 2];

        for (int i : field) {
            System.out.println(i + " se od mediánu odchyluje o " + (i - median));
        }
    }
}
