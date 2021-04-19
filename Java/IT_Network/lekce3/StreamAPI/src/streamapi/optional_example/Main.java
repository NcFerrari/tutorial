package streamapi.optional_example;

public class Main {

    public static void main(String[] args) {
        IKnihovna knihovna = new Knihovna();
        knihovna.pridej(new Kniha("Hobit"));
        knihovna.pridej(new Kniha("kuchařka"));
        knihovna.pridej(new Kniha("krteček Boby"));
        
        knihovna.najdiKnihuBezpecne("Hobit").ifPresent(System.out::println);
    }
}
