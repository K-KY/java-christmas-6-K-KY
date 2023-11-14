package christmas.discounter;

import christmas.Date;
import christmas.OrderedAmount;

public class SpecialDiscounter {
    private static final OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();
    private static boolean conditionally = false; // true 일 때 총 금액이 만원 이상
    public int discount(Date date) {
        String day = date.orderedDate();
        if (sunDayOrDay(date, day) && !conditionally) {
            return 1000;
        }

        if (sunDayOrDay(date, day) && orderedAmount.isOverTenThousand()) {
            return 1000;
        }
        return 0;
    }

    private static boolean sunDayOrDay(Date date, String day) {
        return day.equals("일요일") || date.christmasDay();
    }
}
