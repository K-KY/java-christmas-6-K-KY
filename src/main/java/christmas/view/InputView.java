package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.DateValidator;

public class InputView {

    public static int visitDate() {
        OutputView.startMessage();
        String input = Console.readLine();
        DateValidator.isNumber(input);
        return Integer.parseInt(input);
    }
}
