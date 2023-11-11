package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.menus.AppetizerMenu;
import christmas.menus.BeverageMenu;
import christmas.menus.DessertMenu;
import christmas.menus.MainMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuBoardTest {

    @Test
    @DisplayName("애피타이저 메뉴를 MenuBoard 클래스에 넣어 리턴한다.")
    void menuBoardTest_APPETIZER() {
        assertThat(AppetizerMenu.getBoard()).isInstanceOf(MenuBoard.class);
    }

    @Test
    @DisplayName("음료 메뉴를 MenuBoard 클래스에 넣어 리턴한다.")
    void menuBoardTest_BEVERAGE() {
        assertThat(BeverageMenu.getMenuBoard()).isInstanceOf(MenuBoard.class);
    }

    @Test
    @DisplayName("메인메뉴를 MenuBoard 클래스에 넣어 리턴한다.")
    void menuBoardTest_MAIN() {
        assertThat(MainMenu.getMenuBoard()).isInstanceOf(MenuBoard.class);
    }

    @Test
    @DisplayName("디저트메뉴를 MenuBoard 클래스에 넣어 리턴한다.")
    void menuBoardTest_DESSERT() {
        assertThat(DessertMenu.getMenuBoard()).isInstanceOf(MenuBoard.class);
    }
}
