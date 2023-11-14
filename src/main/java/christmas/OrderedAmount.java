package christmas;

import java.text.DecimalFormat;

public class OrderedAmount {
    private static final String PRICE_FORMAT = "###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);

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

    public boolean present() {
        return totalAmount >= 120000;
    }

    public void discount(long discount) {
        totalDiscount -= discount;
    }

    public String totalAmount() {
        return MONEY_FORMAT.format(totalAmount);
    }
    public String totalDiscount() {
        return MONEY_FORMAT.format(totalDiscount);
    }
}
