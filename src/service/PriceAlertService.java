package service;

import model.PriceAlert;
import model.Product;

import java.util.List;

public class PriceAlertService {

    public static void checkAlerts(List<Product> products, List<PriceAlert> alerts) {
        System.out.println("🔔 Alerta de preț:");
        for (PriceAlert alert : alerts) {
            for (Product product : products) {
                if (product.name.toLowerCase().equals(alert.productName)
                        && product.price <= alert.targetPrice) {
                    System.out.println("✅ " + product.name + " este disponibil la " + product.price
                            + " RON la " + product.store + " (țintă: " + alert.targetPrice + ")");
                }
            }
        }
    }
}
