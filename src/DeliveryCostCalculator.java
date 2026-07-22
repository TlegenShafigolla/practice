public class DeliveryCostCalculator {

    private static final double PRICE_PER_KM = 500;
    private static final double FREE_DELIVERY_ORDER_PRICE = 50_000;

    public static void main(String[] args) {
        double orderPrice = 15_000;
        double distanceKm = 12;
        boolean isPremiumCustomer = false;

        if (!isValid(orderPrice, distanceKm)) {
            System.out.println("Invalid data");
            return;
        }

        double deliveryCost = calculateDeliveryCost(
                orderPrice,
                distanceKm,
                isPremiumCustomer
        );

        double totalPrice = calculateTotalPrice(orderPrice, deliveryCost);

        System.out.println("Order price: " + orderPrice);
        System.out.println("Delivery cost: " + deliveryCost);
        System.out.println("Total price: " + totalPrice);
    }

    private static boolean isValid(
            double orderPrice,
            double distanceKm
    ) {
        return orderPrice >= 0 && distanceKm >= 0;
    }

    private static double calculateDeliveryCost(
            double orderPrice,
            double distanceKm,
            boolean isPremiumCustomer
    ) {
        if (isPremiumCustomer
                || orderPrice >= FREE_DELIVERY_ORDER_PRICE) {
            return 0;
        }

        return distanceKm * PRICE_PER_KM;
    }

    private static double calculateTotalPrice(
            double orderPrice,
            double deliveryCost
    ) {
        return orderPrice + deliveryCost;
    }
}