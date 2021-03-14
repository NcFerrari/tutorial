/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly5lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class JednoduchyPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadej své jméno:");
        String name = scanner.nextLine();
        if (name != null && name.length() > 2 && name.length() < 11) {
            System.out.println("Normální jméno.");
        } else {
            System.out.println("Máš moc krátké nebo moc dlouhé jméno!");
        }
    }
}
