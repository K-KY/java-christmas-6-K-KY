package christmas.discounter;

import christmas.Date;
import christmas.OrderedAmount;

public class ChristmasDiscounter {


    public int discount(Date date) {
        if (date.isBeforeChristmas()) {
            return date.discount();
        }
        return 0;
    }
}
