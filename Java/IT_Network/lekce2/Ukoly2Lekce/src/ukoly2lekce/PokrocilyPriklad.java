/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly2lekce;

/**
 *
 * @author NcFerrari
 */
public class PokrocilyPriklad {

    private String name;
    private String surname;
    private int age;

    public PokrocilyPriklad(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String introduction(PokrocilyPriklad friend) {
        return String.format("Ahoj, já jsem %s %s, je mi %d let a můj kamarád je %s %s", getName(), getSurname(), getAge(), friend.getName(), friend.getSurname());
    }

    public static void main(String[] args) {
        PokrocilyPriklad novakKarel = new PokrocilyPriklad("Karel", "Novák", 33);
        PokrocilyPriklad novyJosef = new PokrocilyPriklad("Josef", "Nový", 27);
        System.out.println(novakKarel.introduction(novyJosef));
        System.out.println(novyJosef.introduction(novakKarel));
    }
}
