/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly3lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class PokrocilyPriklad {

    public static void main(String[] args) {
        final float pi = 3.1415F;
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadej poloměr kruhu (cm):");
        float r = Float.parseFloat(scanner.nextLine());
        System.out.println("Obvod zadaného kruhu je: " + 2 * pi * r + " cm");
        System.out.println("Jeho obsah je " + pi * r * r + " cm^2");
    }
}
