package christmas.discounter;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Benefit;
import christmas.domain.MenuReceiver;
import christmas.domain.UserOrder;
import christmas.domain.discounter.WeekDayDiscounter;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WeekDayDiscounterTest {
    Benefit benefit = new Benefit();


    @Test
    void orderTest() {

        MenuReceiver menuReceiver = new MenuReceiver(List.of("티본스테이크-1,아이스크림-1,타파스-1".split(",")));
        UserOrder userOrder = menuReceiver.receive();

        WeekDayDiscounter weekDayDiscounter = new WeekDayDiscounter();
        benefit = new Benefit();
        weekDayDiscounter.discount(userOrder, benefit);

        assertThat(benefit.toString()).isEqualTo("평일 할인: -2,023원\n");
    }
}