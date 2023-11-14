package christmas.discounter;

import christmas.Benefit;
import christmas.Date;
import christmas.OrderedAmount;
import java.text.DecimalFormat;

public class ChristmasDiscounter {
    private static final String PRICE_FORMAT = "-###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);
    private static final Benefit benefit = Benefit.getBenefit();
    private static final OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();

    public void discount(Date date) {
        if (date.isBeforeChristmas() && orderedAmount.isOverTenThousand()) {
            orderedAmount.discount(date.discount());
            benefit.addBenefit("크리스마스 디데이 할인: "+ MONEY_FORMAT.format(date.discount()));
        }
    }
}
