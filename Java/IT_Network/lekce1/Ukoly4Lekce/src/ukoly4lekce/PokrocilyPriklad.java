/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly4lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class PokrocilyPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadej řetězec:");
        String input = scanner.nextLine();
        System.out.println(input.toLowerCase().trim().contains("itnetwork"));
    }
}
