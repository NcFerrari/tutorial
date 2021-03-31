package ukoly5az8lekce.pokrocilyPriklad;

public class Main {

    public static void main(String[] args) {
        Tvar koruna = new Trojuhelnik(25, 15, 15, "Zelená");
        Tvar kmen = new Obdelnik(3, 26, "Hnědá");
        double obsah = koruna.obsah() * 4 + kmen.obsah();
        System.out.println("Obsah stromu je " + obsah + " cm^2");
    }
}
