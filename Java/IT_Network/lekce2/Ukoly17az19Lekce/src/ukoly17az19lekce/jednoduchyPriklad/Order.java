package ukoly17az19lekce.jednoduchyPriklad;

import java.util.ArrayList;
import java.util.Arrays;

public class Order implements OrderInterface {

    private static int nextOrderNumber = 1;
    private Customer customer;
    private Product product;
    private Address address;
    private int quantity;
    private final int orderNumber = nextOrderNumber++;

    public Order(int quantity, Product product, Customer customer, Address address) {
        this.customer = customer;
        this.product = product;
        this.address = address;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return customer + " | " + product;
    }

    @Override
    public int getNumber() {
        return orderNumber;
    }

    @Override
    public String getFirstName() {
        return customer.getName();
    }

    @Override
    public String getLastName() {
        return customer.getLastName();
    }

    @Override
    public String getStreet() {
        return address.getStreet();
    }

    @Override
    public int getHouseNumber() {
        return address.getNumber();
    }

    @Override
    public int getRegistryNumber() {
        return address.getRegistryNumber();
    }

    @Override
    public String getCity() {
        return address.getCity();
    }

    @Override
    public String getZipCode() {
        return address.getPsc();
    }

    @Override
    public String getCountry() {
        return "Česká republika";
    }

    @Override
    public ArrayList<String> getProducts() {
        return new ArrayList<>(Arrays.asList(product.getProductName()));
    }

    @Override
    public ArrayList<Integer> getProductQuantities() {
        return new ArrayList<>(Arrays.asList(quantity));
    }

    @Override
    public ArrayList<Double> getProductPrices() {
        return new ArrayList<>(Arrays.asList(product.getProductPrice()));
    }

}
