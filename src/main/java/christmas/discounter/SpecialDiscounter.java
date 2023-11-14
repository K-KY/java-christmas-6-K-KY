package christmas.discounter;

import christmas.Date;
import christmas.OrderedAmount;
import java.text.DecimalFormat;

public class SpecialDiscounter {
    private static final String PRICE_FORMAT = "-###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);
    private static final OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();
    private static boolean conditionally = false; // true 일 때 총 금액이 만원 이상
    public String discount(Date date) {
        String day = date.orderedDate();
        if (sunDayOrDay(date, day) && !conditionally) {
            orderedAmount.discount(1000);
            return "특별 할인: " + MONEY_FORMAT.format(1000);
        }
        if (sunDayOrDay(date, day) && orderedAmount.isOverTenThousand()) {
            orderedAmount.discount(1000);
            return "특별 할인: " + MONEY_FORMAT.format(1000);
        }
        return "";
    }

    private static boolean sunDayOrDay(Date date, String day) {
        return day.equals("일요일") || date.christmasDay();
    }
}
