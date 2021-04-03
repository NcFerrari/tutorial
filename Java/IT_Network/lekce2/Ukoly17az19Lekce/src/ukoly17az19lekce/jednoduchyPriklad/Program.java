package ukoly17az19lekce.jednoduchyPriklad;

public class Program {

    public static void main(String[] args) {
        Customer zakaznik = new Customer(1, "Tomáš", "Marný");
        Address adresa = new Address("Ve Svahu", 10, 2, "Praha", "10000");
        Product produkt = new Product("Body pro ITnetwork.cz", "Body pro zpřístupnění prémiového obsahu a dosažení vašeho vysněného zaměstnání v IT.", 239);
        Order objednavka = new Order(1, produkt, zakaznik, adresa);
// Vytvoření brány a předání objednávky bráně
        Gateway brana = new Gateway();
        brana.processOrder(objednavka);
    }
}