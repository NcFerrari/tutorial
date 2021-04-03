package ukoly17az19lekce.jednoduchyPriklad;

public class Customer {

    private String name;
    private String lastName;

    public Customer(int useless, String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }

}
