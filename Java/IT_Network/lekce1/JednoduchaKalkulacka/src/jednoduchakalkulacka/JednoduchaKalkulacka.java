/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jednoduchakalkulacka;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class JednoduchaKalkulacka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Vítejte v kalkulačce.\nZadejte první číslo:");
        float prvniCislo = Float.parseFloat(scanner.nextLine());
        System.out.println("Zadejte druhé číslo:");
        float druheCislo = Float.parseFloat(scanner.nextLine());
        float soucet = prvniCislo + druheCislo;
        float rozdil = prvniCislo - druheCislo;
        float soucin = prvniCislo * druheCislo;
        float podil = prvniCislo / druheCislo;
        System.out.println("Součet: " + soucet);
        System.out.println("Rozdíl: " + rozdil);
        System.out.println("Součin: " + soucin);
        System.out.println("Podíl: " + podil);
        System.out.println("Děkuji za použití kalkulačky, aplikaci ukončíte libovolnou klávesou.");
    }

}
