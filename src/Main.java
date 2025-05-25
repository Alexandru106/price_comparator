import model.Product;
import model.Discount;
import model.PriceAlert;
import service.ProductService;
import service.DiscountService;
import service.PriceAlertService;
import util.CsvReader;

import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> allProducts = new ArrayList<>();
        allProducts.addAll(CsvReader.readProducts("src/data/lidl_2025-05-01.csv", "Lidl"));
        allProducts.addAll(CsvReader.readProducts("src/data/kaufland_2025-05-01.csv", "Kaufland"));
        allProducts.addAll(CsvReader.readProducts("src/data/profi_2025-05-01.csv", "Profi"));

        Map<String, List<Product>> grouped = ProductService.groupByProduct(allProducts);
        ProductService.comparePrices(grouped);

        List<Discount> allDiscounts = new ArrayList<>();
        allDiscounts.addAll(CsvReader.readDiscounts("/data/lidl_discounts_2025-05-01.csv", "Lidl"));
        allDiscounts.addAll(CsvReader.readDiscounts("/data/profi_discounts_2025-05-01.csv", "Profi"));
        allDiscounts.addAll(CsvReader.readDiscounts("/data/kaufland_discounts_2025-05-01.csv", "Kaufland"));

        LocalDate today = LocalDate.of(2025, 5, 1);
        DiscountService.showNewDiscounts(allDiscounts, today);
        DiscountService.showTopDiscounts(allDiscounts, 5);

        Scanner scanner = new Scanner(System.in);
        List<PriceAlert> alerts = new ArrayList<>();

        System.out.println("📥 Introdu alerte de preț (scrie `gata` pentru a opri)");
        while (true) {
            System.out.print("Produs: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("gata")) break;

            System.out.print("Preț țintă: ");
            String priceInput = scanner.nextLine();

            try {
                double targetPrice =Double.parseDouble(priceInput);
                alerts.add(new PriceAlert(name, targetPrice));
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Preț invalid. Încearcă din nou.");
            }
        }

        PriceAlertService.checkAlerts(allProducts, alerts);

    }

}
