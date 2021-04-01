package ukoly9lekce.stredniPriklad;

public class Tovarna {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(TovarnaNaCukrovi.getBanana());
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(TovarnaNaCukrovi.getJahoda());
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(TovarnaNaCukrovi.getCoko());
        }
    }
}
