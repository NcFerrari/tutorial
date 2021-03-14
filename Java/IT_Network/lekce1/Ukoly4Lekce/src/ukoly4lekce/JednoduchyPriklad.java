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
public class JednoduchyPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadej jméno:");
        String name = scanner.nextLine();
        System.out.println("Zadej příjmení:");
        String surname = scanner.nextLine();
        System.out.println("Zadej svůj věk:");
        byte age = Byte.parseByte(scanner.nextLine());
        System.out.printf("%s %s\n", name.toUpperCase(), surname.toUpperCase());
        System.out.printf("Za rok ti bude %d let.\n", ++age);
    }
}
