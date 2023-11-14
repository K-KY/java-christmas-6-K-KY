package christmas.discounter;

import christmas.Benefit;
import christmas.Menu;
import christmas.MenuCategory;
import christmas.OrderedAmount;
import christmas.UserOrder;
import christmas.menus.DessertMenu;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeekDayDiscounter {
    private static final String PRICE_FORMAT = "-###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);
    private static final MenuCategory dessertCategory = DessertMenu.getMenuCategory();
    private static final List<Integer> amount = new ArrayList<>();
    private static final OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();
    private static final Benefit benefit = Benefit.getBenefit();
    public void discount(UserOrder userOrder) {
        List<Menu> orders = userOrder.orders;
        long dessertCount = dessertCount(orders);
        if (dessertCount == 0) {
            return;
        }
        orderedAmount.discount(dessertCount * 2023);

        benefit.addBenefit("평일 할인: " + MONEY_FORMAT.format(2023 * dessertCount));
    }

    private static long dessertCount(List<Menu> orders) {
        orders.stream()
                .filter(order -> order.isDessert(dessertCategory))
                .map(order -> order.addAmount(amount))
                .collect(Collectors.toList());
        return amount.stream().mapToInt(Integer::intValue).sum();
    }

}
