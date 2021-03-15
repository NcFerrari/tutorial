/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly12a13lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class StredniPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        final int minX = 1;
        final int maxX = 9;
        final int minY = 1;
        final int maxY = 9;
        String[][] hraciPole = new String[maxX + 1][maxY + 1];

        // inicializace pole
        for (int j = minY - 1; j < hraciPole.length; j++) {
            for (int i = minX - 1; i < hraciPole[j].length; i++) {
                if (i == minX - 1 && j == minY - 1) {
                    hraciPole[j][i] = "  ";
                    continue;
                }
                if (i == minX - 1) {
                    hraciPole[j][i] = j + " ";
                    continue;
                }
                if (j == minY - 1) {
                    hraciPole[j][i] = "" + i;
                    continue;
                }
                hraciPole[j][i] = " ";
            }
        }
        boolean hracSKoleckem = true;
        String hraciSymbol = "O";
        int xPozice = 1;
        int yPozice = 1;
        String hrac = "";
        int tah = 0;

        while (true) {
            // vypis
            for (String[] radek : hraciPole) {
                for (String bunka : radek) {
                    System.out.print(bunka);
                }
                System.out.println();
            }

            // vyhodnocení vítězství
            //vodorovně
            int index = 1;
            int pocetStejnychSymbolu = 0;
            while (hraciPole[yPozice][xPozice - index].equals(hraciSymbol)) {
                index++;
            }
            while ((xPozice - index + 1 <= maxX) && hraciPole[yPozice][xPozice - index + 1].equals(hraciSymbol)) {
                pocetStejnychSymbolu++;
                index--;
            }
            if (pocetStejnychSymbolu >= 5) {
                System.out.println("Vyhrál hráč s " + hrac);
                break;
            }
            //svisle
            index = 1;
            pocetStejnychSymbolu = 0;
            while (hraciPole[yPozice - index][xPozice].equals(hraciSymbol)) {
                index++;
            }
            while ((yPozice - index + 1 <= maxY) && hraciPole[yPozice - index + 1][xPozice].equals(hraciSymbol)) {
                pocetStejnychSymbolu++;
                index--;
            }
            if (pocetStejnychSymbolu >= 5) {
                System.out.println("Vyhrál hráč s " + hrac);
                break;
            }
            //ediagonála
            index = 1;
            pocetStejnychSymbolu = 0;
            while (hraciPole[yPozice - index][xPozice - index].equals(hraciSymbol)) {
                index++;
            }
            while ((xPozice - index + 1 <= maxX) && (yPozice - index + 1 <= maxY) && hraciPole[yPozice - index + 1][xPozice - index + 1].equals(hraciSymbol)) {
                pocetStejnychSymbolu++;
                index--;
            }
            if (pocetStejnychSymbolu >= 5) {
                System.out.println("Vyhrál hráč s " + hrac);
                break;
            }
            //fdiagonála
            index = 1;
            pocetStejnychSymbolu = 0;
            while ((yPozice + index <= maxY) && hraciPole[yPozice + index][xPozice - index].equals(hraciSymbol)) {
                index++;
            }
            while ((xPozice - index + 1 <= maxX) && hraciPole[yPozice + index - 1][xPozice - index + 1].equals(hraciSymbol)) {
                pocetStejnychSymbolu++;
                index--;
            }
            if (pocetStejnychSymbolu >= 5) {
                System.out.println("Vyhrál hráč s " + hrac);
                break;
            }
            //remiza
            if (tah == maxX * maxY) {
                System.out.println("Remíza.");
                break;
            }

            // zadávání
            boolean pokracuj = true;
            if (hracSKoleckem) {
                hrac = "kolečky";
                hraciSymbol = "O";
            } else {
                hrac = "křižky";
                hraciSymbol = "X";
            }
            System.out.println("\nNa řadě je hráč s " + hrac);
            tah++;
            do {
                System.out.println("Zadej pozici X kam chceš táhnout:");
                xPozice = Integer.parseInt(scanner.nextLine());
                System.out.println("Zadej pozici Y kam chceš táhnout:");
                yPozice = Integer.parseInt(scanner.nextLine());

                // kontrola
                if (xPozice < minX || xPozice > maxX || yPozice < minY || yPozice > maxY || !hraciPole[yPozice][xPozice].contains(" ")) {
                    System.out.println("Neplatná pozice, zadej ji prosím znovu.");
                    pokracuj = false;
                } else {
                    pokracuj = true;
                }
            } while (!pokracuj);

            // umístěnní symbolu do pole
            hraciPole[yPozice][xPozice] = hraciSymbol;

            // změna hráče
            hracSKoleckem ^= true;
        }
    }
}
