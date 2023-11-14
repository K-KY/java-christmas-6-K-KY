package christmas.controller;

import christmas.domain.discounter.PresentDiscounter;
import christmas.domain.Benefit;
import christmas.domain.Date;
import christmas.domain.MenuBoard;
import christmas.domain.MenuReceiver;
import christmas.domain.OrderedAmount;
import christmas.domain.UserOrder;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.domain.week.Week;
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
        new DiscountController().calculateDiscount(date, userOrder);
        OutputView.discountHistory(Benefit.getBenefit().toString());;
        OutputView.totalDiscount();
        OutputView.afterDiscount(orderedAmount.afterDiscount());
        OutputView.grantedBadge(orderedAmount.getBadge());
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



    private String presentDiscount() {
        PresentDiscounter presentDiscounter = new PresentDiscounter();
        return presentDiscounter.discount();
    }
}
