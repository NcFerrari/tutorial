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
public class StredniPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadejte delší slovo:");
        String longWord = scanner.nextLine();
        System.out.println("Zadejte kratší slovo:");
        String shortWord = scanner.nextLine();
        System.out.printf("Slova se liší délkou o %d znaků\n", longWord.trim().length() - shortWord.trim().length());
    }
}
