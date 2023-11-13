package christmas;

import christmas.validator.OrderValidator;
import java.util.List;

public class Menu {
    private final String menuName;
    private final int amount;

    public Menu(String menuName, int amount) {
        OrderValidator.isExist(menuName);
        OrderValidator.isAmountInRange(amount);

        this.menuName = menuName;
        this.amount = amount;
    }

    public List<Integer> addAmount(List<Integer> amounts) {
        amounts.add(amount);
        return amounts;
    }

    public boolean isBeverage(MenuCategory beverageCategory) {
        return beverageCategory.isExist(menuName);
    }
}
