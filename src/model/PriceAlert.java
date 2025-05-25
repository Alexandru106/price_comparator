package model;

public class PriceAlert {
    public String productName;
    public double targetPrice;

    public PriceAlert(String productName, double targetPrice) {
        this.productName = productName.toLowerCase();
        this.targetPrice = targetPrice;
    }
}
