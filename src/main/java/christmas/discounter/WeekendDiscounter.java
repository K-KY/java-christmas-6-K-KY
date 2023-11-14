package christmas.discounter;

import christmas.Menu;
import christmas.MenuCategory;
import christmas.OrderedAmount;
import christmas.UserOrder;
import christmas.menus.MainMenu;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeekendDiscounter {
    private static final String PRICE_FORMAT = "-###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);
    public static final MenuCategory mainCategory = MainMenu.getMenuCategory();
    private static final List<Integer> amount = new ArrayList<>();
    private static final OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();

    public String discount(UserOrder userOrder) {
        List<Menu> orders = userOrder.orders;
        long mainCount = mainCount(orders);
        if (mainCount == 0) {
            return "";
        }
        orderedAmount.discount(mainCount * 2023);
        return "주말 할인: " + MONEY_FORMAT.format(2023 * mainCount);
    }

    private static long mainCount(List<Menu> orders) {
        orders.stream()
                .filter(order -> order.isMain(mainCategory))
                .map(order -> order.addAmount(amount))
                .collect(Collectors.toList());
        return amount.stream().mapToInt(Integer::intValue).sum();
    }
}
