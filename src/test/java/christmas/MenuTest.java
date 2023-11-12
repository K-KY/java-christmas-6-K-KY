package christmas;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.menus.AppetizerMenu;
import christmas.menus.BeverageMenu;
import christmas.menus.DessertMenu;
import christmas.menus.MainMenu;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest {
    private List<MenuCategory> menuCategories = new ArrayList<>();

    @BeforeEach
    void setUp() {
        menuCategories.add(AppetizerMenu.getMenuCategory());
        menuCategories.add(BeverageMenu.getMenuCategory());
        menuCategories.add(DessertMenu.getMenuCategory());
        menuCategories.add(MainMenu.getMenuCategory());
    }

    @Test
    void notExistMenu() {
        assertThatThrownBy(() -> new Menu("고등어", 1, menuCategories))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void existMenu() {
        assertThatCode(() -> new Menu("아이스크림", 1, menuCategories))
                .doesNotThrowAnyException();
    }

    @Test
    void bigAmount() {
        assertThatThrownBy(() -> new Menu("아이스크림", 99, menuCategories))
                .isInstanceOf(IllegalStateException.class);
    }
}
