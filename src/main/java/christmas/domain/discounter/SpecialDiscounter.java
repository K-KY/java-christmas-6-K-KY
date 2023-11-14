package christmas.domain.discounter;

import christmas.domain.Benefit;
import christmas.domain.Date;
import christmas.domain.OrderedAmount;
import java.text.DecimalFormat;

public class SpecialDiscounter {
    private static final String PRICE_FORMAT = "-###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);
    private static final String SPECIAL_DISCOUNT = "특별 할인: ";
    private static final int DISCOUNT = 1000;
    private static final int DEFAULT = 0;
    private static final String SUNDAY = "일요일";

    private static boolean conditionally = false; // true 일 때 총 금액이 만원 이상
    private final OrderedAmount orderedAmount;

    public SpecialDiscounter(OrderedAmount orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public int discount(Date date, Benefit benefit) {
        String day = date.orderedDate();
        if (sundayOrDay(date, day) && !conditionally) {
            benefit.addBenefit(SPECIAL_DISCOUNT + MONEY_FORMAT.format(DISCOUNT));
            return DISCOUNT;
        }
        if (sundayOrDay(date, day) && orderedAmount.isOverTenThousand()) {
            benefit.addBenefit(SPECIAL_DISCOUNT + MONEY_FORMAT.format(DISCOUNT));
            return DISCOUNT;
        }
        return DEFAULT;
    }

    public static boolean sundayOrDay(Date date, String day) {
        return day.equals(SUNDAY) || date.christmasDay();
    }
}
