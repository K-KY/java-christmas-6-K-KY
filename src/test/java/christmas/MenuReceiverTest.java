package christmas;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class MenuReceiverTest {

    @Test
    void normalCase() {
        List<String> orders = List.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1".split(","));
        MenuReceiver menuReceiver = new MenuReceiver();
        assertThatCode(() -> menuReceiver.receive(orders))
                .doesNotThrowAnyException();
    }

    @Test
    void onlyBeverage() {
        List<String> orders = List.of("제로콜라-1".split(","));
        MenuReceiver menuReceiver = new MenuReceiver();
        assertThatThrownBy(() -> menuReceiver.receive(orders))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void overOrdered() {
        List<String> orders = List.of("티본스테이크-21".split(","));
        MenuReceiver menuReceiver = new MenuReceiver();
        assertThatThrownBy(() -> menuReceiver.receive(orders))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void overOrdered_case2() {
        List<String> orders = List.of("티본스테이크-10,아이스크림-11".split(","));
        MenuReceiver menuReceiver = new MenuReceiver();
        assertThatThrownBy(() -> menuReceiver.receive(orders))
                .isInstanceOf(IllegalStateException.class);
    }
}
