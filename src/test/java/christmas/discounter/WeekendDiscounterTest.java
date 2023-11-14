package christmas.discounter;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Benefit;
import christmas.domain.MenuReceiver;
import christmas.domain.UserOrder;
import christmas.domain.discounter.WeekendDiscounter;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WeekendDiscounterTest {

    @Test
    void orderTest() {
        Benefit benefit = new Benefit();
        MenuReceiver menuReceiver = new MenuReceiver(List.of("티본스테이크-1,아이스크림-1,타파스-1".split(",")));
        UserOrder userOrder = menuReceiver.receive();

        WeekendDiscounter weekendDiscounter = new WeekendDiscounter();
        weekendDiscounter.discount(userOrder, benefit);

        assertThat(benefit.toString()).isEqualTo("주말 할인: -2,023원\n");
    }
}
