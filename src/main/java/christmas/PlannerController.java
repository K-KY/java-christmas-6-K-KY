package christmas;

import christmas.view.InputView;

public class PlannerController {

    public void start() {
        Date date = callDate();

    }

    private Date callDate() {
        Date date;
        try {
            int input = InputView.visitDate();
            date = new Date(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            date = callDate();
        }
        return date;
    }
}
