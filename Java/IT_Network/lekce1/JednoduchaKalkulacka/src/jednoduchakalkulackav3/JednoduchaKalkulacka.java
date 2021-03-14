/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jednoduchakalkulackav3;

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
        System.out.println("Vítejte v kalkulačce.");
        boolean run = true;
        while (run) {
            System.out.println("Zadejte první číslo:");
            double prvniCislo = Float.parseFloat(scanner.nextLine());
            System.out.println("Zadejte druhé číslo:");
            double druheCislo = Float.parseFloat(scanner.nextLine());
            System.out.println("Zvolte si operaci:\n1 - sčítání\n2 - odčítání\n3 - násobení\n4 - dělení");
            int volba = Integer.parseInt(scanner.nextLine());
            double vysledek = 0;
            switch (volba) {
                case 1:
                    vysledek = prvniCislo + druheCislo;
                    break;
                case 2:
                    vysledek = prvniCislo - druheCislo;
                    break;
                case 3:
                    vysledek = prvniCislo * druheCislo;
                    break;
                case 4:
                    vysledek = prvniCislo / druheCislo;
                    break;
                default:
                    System.out.println("Neplatná volba");
            }
            System.out.println("Výsledek: " + vysledek);
            String answer = "";
            while (!answer.equals("ano") && !answer.equals("ne")) {
                System.out.println("Chcete spočítat další příklad? (ano/ne)");
                answer = scanner.nextLine();
            }
            if (answer.equals("ne")) {
                run = false;
            }
        }
        System.out.println("Děkuji za použití kalkulačky");
    }

}
