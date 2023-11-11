package christmas.menus;

import christmas.MenuBoard;
import java.util.HashMap;
import java.util.List;

public enum AppetizerMenu {
    MUSHROOM_SOUP("양송이 수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저 샐러드", 8_000);


    private static final String MENU_TYPE = "애피타이저";
    private static final HashMap<String, Integer> menuBoard = new HashMap<>();
    private final String menuName;
    private final int price;

    AppetizerMenu(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    private static void setMenuBoard() {
        List<AppetizerMenu> menus = List.of(AppetizerMenu.values());
        menus.forEach(menu -> menuBoard.put(menu.menuName, menu.price));
    }

    public static MenuBoard getBoard() {
        if (menuBoard.isEmpty()) {
            setMenuBoard();
        }
        return new MenuBoard(menuBoard, MENU_TYPE);
    }
}
