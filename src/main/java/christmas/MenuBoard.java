package christmas;

import java.util.HashMap;

public class MenuBoard {
    private final String menuType;
    private final HashMap<String, Integer> menuBoard;

    public MenuBoard(HashMap<String, Integer> menuBoard, String menuType) {
        this.menuBoard = menuBoard;
        this.menuType = menuType;
    }
}
