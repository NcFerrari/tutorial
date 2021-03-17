package tahovyboj;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Arena {

    private Bojovnik bojovnik1;
    private Bojovnik bojovnik2;
    private Kostka kostka;

    public Arena(Bojovnik bojovnik1, Bojovnik bojovnik2, Kostka kostka) {
        this.bojovnik1 = bojovnik1;
        this.bojovnik2 = bojovnik2;
        this.kostka = kostka;
    }

    private void vykresli() {
        System.out.println("-------------------- Aréna --------------------");
        System.out.println("Zdraví bojovníků:\n");
        System.out.printf("%s %s\n", bojovnik1.getJmeno(), bojovnik1.zobrazZdravi());
        System.out.printf("%s %s\n", bojovnik2.getJmeno(), bojovnik2.zobrazZdravi());
    }

    private void vypisZpravu(String zprava) {
        System.out.println(zprava);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.err.println("Chyba, nepovedlo se uspat vlákno");
        }
    }

    public void zapas() {
        System.out.println("Vítejte v aréně!");
        System.out.printf("Dnes se utkají %s a %s!\n\n", bojovnik1.getJmeno(), bojovnik2.getJmeno());
        System.out.println("Zápas může začít...");
        boolean zacinaBojovnik2 = (kostka.hod() <= kostka.getPocetSten() / 2);
        if (zacinaBojovnik2) {
            Bojovnik prohazovaciBojovnik = bojovnik1;
            bojovnik1 = bojovnik2;
            bojovnik2 = prohazovaciBojovnik;
        }

        while (bojovnik1.isNaZivu() && bojovnik2.isNaZivu()) {
            bojovnik1.utoc(bojovnik2);
            vykresli();
            vypisZpravu(bojovnik1.getZprava());
            vypisZpravu(bojovnik2.getZprava());
            if (bojovnik2.isNaZivu()) {
                bojovnik2.utoc(bojovnik1);
                vykresli();
                vypisZpravu(bojovnik2.getZprava());
                vypisZpravu(bojovnik1.getZprava());
            }
            System.out.println();
        }
    }
}
