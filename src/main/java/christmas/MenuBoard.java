package christmas;

import christmas.menus.AppetizerMenu;
import christmas.menus.BeverageMenu;
import christmas.menus.DessertMenu;
import christmas.menus.MainMenu;
import java.util.ArrayList;
import java.util.List;

public class MenuBoard {
    private static final List<MenuCategory> menuCategories = new ArrayList<>();
    private static final String NEW_LINE = "\n";

    public MenuBoard() {
        menuCategories.clear();
        loadMenuCategory();
    }

    private void loadMenuCategory() {
        menuCategories.add(AppetizerMenu.getMenuCategory());
        menuCategories.add(MainMenu.getMenuCategory());
        menuCategories.add(DessertMenu.getMenuCategory());
        menuCategories.add(BeverageMenu.getMenuCategory());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        menuCategories.forEach(category -> stringBuilder.append(category.toString()).append(NEW_LINE));
        return stringBuilder.toString();
    }

    public boolean find(String order) {
       return menuCategories.stream()
                .map(menuCategory -> menuCategory.isExist(order))
                .filter(result -> result)
                .findFirst().orElse(false);
    }
}
