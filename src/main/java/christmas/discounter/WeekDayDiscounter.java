package christmas.discounter;

import christmas.Menu;
import christmas.MenuCategory;
import christmas.UserOrder;
import christmas.menus.DessertMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeekDayDiscounter {
    private static final MenuCategory dessertCategory = DessertMenu.getMenuCategory();
    private static final List<Integer> amount = new ArrayList<>();

    public long discount(UserOrder userOrder) {
        List<Menu> orders = userOrder.orders;
        long dessertCount = dessertCount(orders);
        System.out.println(dessertCount);
        return 2023 * dessertCount;
    }

    private static long dessertCount(List<Menu> orders) {
        orders.stream()
                .filter(order -> order.isDessert(dessertCategory))
                .map(order -> order.addAmount(amount))
                .collect(Collectors.toList());
        return amount.stream().mapToInt(Integer::intValue).sum();
    }

}
