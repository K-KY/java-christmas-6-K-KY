package christmas;

import christmas.menus.BeverageMenu;
import christmas.validator.OrderValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class UserOrder {
    public final List<Menu> orders;

    public UserOrder(List<Menu> orders) {
        this.orders = orders;
        OrderValidator.isAmountInRange(checkAmount());
        OrderValidator.isOnlyBeverage(onlyBeverage());
        orders.forEach(Menu::addPrice);
    }

    private int checkAmount() {
        List<Integer> amounts = new ArrayList<>();
        orders.forEach(menu -> menu.addAmount(amounts));

        return amounts.stream().mapToInt(Integer::intValue).sum();
    }


    private boolean onlyBeverage() {
        MenuCategory beverageCategory = BeverageMenu.getMenuCategory();

        return orders.stream().
                map(order -> order.isBeverage(beverageCategory))
                .filter(result -> !result)
                .findFirst().orElse(true);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        orders.forEach(order -> stringJoiner.add(order.toString()));
        return stringJoiner.toString();
    }
}
