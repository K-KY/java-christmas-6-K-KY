package christmas.discounter;

import christmas.OrderedAmount;

public class PresentDiscounter {
    OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();

    public String discount() {
        if (orderedAmount.present()) {
            return "샴패인 1개";
        }
        return "";
    }
}
