import java.util.Locale;

public class OrderSummary {

  private static final double PREMIUM_PRICE_THRESHOLD = 100.0;
  private static final double DISCOUNT_THRESHOLD = 200.0;
  private static final double DISCOUNT_RATE = 0.10;
  private static final double TAX_RATE = 0.13;

  public static String summarize(String customer, String[] itemNames, double[] itemPrices) {
    double subtotal = calculateSubtotal(itemPrices);
    int premiumCount = countPremiumItems(itemPrices);
    double discount = calculateDiscount(subtotal);
    double taxable = subtotal - discount;
    double tax = taxable * TAX_RATE;
    double total = taxable + tax;
    return buildReport(customer, itemNames, itemPrices, premiumCount,
            subtotal, discount, tax, total);
  }

  private static double calculateSubtotal(double[] itemPrices) {
    double subtotal = 0.0;
    for (double price : itemPrices) {
      subtotal += price;
    }
    return subtotal;
  }

  private static int countPremiumItems(double[] itemPrices) {
    int premiumCount = 0;
    for (double price : itemPrices) {
      if (price >= PREMIUM_PRICE_THRESHOLD) {
        premiumCount++;
      }
    }
    return premiumCount;
  }

  private static double calculateDiscount(double subtotal) {
    if (subtotal > DISCOUNT_THRESHOLD) {
      return subtotal * DISCOUNT_RATE;
    }
    return 0.0;
  }

  private static String buildReport(String customer, String[] itemNames, double[] itemPrices,
                                    int premiumCount, double subtotal, double discount, double tax, double total) {
    StringBuilder report = new StringBuilder();
    report.append("Order summary for ").append(customer).append("\n");
    report.append("----------------------\n");
    for (int i = 0; i < itemNames.length; i++) {
      report.append(formatItemLine(itemNames[i], itemPrices[i]));
    }
    report.append(String.format(Locale.US, "Items: %d\n", itemNames.length));
    report.append(String.format(Locale.US, "Premium items: %d\n", premiumCount));
    report.append(String.format(Locale.US, "Subtotal: $%.2f\n", subtotal));
    report.append(String.format(Locale.US, "Discount: $%.2f\n", discount));
    report.append(String.format(Locale.US, "Tax: $%.2f\n", tax));
    report.append(String.format(Locale.US, "Total: $%.2f", total));
    return report.toString();
  }

  private static String formatItemLine(String name, double price) {
    return String.format(Locale.US, "%s: $%.2f\n", name, price);
  }
}