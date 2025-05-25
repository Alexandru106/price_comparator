package model;

public class Product {
    public String productId;
    public String name;
    public String category;
    public String brand;
    public double quantity;
    public String unit;
    public double price;
    public String currency;
    public String store;

    public Product(String productId, String name, String category, String brand, double quantity, String unit, double price, String currency, String store) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.quantity = quantity;
        this.unit = unit;
        this.price = price;
        this.currency = currency;
        this.store = store;
    }

    @Override
    public String toString() {
        return store + ": " + name + " - " + price + " " + currency;
    }
}
