package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.discounter.WeekDayDiscounter;
import christmas.week.Week;
import org.junit.jupiter.api.Test;

public class WeekTest {

    @Test
    void printDayTest() {
        assertThat(Week.isWeekend("일요일")).isTrue();
        assertThat(Week.isWeekend("월요일")).isFalse();
    }

}
