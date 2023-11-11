package christmas.menus;

import christmas.MenuBoard;
import java.util.HashMap;
import java.util.List;

public enum DessertMenu {
    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000);

    private static final HashMap<String, Integer> menuBoard = new HashMap<>();
    private static final String MENU_TYPE = "디저트";
    private final String menuName;
    private final int price;

    DessertMenu(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    private static void setMenuBoard() {
        List<DessertMenu> menus = List.of(DessertMenu.values());
        menus.forEach(menu -> menuBoard.put(menu.menuName, menu.price));
    }

    public static MenuBoard getMenuBoard() {//Category로 변경
        if (menuBoard.isEmpty()) {
            setMenuBoard();
        }
        return new MenuBoard(menuBoard, MENU_TYPE);
    }
}
