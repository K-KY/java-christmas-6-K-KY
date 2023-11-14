package christmas.discounter;

import christmas.Date;
import christmas.OrderedAmount;

public class ChristmasDiscounter {
    private static final OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();

    public int discount(Date date) {
        if (date.isBeforeChristmas() && orderedAmount.isOverTenThousand()) {
            orderedAmount.discount(date.discount());
            return date.discount();
        }
        return 0;
    }
}
