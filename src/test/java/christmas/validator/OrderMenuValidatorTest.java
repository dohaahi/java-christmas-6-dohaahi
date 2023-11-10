package christmas.validator;

import static christmas.validator.OrderMenusValidator.validateInputOrderMenus;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.OrderMenus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OrderMenusValidatorTest {
    @Nested
    @DisplayName("validateInputOrderMenu 메소드 test")
    class ValidateInputOrderMenu {
        @DisplayName("빈 값이 입력되면 예외 발생")
        @Test
        void Value_Is_Empty() {
            // given
            String input = "";

            // when
            // then
            assertThatThrownBy(() -> validateInputOrderMenus(input)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.ENTER_VALUE_MASSAGE.getMessage());
        }

        @DisplayName(OrderMenus.DELIMITER + "를 사용하여 메뉴형식을 올바르게 입력하면 검증 통과")
        @Test
        void Input_Valid_Menu_Format() {
            // given
            String input1 = "시저샐러드-1";
            String input2 = "시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1";

            // when
            // then
            validateInputOrderMenus(input1);
            validateInputOrderMenus(input2);
        }

        @DisplayName(OrderMenus.DELIMITER + "외에 다른 구분자를 사용하여 메뉴를 입력하면 예외 발생")
        @Test
        void Invalid_Input_Menu_Delimiter() {
            // given
            String input1 = "시저샐러드-1; 티본스테이크-1; 크리스마1스파스타-1; 제로콜라-3, 아이스크림-1"; // 구분자: ;
            String input2 = "시저샐러드-1. 티본스테이크-1. 크리스마1스파스타-1. 제로콜라-3, 아이스크림-1"; // 구분자: .

            // when
            // then
            assertThatThrownBy(() -> validateInputOrderMenus(input1)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
            assertThatThrownBy(() -> validateInputOrderMenus(input2)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }

        @DisplayName("구분자 사이에 공백이 있는 경우 예외 발생")
        @Test
        void Invalid_Delimiter_With_Spaces() {
            // given
            String input1 = "시저샐러드 - 1";
            String input2 = "시저샐러드 - 1, 티본스테이크 - 1, 크리스마스파스타 - 1, 제로콜라 - 3, 아이스크림 - 1";

            // when
            // then
            assertThatThrownBy(() -> validateInputOrderMenus(input1)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
            assertThatThrownBy(() -> validateInputOrderMenus(input2)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }
    }
}