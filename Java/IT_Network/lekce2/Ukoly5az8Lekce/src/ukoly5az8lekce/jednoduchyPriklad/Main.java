package ukoly5az8lekce.jednoduchyPriklad;

public class Main {

    public static void main(String[] args) {
        Ptak ptak = new Ptak();
        System.out.println(ptak);
        ptak.snez(20);
        System.out.println(ptak);
        AngryPtak angryPtak = new AngryPtak();
        System.out.println(angryPtak);
        angryPtak.provokuj(5);
        System.out.println(angryPtak);
        angryPtak.snez(100);
        angryPtak.provokuj(5);
        System.out.println(angryPtak);
    }
}
