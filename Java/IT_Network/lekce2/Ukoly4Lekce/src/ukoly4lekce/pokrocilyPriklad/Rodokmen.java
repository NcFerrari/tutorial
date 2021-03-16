package ukoly4lekce.pokrocilyPriklad;

public class Rodokmen {

    public void getRodokmen(Osoba osoba) {
        System.out.println("Rodokmen pro osobu " + osoba);
        zobrazRodokmen(osoba);
    }

    public void zobrazRodokmen(Osoba osoba) {
        System.out.println(osoba.getJmeno());
        if (osoba.getOtec() != null) {
            zobrazRodokmen(osoba.getOtec());
        }
        if (osoba.getMatka() != null) {
            zobrazRodokmen(osoba.getMatka());
        }
    }
}
