package christmas.discounter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class WeekDayDiscounterTest {

    @Test
    void discountTest() {
        WeekDayDiscounter discounter = new WeekDayDiscounter();
        assertThat(discounter.discount(10, 50000)).isEqualTo(29770);
        assertThat(discounter.discount(1, 5000)).isEqualTo(5000);
    }
}