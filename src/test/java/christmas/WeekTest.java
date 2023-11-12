package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.discounter.WeekDayDiscounter;
import org.junit.jupiter.api.Test;

public class WeekTest {

    @Test
    void printDayTest() {
        WeekDayDiscounter weekDayDiscounter = new WeekDayDiscounter();
        assertThat(weekDayDiscounter.orderDay(10)).isTrue();//일요일
        assertThat(weekDayDiscounter.orderDay(11)).isFalse();//월요일
    }

}
