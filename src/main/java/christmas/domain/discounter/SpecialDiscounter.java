package christmas.domain.discounter;

import christmas.domain.Benefit;
import christmas.domain.Date;
import christmas.domain.OrderedAmount;
import java.text.DecimalFormat;

public class SpecialDiscounter {
    private static final String PRICE_FORMAT = "-###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);

    private static boolean conditionally = false; // true 일 때 총 금액이 만원 이상
    private final OrderedAmount orderedAmount;

    public SpecialDiscounter(OrderedAmount orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public int discount(Date date, Benefit benefit) {
        String day = date.orderedDate();
        if (sunDayOrDay(date, day) && !conditionally) {
            benefit.addBenefit("특별 할인: " + MONEY_FORMAT.format(1000));
            return 1000;
        }
        if (sunDayOrDay(date, day) && orderedAmount.isOverTenThousand()) {
            benefit.addBenefit("특별 할인: " + MONEY_FORMAT.format(1000));
            return 1000;
        }
        return 0;
    }

    private static boolean sunDayOrDay(Date date, String day) {
        return day.equals("일요일") || date.christmasDay();
    }
}
