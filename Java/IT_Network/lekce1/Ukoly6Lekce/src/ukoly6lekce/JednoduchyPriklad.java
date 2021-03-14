/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly6lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class JednoduchyPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Kolik ryb si dáš k večeři?");
        short count = Short.parseShort(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("<° )))-<");
        }
    }
}
