package christmas.domain.discounter;

import christmas.domain.OrderedAmount;

public class PresentDiscounter {
    OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();

    public String discount() {
        if (orderedAmount.present()) {
            return "샴패인 1개";
        }
        return "";
    }
}
