package christmas.domain.orderinfo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderedAmountTest {
    OrderedAmount orderedAmount;
    @BeforeEach
    void setUp() {
        orderedAmount = new OrderedAmount();
        orderedAmount.addTotalAmount(10000);
    }

    @Test
    @DisplayName("만원이 넘으면 true를 리턴한다.")
    void isOverTenThousand() {
        assertThat(orderedAmount.isOverTenThousand()).isTrue();
    }

    @Test
    @DisplayName("12만원 이상이면 true를 리턴한다.")
    void present_FALSE() {
        assertThat(orderedAmount.present()).isFalse();
    }
    @Test
    @DisplayName("12만원 이상이면 true를 리턴한다.")
    void present_TRUE() {
        orderedAmount.addTotalAmount(200000);
        assertThat(orderedAmount.present()).isTrue();
    }

    @Test
    void addTotalAmount() {
        orderedAmount = new OrderedAmount();
        orderedAmount.addTotalAmount(9999);
        assertThat(orderedAmount.isOverTenThousand()).isFalse();
        orderedAmount.addTotalAmount(1);
        assertThat(orderedAmount.isOverTenThousand()).isTrue();
    }

    @Test
    void discount() {
        orderedAmount.discount(10000);
        assertThat(orderedAmount.totalDiscount()).isEqualTo("-10,000원");
    }

    @Test
    void totalAmount() {
        assertThat(orderedAmount.totalAmount()).isEqualTo("10,000원");
    }

    @Test
    void afterDiscount() {
        orderedAmount.discount(10);
        assertThat(orderedAmount.afterDiscount()).isEqualTo("9,990원");
    }

    @Test
    void getBadge() {
        assertThat(orderedAmount.getBadge().getName()).isEqualTo("트리");
    }
}