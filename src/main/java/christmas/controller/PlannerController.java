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
import java.util.List;

public class PlannerController {
    private static final MenuBoard menuBoard = new MenuBoard();
    private static final OrderedAmount orderedAmount = new OrderedAmount();

    public void start() {
        Date date = callDate();
        UserOrder userOrder = callUserOrder();
        OutputView.orderContent(userOrder);
        userOrder.addMenuPrice(orderedAmount);
        result(date, userOrder);
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

    private void result(Date date, UserOrder userOrder) {
        OutputView.totalAmount(orderedAmount.totalAmount());
        OutputView.present(presentDiscount());
        Benefit benefit = new DiscountController(orderedAmount).calculateDiscount(date, userOrder);
        OutputView.discountHistory(benefit.toString());
        OutputView.totalDiscount(orderedAmount.totalDiscount());
        OutputView.afterDiscount(orderedAmount.afterDiscount());
        OutputView.grantedBadge(orderedAmount.getBadge());
    }

    private String presentDiscount() {
        PresentDiscounter presentDiscounter = new PresentDiscounter(orderedAmount);
        return presentDiscounter.discount();
    }
}
