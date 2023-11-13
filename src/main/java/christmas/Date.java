package christmas;

import christmas.validator.DateValidator;

public class Date {
    private final int date;

    public Date(int date) {
        DateValidator.isInRange(date);
        this.date = date;
    }
}
