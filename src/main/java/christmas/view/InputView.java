package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.MenuBoard;
import christmas.domain.validator.DateValidator;

public class InputView {

    public static int visitDate() {
        OutputView.startMessage();
        String input = Console.readLine();
        DateValidator.isNumber(input);
        return Integer.parseInt(input);
    }

    public static String orderMenu(MenuBoard menuBoard) {
        OutputView.menuAndAmount(menuBoard);
        String input = Console.readLine();

        return input.replace(" ", "");
    }
}
