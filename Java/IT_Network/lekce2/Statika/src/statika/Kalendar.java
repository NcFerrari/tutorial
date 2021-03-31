package statika;

public class Kalendar {

    public String vratNastaveni() {
        String s = "";
        s += String.format("Jazyk: %s\n", Nastaveni.getJazyk());
        s += String.format("Barevné schéma: %s\n", Nastaveni.getBarevneSchem());
        s += String.format("Spustit po startu: %s\n", Nastaveni.isSpustitPoStartu());
        return s;
    }

    public static void main(String[] args) {
        Kalendar kalendar = new Kalendar();
        System.out.println(kalendar.vratNastaveni());
    }
}
