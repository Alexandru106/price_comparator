package service;

import model.Product;
import java.util.*;
import java.util.stream.Collectors;

public class ProductService {

    public static Map<String, List<Product>> groupByProduct(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(p -> p.name.toLowerCase()));
    }

    public static void comparePrices(Map<String, List<Product>> groupedProducts) {
        for (String name : groupedProducts.keySet()) {
            List<Product> list = groupedProducts.get(name);
            if (list.size() > 1) {
                System.out.println("Comparație pentru: " + name);
                for (Product p : list) {
                    System.out.println("  - " + p);
                }
                System.out.println();
            }
        }
    }
}
