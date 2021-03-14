/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podminky;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class Podminky {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        if (15 > 5) {
            System.out.println("Pravda");
        }
        System.out.println("Program zde pokračuje dál");

        System.out.println("Zadej nějaké číslo");
        int a = Integer.parseInt(scanner.nextLine());
        if (a > 5) {
            System.out.println("Zadal jsi číslo větší než 5!");
        }
        System.out.println("Děkuji za zadání");

        System.out.println("Zadejte nějaké číslo, ze kterého spočítám odmocninu:");
        int cislo = Integer.parseInt(scanner.nextLine());
        if (cislo > 0) {
            System.out.println("Zadal jsi číslo větší než 0, to znamená, že ho monhu odmocnit!");
            double o = Math.sqrt(cislo);
            System.out.println("Odmocnina z čísla " + cislo + " je " + o);
        } else {
            System.out.println("Odmocnina ze záporného čísla neexistuje!");
        }
        System.out.println("Děkuji za zadání");

        int x = 0;
        if (x == 0) {
            x = 1;
        } else {
            x = 0;
        }
        System.out.println(x);

        System.out.println("Zadejte číslo v rozmezí 10-20 nebo 30-40:");
        int a1 = Integer.parseInt(scanner.nextLine());
        if ((a1 >= 10 && a1 <= 20) || (a1 >= 30 && a1 <= 40)) {
            System.out.println("Zadal jsi správně");
        } else {
            System.out.println("Zadal jsi špatně");
        }
    }

}
