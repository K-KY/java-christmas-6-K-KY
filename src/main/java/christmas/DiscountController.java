package christmas;

import christmas.discounter.ChristmasDiscounter;
import christmas.discounter.SpecialDiscounter;
import christmas.discounter.WeekDayDiscounter;
import christmas.discounter.WeekendDiscounter;

public class DiscountController {


    private static final OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();
    public void calculateDiscount(Date date, UserOrder userOrder) {
        boolean weekend = date.isWeekend();
        weekDiscount(userOrder, weekend);
        specialDiscount(date);
        christmasDiscount(date);

    }

    private void weekDiscount(UserOrder userOrder, boolean weekend) {
        if (orderedAmount.isOverTenThousand()) {
            weekendDiscount(weekend, userOrder);
        }
    }

    private void weekendDiscount(boolean weekend, UserOrder userOrder) {
        if (weekend) {
            WeekendDiscounter weekendDiscounter = new WeekendDiscounter();
            weekendDiscounter.discount(userOrder);
        }
        weekDayDiscount(userOrder);
    }

    private void weekDayDiscount(UserOrder userOrder) {
        WeekDayDiscounter weekDayDiscounter = new WeekDayDiscounter();
        weekDayDiscounter.discount(userOrder);
    }

    private void specialDiscount(Date date) {
        SpecialDiscounter specialDiscounter = new SpecialDiscounter();
        specialDiscounter.discount(date);
    }

    private void christmasDiscount(Date date) {
        ChristmasDiscounter christmasDiscounter = new ChristmasDiscounter();
        christmasDiscounter.discount(date);
    }


}