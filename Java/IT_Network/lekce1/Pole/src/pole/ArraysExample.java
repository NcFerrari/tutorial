/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pole;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class ArraysExample {

    public static void main(String[] args) {
        String[] simpsonovi = {"Homer", "Marge", "Bart", "Lisa", "Maggie"};
        for (String simpson : simpsonovi) {
            System.out.println(simpson);
        }

        System.out.println("========");

        // sort
        Arrays.sort(simpsonovi);
        for (String simpson : simpsonovi) {
            System.out.println(simpson);
        }

        int[] pole = {1, 5, 77, 13, 654};
        Arrays.sort(pole);
        for (int i : pole) {
            System.out.println(i);
        }

        System.out.println("========");

        // binarySearch (POLE MUSÍ BÝT SETŘÍZENÉ - Arrays.sort(pole) )
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadejte Simpsna (z rodiny Simpsnů):");
        String simpson = scanner.nextLine();

        int pozice = Arrays.binarySearch(simpsonovi, simpson);
        if (pozice >= 0) {
            System.out.println("Jo, je to Simpson!");
        } else {
            System.out.println("Hele, tohle není Simpson!");
        }

        System.out.println("========");

        // copOfRange
        String[] simpsonovi2 = Arrays.copyOfRange(simpsonovi, 2, 3);
        for (String name : simpsonovi2) {
            System.out.println(name);
        }

        System.out.println("========");

        // počítání průměru
        System.out.println("Ahoj, spočítám ti průměr známek. Kolik známek zadáš?");
        int[] poleZnamek = new int[Integer.parseInt(scanner.nextLine())];
        for (int i = 0; i < poleZnamek.length; i++) {
            System.out.printf("Zadej %d. číslo: ", i + 1);
            poleZnamek[i] = Integer.parseInt(scanner.nextLine());
        }
        int soucet = 0;
        for (int i : poleZnamek) {
            soucet += i;
        }
        float prumer = soucet / (float) poleZnamek.length;
        System.out.printf("Průměr tvých známek je: %f\n", prumer);
    }
}
