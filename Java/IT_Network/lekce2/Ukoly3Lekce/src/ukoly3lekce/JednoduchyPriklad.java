/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly3lekce;

/**
 *
 * @author NcFerrari
 */
public class JednoduchyPriklad {

    private final int maxFatigue = 20;
    private String nameOfHuman;
    private int fatigue = 0;

    public JednoduchyPriklad(String nameOfHuman) {
        this.nameOfHuman = nameOfHuman;
    }

    public int getFatigue() {
        return fatigue;
    }

    public String getNameOfHuman() {
        return nameOfHuman;
    }

    /**
     * distance in kilometers
     *
     * @param distance
     */
    public void run(int distance) {
        if (fatigue + distance > maxFatigue) {
            fatigue = maxFatigue;
            System.out.println("Jsem příliš unavený");
        } else {
            fatigue += distance;
        }
    }

    public void sleep(int hour) {
        if (fatigue - (hour * 10) < 0) {
            fatigue = 0;
        } else {
            fatigue -= hour * 10;
        }
    }

    @Override
    public String toString() {
        return getNameOfHuman();
    }

    public static void main(String[] args) {
        JednoduchyPriklad human = new JednoduchyPriklad("Karel Nový (25)");
        System.out.println(human);
        human.run(10);
        human.run(10);
        human.run(10);
        human.sleep(1);
        human.run(10);
    }
}
