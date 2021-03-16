/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly2lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class JednoduchyPriklad {

    private double firstNumber;
    private double secondNumber;

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double addition() {
        return firstNumber + secondNumber;
    }

    public double subtraction() {
        return firstNumber - secondNumber;
    }

    public double multiplication() {
        return firstNumber * secondNumber;
    }

    public double division() {
//        if (secondNumber != 0) {
//            return firstNumber / secondNumber;
//        }
//        return 0;
return firstNumber / secondNumber;
    }

    public void output() {
        System.out.println("Součet: " + addition());
        System.out.println("Rozdíl: " + subtraction());
        System.out.println("Součin: " + multiplication());
        System.out.println("Podíl: " + division());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        JednoduchyPriklad example = new JednoduchyPriklad();
        System.out.println("Zadej 1. číslo:");
        example.setFirstNumber(Double.parseDouble(scanner.nextLine()));
        System.out.println("Zadej 2. číslo:");
        example.setSecondNumber(Double.parseDouble(scanner.nextLine()));
        example.output();
    }
}
