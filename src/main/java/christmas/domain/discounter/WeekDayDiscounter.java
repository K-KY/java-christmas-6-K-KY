package christmas.domain.discounter;

import christmas.domain.Benefit;
import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.UserOrder;
import christmas.domain.menus.DessertMenu;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeekDayDiscounter {
    private static final String PRICE_FORMAT = "-###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);
    private static final MenuCategory dessertCategory = DessertMenu.getMenuCategory();

    public int discount(UserOrder userOrder, Benefit benefit) {
        List<Menu> orders = userOrder.orders;
        long dessertCount = dessertCount(orders);
        if (dessertCount == 0) {
            return 0;
        }
        benefit.addBenefit("평일 할인: " + MONEY_FORMAT.format(2023 * dessertCount));
        return (int) dessertCount * 2023;
    }

    private static long dessertCount(List<Menu> orders) {
        List<Integer> amount = new ArrayList<>();
        orders.stream()
                .filter(order -> order.isDessert(dessertCategory))
                .map(order -> order.addAmount(amount))
                .collect(Collectors.toList());
        return amount.stream().mapToInt(Integer::intValue).sum();
    }

}
