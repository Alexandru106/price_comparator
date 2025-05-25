package service;

import model.Discount;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class DiscountService {

    public static void showNewDiscounts(List<Discount> discounts, LocalDate currentDate) {
        System.out.println("🔔 Reduceri NOI în ultimele 24h:");
        discounts.stream()
                .filter(d -> d.fromDate.equals(currentDate))
                .forEach(System.out::println);
    }

    public static void showTopDiscounts(List<Discount> discounts, int topN) {
        System.out.println("🔥 Top " + topN + " reduceri:");
        discounts.stream()
                .sorted(Comparator.comparingInt(d -> -d.discountPercentage))
                .limit(topN)
                .forEach(System.out::println);
    }
}
