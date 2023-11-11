package christmas.validator;

import static christmas.domain.promotion.MonthPromotion.MAX_DATE_IN_MONTH;
import static christmas.domain.promotion.MonthPromotion.MIN_DATE_IN_MONTH;
import static christmas.validator.DateValidator.validateDate;
import static christmas.validator.DateValidator.validateInputDate;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DayValidatorTest {
    @Nested
    @DisplayName("validateInputDate 메소드 test")
    class ValidateInputDayTest {
        @DisplayName("빈 값이 입력되면 예외 발생")
        @Test
        void Value_Is_Empty() {
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
        void Value_Is_Number() {
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
        void Value_Is_Not_Number() {
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

    @Nested
    @DisplayName("validateDate 메소드 test")
    class ValidateDayTest {
        @DisplayName("날짜가 " + MIN_DATE_IN_MONTH + "~" + MAX_DATE_IN_MONTH + " 범위에 포함 되면 검증 통과")
        @Test
        void Date_In_Month() {
            // given
            int date1 = 1;
            int date2 = 15;
            int date3 = 31;

            // when
            // then
            validateDate(date1);
            validateDate(date2);
            validateDate(date3);
        }

        @DisplayName("날짜가 " + MIN_DATE_IN_MONTH + "~" + MAX_DATE_IN_MONTH + " 범위에 포함 되지 않으면 예외 발생")
        @Test
        void Date_Not_In_Month() {
            // given
            int date1 = 0;
            int date2 = 32;
            int date3 = -1;
            int date4 = 100;

            // when
            // then
            assertThatThrownBy(() -> validateDate(date1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_DATE_MESSAGE.getMessage());
            assertThatThrownBy(() -> validateDate(date2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_DATE_MESSAGE.getMessage());
            assertThatThrownBy(() -> validateDate(date3))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_DATE_MESSAGE.getMessage());
            assertThatThrownBy(() -> validateDate(date4))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_DATE_MESSAGE.getMessage());
        }
    }
}