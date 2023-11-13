package christmas;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    void date_true() {
        assertThatCode(() -> new Date(10)).doesNotThrowAnyException();
    }

    @Test
    void date_false() {
        assertThatThrownBy(() -> new Date(32)).isInstanceOf(IllegalArgumentException.class);
    }
}
