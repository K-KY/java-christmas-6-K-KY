package christmas.domain.discounter;

import christmas.domain.Benefit;
import christmas.domain.Date;
import christmas.domain.OrderedAmount;
import java.text.DecimalFormat;

public class ChristmasDiscounter {
    private static final String PRICE_FORMAT = "-###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);
    private static final String CHRISTMAS_DISCOUNT = "크리스마스 디데이 할인: ";
    private static final int ZERO = 0;
    private final OrderedAmount orderedAmount;

    public ChristmasDiscounter(OrderedAmount orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public int discount(Date date, Benefit benefit) {
        if (date.isBeforeChristmas() && orderedAmount.isOverTenThousand()) {
            benefit.addBenefit(CHRISTMAS_DISCOUNT + MONEY_FORMAT.format(date.discount()));
            return date.discount();
        }
        return ZERO;
    }
}
