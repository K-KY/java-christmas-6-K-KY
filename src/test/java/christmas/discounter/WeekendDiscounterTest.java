package christmas.discounter;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuReceiver;
import christmas.domain.UserOrder;
import christmas.domain.discounter.WeekendDiscounter;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WeekendDiscounterTest {

    @Test
    void orderTest() {
        MenuReceiver menuReceiver = new MenuReceiver(List.of("티본스테이크-1,아이스크림-1,타파스-1".split(",")));
        UserOrder userOrder = menuReceiver.receive();

        WeekendDiscounter weekendDiscounter = new WeekendDiscounter();
        weekendDiscounter.discount(userOrder);
    }
}
