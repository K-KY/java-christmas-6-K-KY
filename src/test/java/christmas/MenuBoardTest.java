package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.menus.AppetizerMenu;
import christmas.menus.BeverageMenu;
import christmas.menus.DessertMenu;
import christmas.menus.MainMenu;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuBoardTest {

    @Test
    @DisplayName("애피타이저 메뉴를 MenuBoard 클래스에 넣어 리턴한다")
    void menuBoardTest_APPETIZER() {
        assertThat(AppetizerMenu.getBoard())
                .isInstanceOf(MenuBoard.class);
    }

    @Test
    @DisplayName("음료 메뉴를 MenuBoard 클래스에 넣어 리턴한다")
    void menuBoardTest_BEVERAGE() {
        assertThat(BeverageMenu.getMenuBoard())
                .isInstanceOf(MenuBoard.class);
    }

    @Test
    @DisplayName("메인메뉴를 MenuBoard 클래스에 넣어 리턴한다")
    void menuBoardTest_MAIN() {
        assertThat(MainMenu.getMenuBoard())
                .isInstanceOf(MenuBoard.class);
    }

    @Test
    @DisplayName("디저트메뉴를 MenuBoard 클래스에 넣어 리턴한다")
    void menuBoardTest_DESSERT() {
        assertThat(DessertMenu.getMenuBoard())
                .isInstanceOf(MenuBoard.class);
    }

    @Test
    @DisplayName("메인 메뉴를 리턴한다")
    void printMainMenuTest() {
        System.out.println(MainMenu.getMenuBoard());
        assertThat(MainMenu.getMenuBoard().toString())
                .isEqualTo("<메인>\n"
                        + "티본스테이크(55,000), 해산물파스타(35,000), 바베큐립(54,000), 크리스마스파스타(25,000)");
    }

    @Test
    @DisplayName("애피타이저 메뉴를 리턴한다")
    void printAppetizerMenuTest() {
        System.out.println(AppetizerMenu.getBoard());
        assertThat(AppetizerMenu.getBoard().toString())
                .isEqualTo("<애피타이저>\n"
                        + "양송이 수프(6,000), 타파스(5,500), 시저 샐러드(8,000)");
    }

    @Test
    @DisplayName("음료 메뉴를 리턴한다")
    void printBeverageMenuTest() {
        System.out.println(BeverageMenu.getMenuBoard());
        assertThat(BeverageMenu.getMenuBoard().toString())
                .isEqualTo("<음료>\n"
                        + "제로콜라(3,000), 샴페인(25,000), 레드와인(60,000)");
    }

    @Test
    @DisplayName("디저트 메뉴를 리턴한다")
    void printDessertMenuTest() {
        System.out.println(DessertMenu.getMenuBoard());
        assertThat(DessertMenu.getMenuBoard().toString())
                .isEqualTo("<디저트>\n"
                        + "아이스크림(5,000), 초코케이크(15,000)");
    }
}
