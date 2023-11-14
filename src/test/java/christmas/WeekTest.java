package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.week.Week;
import org.junit.jupiter.api.Test;

public class WeekTest {

    @Test
    void printDayTest() {
        assertThat(Week.isWeekend("일요일")).isFalse();
        assertThat(Week.isWeekend("금요일")).isTrue();
    }

}
