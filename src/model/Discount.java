package model;

import java.time.LocalDate;

public class Discount {
    public String productId;
    public String productName;
    public String brand;
    public double quantity;
    public String unit;
    public String category;
    public LocalDate fromDate;
    public LocalDate toDate;
    public int discountPercentage;
    public String store;

    public Discount(String productId, String productName, String brand, double quantity, String unit, String category,
                    LocalDate fromDate, LocalDate toDate, int discountPercentage, String store) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.quantity = quantity;
        this.unit = unit;
        this.category = category;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.discountPercentage = discountPercentage;
        this.store = store;
    }

    @Override
    public String toString() {
        return store + ": " + productName + " (" + discountPercentage + "% discount)";
    }
}
