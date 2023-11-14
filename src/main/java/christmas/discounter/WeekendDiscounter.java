package christmas.discounter;

import christmas.Menu;
import christmas.MenuCategory;
import christmas.OrderedAmount;
import christmas.UserOrder;
import christmas.menus.MainMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeekendDiscounter {

    public static final MenuCategory mainCategory = MainMenu.getMenuCategory();
    private static final List<Integer> amount = new ArrayList<>();
    private static final OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();

    public long discount(UserOrder userOrder) {
        List<Menu> orders = userOrder.orders;
        long mainCount = mainCount(orders);
        orderedAmount.discount(mainCount * 2023);
        return 2023 * mainCount;
    }

    private static long mainCount(List<Menu> orders) {
        orders.stream()
                .filter(order -> order.isMain(mainCategory))
                .map(order -> order.addAmount(amount))
                .collect(Collectors.toList());
        return amount.stream().mapToInt(Integer::intValue).sum();
    }
}
