/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zdvojnasobovac;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class Zdvojnasobovac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadejte číslo k zdvojnásobení:");
        int cislo = scanner.nextInt();
        System.out.println(cislo * 2);
    }
    
}
