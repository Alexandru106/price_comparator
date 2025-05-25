package util;

import model.Product;
import model.Discount;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CsvReader {

    public static List<Product> readProducts(String filePath, String storeName) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length < 8) continue;
                Product p = new Product(
                        fields[0], fields[1], fields[2], fields[3],
                        Double.parseDouble(fields[4]), fields[5],
                        Double.parseDouble(fields[6]), fields[7],
                        storeName
                );
                products.add(p);
            }
        } catch (IOException e) {
            System.out.println("Error reading " + filePath);
        }
        return products;
    }

    public static List<Discount> readDiscounts(String filePath, String storeName) {
        List<Discount> discounts = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length < 9) continue;
                Discount d = new Discount(
                        fields[0], fields[1], fields[2],
                        Double.parseDouble(fields[3]), fields[4], fields[5],
                        LocalDate.parse(fields[6], formatter),
                        LocalDate.parse(fields[7], formatter),
                        Integer.parseInt(fields[8]),
                        storeName
                );
                discounts.add(d);
            }
        } catch (IOException e) {
            System.out.println("Error reading discounts: " + filePath);
        }
        return discounts;
    }
}
