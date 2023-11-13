package christmas;

public class OrderedAmount {

    private static OrderedAmount orderedAmount;
    private static int totalAmount = 0;
    private OrderedAmount(){}

    public static OrderedAmount getOrderedAmount(int amount) {
        if (orderedAmount == null) {
            orderedAmount = new OrderedAmount();
        }
        totalAmount+= amount;
        System.out.println(totalAmount);
        return orderedAmount;
    }

}
