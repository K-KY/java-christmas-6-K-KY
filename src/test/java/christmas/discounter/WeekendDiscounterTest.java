package christmas.discounter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class WeekendDiscounterTest {

    @Test
    void discountTest() {
        WeekendDiscounter discounter = new WeekendDiscounter();
        assertThat(discounter.discount(2, 109000)).isEqualTo(104954);
    }

}
