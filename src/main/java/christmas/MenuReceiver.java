package christmas;

import christmas.validator.OrderValidator;
import java.util.ArrayList;
import java.util.List;

public class MenuReceiver {
    private final List<String> orders;

    public MenuReceiver(List<String> orders) {
        this.orders = orders;
    }

    public UserOrder receive() {
        List<Menu> menus = new ArrayList<>();
        orders.forEach(order -> {
            menus.add(order(order));
        });
        return new UserOrder(menus);
    }

    private int amountConverter(String amount) {
        OrderValidator.isValidAmount(amount);
        return Integer.parseInt(amount);
    }

    private Menu order(String order) {
        List<String> userOrder = List.of(order.split("-"));
        return new Menu(userOrder.get(0), amountConverter(userOrder.get(1)));
    }
}
