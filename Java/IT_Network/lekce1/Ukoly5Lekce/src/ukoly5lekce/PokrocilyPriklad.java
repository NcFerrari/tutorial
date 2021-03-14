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
public class PokrocilyPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadejte postupně koeficienty a,b,c kvadratické rovnice ax^2+bx+c=0 :");
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());
        if (a == 0 || b == 0 || c == 0) {
            System.out.println("Není kvadratická rovnice");
            return;
        }
        double diskriminant = b * b - 4 * a * c;
        if (diskriminant < 0) {
            System.out.println("Neexistuje řešení v oblasti reálných čísel");
        } else if (diskriminant == 0) {
            System.out.println("Rovnice má jeden kořen x = " + (-b / (2 * a)));
        } else {
            double x1 = (-b + Math.sqrt(diskriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(diskriminant)) / (2 * a);
            System.out.printf("Rovnice má 2 reálné kořeny x1 = %f, x2 = %f\n", x1, x2);
        }
    }
}
