package christmas.domain.discounter;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.orderinfo.Benefit;
import christmas.domain.orderinfo.Date;
import christmas.domain.orderinfo.OrderedAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpecialDiscountTest {
    private Date date;
    private OrderedAmount orderedAmount;
    @BeforeEach
    void setUp() {
        date = new Date(25);
        orderedAmount = new OrderedAmount();
    }

    @Test
    void staredDate() {
        SpecialDiscounter specialDiscounter =  new SpecialDiscounter(orderedAmount);
        assertThat(specialDiscounter.discount(date, new Benefit())).isEqualTo(1000);
    }

    @Test
    void notStaredDate() {
        SpecialDiscounter specialDiscounter =  new SpecialDiscounter(orderedAmount);
        assertThat(specialDiscounter.discount(date, new Benefit())).isEqualTo(1000);
    }

}
