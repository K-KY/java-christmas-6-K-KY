package christmas.validator;

import christmas.MenuCategory;
import java.util.List;

public class OrderValidator {

    private static final String DIGIT = "[0-9]+";

    public static void isExist(String order, List<MenuCategory> menus) {
        if (checkMenu(order, menus)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private static Boolean checkMenu(String order, List<MenuCategory> menus) {
        return menus.stream()
                .map(menu -> menu.isExist(order))
                .filter(result -> result)
                .findFirst().orElse(false);
    }

    public static void isValidAmount(String amount) {
        if (amount.matches(DIGIT)) {
            return;
        }
        throw new IllegalStateException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    public static void isAmountInRange(int amount) {
        if (amount >= 21 || amount <= 0) {
            throw new IllegalStateException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void isOnlyBeverage(boolean onlyBeverage) {
        if (onlyBeverage) {
            throw new IllegalStateException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
