package christmas;

import christmas.validator.DateValidator;
import christmas.week.Week;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Date {
    private static final LocalDate eventStart = LocalDate.of(2023, 12, 1);

    private final int date;

    public Date(int date) {
        DateValidator.isInRange(date);
        this.date = date;
    }

    public String orderedDate() {
        LocalDate orderedDate = eventStart.plusDays(date - 1);
        DayOfWeek futureDayOfWeek = orderedDate.getDayOfWeek();

        return futureDayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);
    }

    public boolean isBeforeChristmas() {
        return date <= 25;
    }

    public int discount() {
        return 1000 + ((date - 1) * 100);
    }

    public boolean christmasDay() {
        return date == 25;
    }

    public boolean isWeekend() {
        return Week.isWeekend(orderedDate());
    }
}
