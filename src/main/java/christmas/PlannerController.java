package christmas;

import christmas.view.InputView;
import java.util.List;

public class PlannerController {
    public static final MenuBoard menuBoard = new MenuBoard();

    public void start() {
        Date date = callDate();
        UserOrder userOrder = callUserOrder();
    }

    private UserOrder callUserOrder() {
        UserOrder userOrder;
        try {
            String userMenu = InputView.orderMenu(menuBoard);
            MenuReceiver menuReceiver = new MenuReceiver(List.of(userMenu.split(",")));
            userOrder = menuReceiver.receive();
        } catch (RuntimeException e) {
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
}
