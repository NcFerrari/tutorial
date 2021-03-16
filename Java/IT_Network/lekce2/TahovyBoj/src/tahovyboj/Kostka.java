/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahovyboj;

import java.util.Random;

public class Kostka {

    private final int pocetSten;
    private final Random random = new Random();

    public Kostka(int pocetSten) {
        this.pocetSten = pocetSten;
    }

    public Kostka() {
        this(6);
    }

    public int getPocetSten() {
        return pocetSten;
    }

    public int hod() {
        return random.nextInt(getPocetSten()) + 1;
    }

    @Override
    public String toString() {
        return String.format("Kostka s %s stěnami", getPocetSten());
    }
    
    
}
