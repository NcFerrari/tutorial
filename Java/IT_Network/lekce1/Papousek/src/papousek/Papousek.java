/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papousek;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class Papousek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Ahoj, jsem virtuální papoušek Lóra, rád opakuji!\nNapiš něco: ");
        String vstup = scanner.nextLine();
        System.out.println(vstup + ", " + vstup + "!");
    }

}
