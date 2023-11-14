package christmas;

public class OrderedAmount {

    private static OrderedAmount orderedAmount;
    private static int totalAmount = 0;
    private static int totalDiscount = 0;
    private OrderedAmount(){}

    public static OrderedAmount getOrderedAmount(int amount) {
        if (orderedAmount == null) {
            orderedAmount = new OrderedAmount();
        }
        totalAmount+= amount;
        return orderedAmount;
    }
    public static OrderedAmount getOrderedAmount() {
        if (orderedAmount == null) {
            orderedAmount = new OrderedAmount();
        }
        return orderedAmount;
    }

    public boolean isOverTenThousand() {
        return totalAmount >= 10000;
    }

    public void discount(long discount) {
        totalDiscount -= discount;
    }
}
