package christmas;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.StringJoiner;

public class MenuBoard {
    private static final String NEW_LINE = "\n";
    private static final String PRICE_FORMAT = "(###,###)";
    private static final String LESS_THAN = "<";
    private static final String GRATER_THAN = ">";
    private static final String COMMA = ", ";
    private static final int CLEAR = 0;
    private static final DecimalFormat content = new DecimalFormat(PRICE_FORMAT);
    private static final StringBuilder contentWrapper = new StringBuilder();

    private final String menuType;
    private final HashMap<String, Integer> menuBoard;

    public MenuBoard(HashMap<String, Integer> menuBoard, String menuType) {
        this.menuBoard = menuBoard;
        this.menuType = menuType;
    }

    @Override
    public String toString() {
        StringJoiner menuJoiner = new StringJoiner(COMMA);
        String category = wrapContent(menuType) + NEW_LINE;
        menuBoard.forEach(
                (String menuName, Integer price) -> menuJoiner.add(menuName + wrapContent(price))
        );
        return category + menuJoiner;
    }

    private String wrapContent(int price) {
        return content.format(price);
    }

    private String wrapContent(String category) {
        contentWrapper.setLength(CLEAR);
        contentWrapper.append(LESS_THAN).append(category).append(GRATER_THAN);
        return contentWrapper.toString();
    }
}
