package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.MenuCategory;
import christmas.menus.AppetizerMenu;
import christmas.menus.BeverageMenu;
import christmas.menus.DessertMenu;
import christmas.menus.MainMenu;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderValidateTest {
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
        assertThatThrownBy(() -> OrderValidator.isExist("개나리", menuCategories))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void existMenu() {
        assertThatCode(() -> OrderValidator.isExist("티본스테이크", menuCategories))
                .doesNotThrowAnyException();
    }

    @Test
    void inValidAmount() {
        assertThatThrownBy(() -> OrderValidator.isValidAmount("q"))
                .isInstanceOf(IllegalStateException.class);
    }
    @Test
    void validAmount() {
        assertThatCode(() -> OrderValidator.isValidAmount("20"))
                .doesNotThrowAnyException();
    }

    @Test
    void isAmountInRange() {
        assertThatCode(() -> OrderValidator.isAmountInRange(20))
                .doesNotThrowAnyException();
    }
    @Test
    void isNotAmountInRange() {
        assertThatThrownBy(() -> OrderValidator.isAmountInRange(21))
                .isInstanceOf(IllegalStateException.class);
    }
}
