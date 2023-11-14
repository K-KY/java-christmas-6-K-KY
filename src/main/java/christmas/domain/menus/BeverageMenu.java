package christmas.domain.menus;
/*<애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
*/

import christmas.domain.MenuCategory;
import java.util.HashMap;
import java.util.List;

public enum BeverageMenu {
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    private static final HashMap<String, Integer> categoryMenu = new HashMap<>();
    private static final String MENU_TYPE = "음료";
    private static  MenuCategory category;
    private final int price;
    private final String menuName;

    BeverageMenu(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    private static void setCategoryMenu() {
        List<BeverageMenu> menus = List.of(BeverageMenu.values());
        menus.forEach(menu -> categoryMenu.put(menu.menuName, menu.price));
        category = new MenuCategory(categoryMenu, MENU_TYPE);
    }

    public static MenuCategory getMenuCategory() {
        if (categoryMenu.isEmpty()) {
            setCategoryMenu();
        }
        return category;
    }
}