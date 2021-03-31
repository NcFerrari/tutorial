package tahovyboj;

public class Arena {

    private Bojovnik bojovnik1;
    private Bojovnik mag;
    private Kostka kostka;

    public Arena(Bojovnik bojovnik1, Bojovnik mag, Kostka kostka) {
        this.bojovnik1 = bojovnik1;
        this.mag = mag;
        this.kostka = kostka;
    }

    private void vykresli() {
        System.out.println(""
                + "   __    ____  ____  _  _    __   \n"
                + "  /__\\  (  _ \\( ___)( \\( )  /__\\  \n"
                + " /(__)\\  )   / )__)  )  (  /(__)\\ \n"
                + "(__)(__)(_)\\_)(____)(_)\\_)(__)(__)\n");
        System.out.println("Bojovníci: \n");
        vypisBojovnika(bojovnik1);
        System.out.println();
        vypisBojovnika(mag);
        System.out.println();
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
        Bojovnik b1 = bojovnik1;
        Bojovnik b2 = mag;
        System.out.println("Vítejte v aréně!");
        System.out.printf("Dnes se utkají %s a %s!\n\n", bojovnik1.getJmeno(), mag.getJmeno());
        System.out.println("Zápas může začít...");
        boolean zacinaBojovnik2 = (kostka.hod() <= kostka.getPocetSten() / 2);
        if (zacinaBojovnik2) {
            b1 = mag;
            b2 = bojovnik1;
        }

        while (b1.isNaZivu() && b2.isNaZivu()) {
            b1.utoc(b2);
            vykresli();
            vypisZpravu(b1.getZprava());
            vypisZpravu(b2.getZprava());
            if (b2.isNaZivu()) {
                b2.utoc(b1);
                vykresli();
                vypisZpravu(b2.getZprava());
                vypisZpravu(b1.getZprava());
            }
            System.out.println();
        }
    }

    private void vypisBojovnika(Bojovnik b) {
        System.out.println(b.getJmeno());
        System.out.print("Život: ");
        System.out.println(b.zobrazZdravi());
        if (b instanceof Mag) {
            System.out.print("Mana: ");
            System.out.println(((Mag) b).zobrazManu());
        }
    }
}
