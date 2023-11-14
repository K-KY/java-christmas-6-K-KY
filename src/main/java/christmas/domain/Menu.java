package christmas.domain;

import christmas.domain.validator.OrderValidator;
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

    public int getPrice() {
        return menuPrice() * amount;
    }

    public List<Integer> addAmount(List<Integer> amounts) {
        amounts.add(amount);
        return amounts;
    }

    public boolean isBeverage(MenuCategory beverageCategory) {
        return beverageCategory.isExist(menuName);
    }

    private int menuPrice() {
        return new MenuBoard().findPrice(menuName);
    }

    public boolean isDessert(MenuCategory dessertCategory) {
        return dessertCategory.isExist(menuName);
    }
    public boolean isMain(MenuCategory mainCategory) {
        return mainCategory.isExist(menuName);
    }

    @Override
    public String toString() {
        return menuName + " "+ amount + "개" + "\n";
    }
}
