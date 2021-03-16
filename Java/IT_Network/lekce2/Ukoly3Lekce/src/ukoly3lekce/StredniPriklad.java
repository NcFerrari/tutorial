/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly3lekce;

import java.util.Random;

/**
 *
 * @author NcFerrari
 */
public class StredniPriklad {

    private final String[] subjects = {"jednorožec", "programátor", "manažer", "hroch", "T-rex"};
    private final String[] prejudices = {"spal", "ležel", "vařil", "uklízel", "derivoval"};
    private final String[] attributes = {"modrý", "velký", "hubený", "nejlepší", "automatizovaný"};
    private final String[] adverbs = {"rychle", "s oblibou", "hodně", "málo", "se zpožděním"};
    private final String[] places = {"pod stolem", "v lese", "u babičky", "v práci", "na stole"};
    private final Random random = new Random();

    public String getSubject() {
        return subjects[random.nextInt(subjects.length)];
    }

    public String getPrejudice() {
        return prejudices[random.nextInt(prejudices.length)];
    }

    public String getAttribute() {
        return attributes[random.nextInt(attributes.length)];
    }

    public String getAdverb() {
        return adverbs[random.nextInt(adverbs.length)];
    }

    public String getPlace() {
        return places[random.nextInt(places.length)];
    }

    public static void main(String[] args) {
        StredniPriklad word = new StredniPriklad();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s %s %s %s %s\n", word.getAttribute(), word.getSubject(), word.getAdverb(), word.getPrejudice(), word.getPlace());
        }
    }
}
