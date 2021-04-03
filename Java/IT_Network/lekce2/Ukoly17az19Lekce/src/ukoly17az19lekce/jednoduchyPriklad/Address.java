package ukoly17az19lekce.jednoduchyPriklad;

public class Address {

    private String city;
    private String street;
    private String psc;
    private int number;
    private int registryNumber;

    public Address(String street, int number, int registryNumber, String city, String psc) {
        this.city = city;
        this.street = street;
        this.number = number;
        this.registryNumber = registryNumber;
        this.psc = psc;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getPsc() {
        return psc;
    }

    public int getRegistryNumber() {
        return registryNumber;
    }

    @Override
    public String toString() {
        return city + ", " + street + " " + number;
    }

}
