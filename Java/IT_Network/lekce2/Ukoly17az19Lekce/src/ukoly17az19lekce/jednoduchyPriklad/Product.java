package ukoly17az19lekce.jednoduchyPriklad;

public class Product {

    private String productName;
    private String note;
    private double productPrice;

    public Product(String productName, String note, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.note = note;
    }

    @Override
    public String toString() {
        return productName + " (" + productPrice + ")";
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getNote() {
        return note;
    }

}
