package christmas.domain.discounter;

import christmas.domain.Benefit;
import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.OrderedAmount;
import christmas.domain.UserOrder;
import christmas.domain.menus.MainMenu;
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
    private static final Benefit benefit = Benefit.getBenefit();

    public void discount(UserOrder userOrder) {
        List<Menu> orders = userOrder.orders;
        long mainCount = mainCount(orders);
        if (mainCount == 0) {
            return;
        }
        orderedAmount.discount(mainCount * 2023);
        benefit.addBenefit("주말 할인: " + MONEY_FORMAT.format(2023 * mainCount));
    }

    private static long mainCount(List<Menu> orders) {
        orders.stream()
                .filter(order -> order.isMain(mainCategory))
                .map(order -> order.addAmount(amount))
                .collect(Collectors.toList());
        return amount.stream().mapToInt(Integer::intValue).sum();
    }
}