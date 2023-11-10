package christmas.validator;

import static christmas.validator.DateValidator.validateInputDate;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DateValidatorTest {
    @Nested
    @DisplayName("validateInputDate 메소드 test")
    class ValidateInputDate {
        @DisplayName("빈 값이 입력되면 예외 발생")
        @Test
        void Is_Value_Empty() {
            // given
            String input = "";

            // when
            // then
            assertThatThrownBy(() -> validateInputDate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.ENTER_VALUE_MASSAGE.getMessage());
        }

        @DisplayName("숫자가 입력되면 검증 통과")
        @Test
        void Is_Value_Number() {
            // given
            String input1 = "9";
            String input2 = "100";

            // when
            // then
            validateInputDate(input1);
            validateInputDate(input2);
        }

        @DisplayName("숫자가 아닌 다른 값이 입력되면 예외 발생")
        @Test
        void Is_Value_Not_Number() {
            // given
            String input1 = "가나";
            String input2 = "abc";

            // when
            // then
            assertThatThrownBy(() -> validateInputDate(input1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_NUMBER_MESSAGE.getMessage());
            assertThatThrownBy(() -> validateInputDate(input2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_NUMBER_MESSAGE.getMessage());
        }
    }
}