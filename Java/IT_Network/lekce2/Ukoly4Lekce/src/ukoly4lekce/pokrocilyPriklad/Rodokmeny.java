package ukoly4lekce.pokrocilyPriklad;

public class Rodokmeny {

    public static void main(String[] args) {
        Rodokmen rodokmen = new Rodokmen();
        Osoba abraham = new Osoba("Abraham Simpson", null, null);
        Osoba penelope = new Osoba("Penelope Olsen", null, null);
        Osoba bouvier = new Osoba("Pan Bouvier", null, null);
        Osoba jackie = new Osoba("Jackie Bouvier", null, null);
        Osoba herb = new Osoba("Herb Powers", abraham, penelope);
        Osoba homer = new Osoba("Homer Simpson", abraham, penelope);
        Osoba marge = new Osoba("Marge Bouvier", bouvier, jackie);
        Osoba selma = new Osoba("Selma Bouvier", bouvier, jackie);
        Osoba bart = new Osoba("Bart Simpson", homer, marge);

        rodokmen.getRodokmen(bart);
        System.out.println();
        rodokmen.getRodokmen(homer);
    }
}
