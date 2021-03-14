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
public class JednoduchyPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Výpočet průměru známek\nZadejte známky oddělené čárkou:");
        String input = scanner.nextLine().trim();
        String[] fieldOfText = input.split(",");
        int[] field = new int[fieldOfText.length];
        int index = 0;
        for (String letter : fieldOfText) {
            field[index++] = Integer.parseInt(letter);
        }

        int result = 0;
        for (int value : field) {
            result += value;
        }

        System.out.println("Průměr: " + result / (double) field.length);
    }
}
