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

public class UserOrderTest {
    private List<MenuCategory> menuCategories = new ArrayList<>();

    @BeforeEach
    void setUp() {
        menuCategories.add(AppetizerMenu.getMenuCategory());
        menuCategories.add(BeverageMenu.getMenuCategory());
        menuCategories.add(DessertMenu.getMenuCategory());
        menuCategories.add(MainMenu.getMenuCategory());
    }

    @Test
    void userOrderAmount() {
        Menu menu = new Menu("아이스크림", 10, menuCategories);
        assertThatCode(() -> new UserOrder(List.of(menu)))
                .doesNotThrowAnyException();
    }

    @Test
    void userOrderBigAmount() {
        Menu menu = new Menu("아이스크림", 19, menuCategories);
        Menu menu2 = new Menu("초코케이크", 19, menuCategories);
        assertThatThrownBy(() -> new UserOrder(List.of(menu, menu2)))
                .isInstanceOf(IllegalStateException.class);
    }
    @Test
    void userOrderOnlyBeverage() {
        Menu menu = new Menu("제로콜라", 19, menuCategories);
        assertThatThrownBy(() -> new UserOrder(List.of(menu)))
                .isInstanceOf(IllegalStateException.class);
    }
}
