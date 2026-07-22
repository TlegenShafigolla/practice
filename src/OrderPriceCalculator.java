public class OrderPriceCalculator {

    private static final double DISCOUNT_RATE = 0.10;

    public static void main(String[] args) {
        String productName = "Keyboard";
        int quantity = 3;
        double pricePerItem = 20_000;
        boolean hasDiscount = true;

        if (!isValid(quantity, pricePerItem)) {
            System.out.println("Invalid data");
            return;
        }

        double subtotal = calculateSubtotal(quantity, pricePerItem);
        double discount = calculateDiscount(subtotal, hasDiscount);
        double totalPrice = calculateTotalPrice(subtotal, discount);

        System.out.println("Product: " + productName);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Total price: " + totalPrice);
    }

    private static boolean isValid(int quantity, double pricePerItem) {
        return quantity > 0 && pricePerItem >= 0;
    }

    private static double calculateSubtotal(
            int quantity,
            double pricePerItem
    ) {
        return quantity * pricePerItem;
    }

    private static double calculateDiscount(
            double subtotal,
            boolean hasDiscount
    ) {
        if (!hasDiscount) {
            return 0;
        }

        return subtotal * DISCOUNT_RATE;
    }

    private static double calculateTotalPrice(
            double subtotal,
            double discount
    ) {
        return subtotal - discount;
    }
}