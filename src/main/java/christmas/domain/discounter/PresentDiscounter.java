package christmas.domain.discounter;

import christmas.domain.OrderedAmount;

public class PresentDiscounter {
    private final OrderedAmount orderedAmount;

    public PresentDiscounter(OrderedAmount orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public String discount() {
        if (orderedAmount.present()) {
            return "샴페인 1개";
        }
        return "";
    }
}
