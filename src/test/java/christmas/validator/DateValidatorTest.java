package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateValidatorTest {
    @Test
    @DisplayName("입력된 값이 숫자면 검증 성공")
    void isNumber_True() {
        assertThatCode(() -> DateValidator.isNumber("21")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력된 값이 숫자가 아니면 예외를 리턴")
    void isNumber_False() {
        assertThatThrownBy(() -> DateValidator.isNumber("-21")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isInRange_True() {
        assertThatCode(() -> DateValidator.isInRange(31)).doesNotThrowAnyException();
    }

    @Test
    void isInRange_False() {
        assertThatThrownBy(() -> DateValidator.isInRange(32)).isInstanceOf(IllegalArgumentException.class);
    }



}