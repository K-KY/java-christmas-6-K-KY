package christmas;

import christmas.discounter.ChristmasDiscounter;
import christmas.discounter.PresentDiscounter;
import christmas.discounter.SpecialDiscounter;
import christmas.discounter.WeekDayDiscounter;
import christmas.discounter.WeekendDiscounter;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.week.Week;
import java.util.List;

public class PlannerController {
    private static final MenuBoard menuBoard = new MenuBoard();
    private static final OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();

    public void start() {
        Date date = callDate();
        UserOrder userOrder = callUserOrder();
        boolean weekend = Week.isWeekend(date.orderedDate());
        OutputView.orderContent(userOrder);
        OutputView.totalAmount();
        OutputView.present(presentDiscount());
        discountHistory(date, userOrder, weekend);
        OutputView.totalDiscount();
        OutputView.afterDiscount(orderedAmount.afterDiscount());
        OutputView.grantedBadge(orderedAmount.getBadge());
    }

    private void discountHistory(Date date, UserOrder userOrder, boolean weekend) {
        System.out.println("<혜택 내역>");
        if (orderedAmount.noDiscount()) {
            System.out.println("없음");
        }
        OutputView.discountHistory(weekDiscount(userOrder, weekend));
        OutputView.discountHistory(christmasDiscount(date));
        OutputView.discountHistory(specialDiscount(date));
        System.out.println();
    }

    private String specialDiscount(Date date) {
        SpecialDiscounter specialDiscounter = new SpecialDiscounter();
        return specialDiscounter.discount(date);
    }

    private String christmasDiscount(Date date) {
        ChristmasDiscounter christmasDiscounter = new ChristmasDiscounter();
        return christmasDiscounter.discount(date);
    }

    private UserOrder callUserOrder() {
        UserOrder userOrder;
        try {
            String userMenu = InputView.orderMenu(menuBoard);
            MenuReceiver menuReceiver = new MenuReceiver(List.of(userMenu.split(",")));
            userOrder = menuReceiver.receive();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            userOrder = callUserOrder();
        }
        return userOrder;
    }

    private Date callDate() {
        Date date;
        try {
            int input = InputView.visitDate();
            date = new Date(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            date = callDate();
        }
        return date;
    }

    private String weekDiscount(UserOrder userOrder, boolean weekend) {
        if (orderedAmount.isOverTenThousand()) {
            return weekendDiscount(weekend, userOrder);
        }
        return "";
    }

    private String weekendDiscount(boolean weekend, UserOrder userOrder) {
        if (weekend) {
            WeekendDiscounter weekendDiscounter = new WeekendDiscounter();
            return weekendDiscounter.discount(userOrder);
        }
        return weekDayDiscount(userOrder);
    }

    private String weekDayDiscount(UserOrder userOrder) {
        WeekDayDiscounter weekDayDiscounter = new WeekDayDiscounter();
        return weekDayDiscounter.discount(userOrder);
    }

    private String presentDiscount() {
        PresentDiscounter presentDiscounter = new PresentDiscounter();
        return presentDiscounter.discount();
    }
}
