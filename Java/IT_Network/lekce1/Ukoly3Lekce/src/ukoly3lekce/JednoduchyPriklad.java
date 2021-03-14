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
public class JednoduchyPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Ahoj, jak se jmenuješ?");
        String name = scanner.nextLine();
        System.out.println("Jaký jsi?");
        String property = scanner.nextLine();
        System.out.println(String.format("%s je %s", name, property));
    }
}
