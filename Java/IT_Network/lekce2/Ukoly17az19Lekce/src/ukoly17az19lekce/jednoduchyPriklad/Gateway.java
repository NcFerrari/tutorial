package ukoly17az19lekce.jednoduchyPriklad;

/**
 * Tato třída reprezentuje platební bránu nějakého většího systému třetí strany.
 * V reálu by zde tedy bylo ještě spoustu dalších tříd a metod.
 */
public class Gateway {

    /**
     * Metoda simuluje zpracování objednávky, zde pouze vypsáním do konzole.
     * Důležité je, že díky dodržení rozhraní od vývojářů platební brány umí
     * brána pracovat s naší objednávkou, i když naši třídu nikdy neviděli.
     *
     * @param order Objednávka implementující rozhraní OrderInterface
     */
    public void processOrder(OrderInterface order) {
        System.out.println("Order no. " + order.getNumber());
        System.out.println("=============");
        System.out.println("Name:    " + order.getFirstName() + " " + order.getLastName());
        System.out.println("Address: " + order.getStreet() + " "
                + order.getHouseNumber() + "/" + order.getRegistryNumber());
        System.out.println("         " + order.getCity() + " " + order.getZipCode());
        System.out.println("         " + order.getCountry());
        System.out.println();

        int sum = 0;
        for (int i = 0; i < order.getProducts().size(); i++) {
            System.out.println(order.getProducts().get(i) + " " + order.getProductQuantities().get(i)
                    + "pcs per " + order.getProductPrices().get(i) + ",-");
            sum += order.getProductPrices().get(i);
        }
        System.out.println();
        System.out.println("Total price: " + sum + ",-");
    }

}
